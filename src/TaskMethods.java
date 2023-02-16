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
    static Scanner sc = new Scanner(System.in);
    public void taskAddNew(){
        setCurrentUser();
        System.out.print("Task name: ");
        String task = sc.nextLine();
        System.out.print("Deadline(yyyy-MM-dd HH:mm:ss): ");
        String deadline = sc.nextLine();
        while(!checkCorrectPattern(deadline)){
            System.out.print("Please enter the deadline following this pattern 'yyyy-MM-dd HH:mm:ss': ");
            deadline= sc.nextLine();
        }
        System.out.print("Rate importance from 1-5: ");
        int importance= sc.nextInt();
        insertTask(task, deadline, importance, currentUser.getID());
    }

    public void taskUpdate(){
        taskRead();
        System.out.print("Task name that will be updated:");
        String task = sc.nextLine();
        //check if such task exists
        System.out.print("New task name: ");
        String new_task = sc.nextLine();

        updateTheTask(task, new_task);
    }
    public void taskDelete(){
        System.out.print("Task name that will be deleted: ");
        //check if such task exists
        String task = sc.nextLine();

        deleteTaskByName(task);
    }
    public void taskRead(){
        outputTasks(getUserId(currentUser.getUsername()));
    }


    public boolean checkCorrectPattern(String start_date){
        if (!Pattern.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", start_date)) {
            return false;
        }
        return true;
    }
    public void taskDeadline(){
        setCurrentUser();
        System.out.print("Enter task name: ");
        String task = sc.nextLine();
        String stopDate = searchByTask(task);

        String startDate =String.valueOf(LocalDate.now()) + " " + String.valueOf(LocalTime.now()).substring(0, 8) ;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(Objects.equals(stopDate, null)){
            System.out.print("No such task found!");
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
        System.out.println("Deadline of " + task + " is in: " +Integer.toString(day) + " days " + Long.toString(hours) + " hours " + Long.toString(minute) + " minutes");

    }


}
