import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public class TaskMethods extends DBMethods{
    static Registration rg = new Registration();
    static Login lg = new Login();
    public static User currentUser= new User();
    public static void setCurrentUser(){
        if (lg.regOrLog){
            currentUser = lg.getCurrentUser();
        }
        if(rg.regOrLog){
            currentUser=  rg.getCurrentUser();
        }
    }
    Scanner sc = new Scanner(System.in);
    public void taskAddNew(){
        setCurrentUser();
        System.out.println("Task name: ");
        String task = sc.nextLine();
        System.out.println("Deadline(yyyy-MM-dd HH:mm:ss): ");
        String deadline = sc.nextLine();
        while(!checkCorrectPattern(deadline)){
            System.out.println("Please enter the deadline following this pattern 'yyyy-MM-dd HH:mm:ss': ");
            deadline= sc.nextLine();
        }
        System.out.print("Rate importance from 1-5: ");
        String importance= sc.nextLine();
        insertTask(task, deadline, Integer.parseInt(importance), currentUser.getID());
    }

    public void taskUpdate(){
        setCurrentUser();
        taskRead();
        System.out.print("Task name that will be updated:");
        String task = sc.nextLine();
        //check if such task exists
        System.out.print("New task name: ");
        String new_task = sc.nextLine();

        updateTheTask(task, new_task, currentUser.getID());
    }
    public void taskDelete(){
        setCurrentUser();
        System.out.print("Task name that will be deleted: ");
        //check if such task exists
        String task = sc.nextLine();

        deleteTaskByName(task, currentUser.getID());
    }
    public void taskRead(){
        outputTasks(getUserId(currentUser.getUsername()));
    }

    public void sortTaskByImportance(){
        sortByImportance(currentUser.getID());
    }
    public boolean checkCorrectPattern(String start_date){
        if (!Pattern.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", start_date)) {
            return false;
        }
        return true;
    }
    public void taskDeadline(){
        setCurrentUser();
        System.out.println("Enter task name: ");
        String task = sc.nextLine();
        String stopDate = searchByTask(task.toLowerCase(), currentUser.getID());

        String startDate =String.valueOf(LocalDate.now()) + " " + String.valueOf(LocalTime.now()).substring(0, 8) ;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(Objects.equals(stopDate, null)){
            System.out.println("No such task found!");
            stopDate= sc.nextLine();
        }
        Date d1 = null;
        Date d2 = null;
        try {
            d1 = format.parse(startDate);
            d2 = format.parse(stopDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long seconds= (d2.getTime() - d1.getTime())/1000;
        int day = (int) TimeUnit.SECONDS.toDays(seconds);
        long hours = TimeUnit.SECONDS.toHours(seconds) - (day *24);
        long minute = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds)* 60);
        System.out.println("Deadline of \"" + task.toLowerCase() + "\" is in: " +Integer.toString(day) + " days " + Long.toString(hours) + " hours " + Long.toString(minute) + " minutes");

    }
}
