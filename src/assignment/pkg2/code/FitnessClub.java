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
        System.out.println("Welcome to GG Fitness Club");
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
            System.out.println("0.  Quit program");
            System.out.print("Your choice? ");
            option  = sc.nextInt();
            switch(option)
            {
                case 1: addActivity(act); break;
                case 2: System.out.println(act.getAll());
                        System.out.println("Average MET of all activities:-");
                        System.out.println(act.calcAverageMET());
                        System.out.println("Activity with the highest total cost:-");
                        System.out.println(act.getHighest());
                        break;
                case 3: updateActivityInformation(act); break;
                case 4: ; break;
                case 5: ; break;
                case 6: ; break;
                case 7: ; break;
                case 0: System.out.println("Thank you for using our program. Thank you and have a nice day."); break;
                default: System.out.println("Invalid option."); break;
            }    
        }
        while (option != 0);
    }
    public static void addActivity(ActivityList a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the activity's name: ");
        String activityName = sc.nextLine();
        while (activityName.equals(""))
        {
            System.out.println("No input.");
            System.out.print("Please re-enter the activity's name: ");
            activityName = sc.nextLine();
        }
        Activity act = new Activity(activityName);
        if (a.addActivity(act))
            System.out.printf("Activity &s has been added into the program.", activityName);
        else
            System.out.println("Sorry. The activities list is full. This actitivity couldn't be added in.");
    }
    public static void updateActivityInformation(ActivityList a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which activity's information you wish to change? ");
        String wantedActivity = sc.nextLine();
        Activity foundAct = a.findActivity(wantedActivity);
        if (foundAct == null)
            System.out.printf("This activity %s has not yet stored in the system.", wantedActivity);
        else
        {
            System.out.println("Activity found: " + wantedActivity);
            System.out.println("Please choose to proceed");
            System.out.println("1.  Change duration");
            System.out.println("2.  Change cost");
            System.out.print("Your choice? ");
            int choice = sc.nextInt();
            if (choice == 1)
            {
                System.out.print("Enter new duration: ");
                double duration = sc.nextDouble();
                foundAct.setDurationInHours(duration);
            }
            else if (choice == 2)
            {
                System.out.print("Enter new cost: ");
                double cost = sc.nextDouble();
                foundAct.setCostPerHour(cost);
            }
            else
                System.out.println("Invalid choice.");            
        }        
    }
}
