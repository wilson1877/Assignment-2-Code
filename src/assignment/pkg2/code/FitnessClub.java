/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.code;

/**
 * @author Tan Zheliang                         4.4.2016
 * @author Wilson Chang Kai Mun     B1500510    4.4.2016
 */
import java.util.*;
public class FitnessClub {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ActivityList act = new ActivityList(10);
        System.out.println("Welcome to W&S Fitness Club");
        int option;
        do
        {
            System.out.println("Choose an option:");
            System.out.println("1.  Add activity");
            System.out.println("2.  View all activities' information");
            System.out.println("3.  Update activity's information");
            System.out.println("4.  Add member");
            System.out.println("5.  View all members' information");
            System.out.println("6.  Update member's information");
            System.out.println("7.  Record activities for member");
            System.out.println("8.  Quit program");
            System.out.print("Your choice? ");
            option  = sc.nextInt();
            switch(option)
            {
                case 1: addActivity(act); break;
                case 2: viewActivitiesInformation(act); break;
                case 3: updateActivityInformation(act); break;
                case 4: ; break;
                case 5: ; break;
                case 6: ; break;
                case 7: ; break;
                case 8: System.out.println("Thank you for using our program. Thank you and have a nice day."); break;
                default: System.out.println("Invalid option."); break;
            }    
        }
        while (option != 8);
    }
    public static void addActivity(ActivityList a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the activity's name: ");
        String activityName = sc.nextLine();
        while (activityName.equals(""))
        {
            System.out.println("No input.");
            System.out.println("Please re-enter the activity's name: ");
            activityName = sc.nextLine();
        }
        Activity act = new Activity(activityName);
        if (a.addActivity(act))
            System.out.printf("Activity &s has been added into the program.", activityName);
        else
            System.out.println("Sorry. The activities list is full. This actitivity couldn't be added in.");
    }
    public static Activity viewActivitiesInformation(ActivityList a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an activity to be view: ");
        String wantedActivity = sc.nextLine();
        Activity foundAct = a.findActivity(wantedActivity);
        if (foundAct != null)
        {
            System.out.println(foundAct.toString());
            return foundAct;
        }
        else
        {
            System.out.println("The program has not yet store informartion for this activity.");
            return null;
        }
    }
    public static void updateActivityInformation(ActivityList a)
    {
        
    }
}
