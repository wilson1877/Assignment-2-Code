/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.code;

/**
 * @author Tan Zheliang             B1400653    30.3.2016
 * @author Wilson Chang Kai Mun     B1500510    4.4.2016
 */

import java.util.*;

public class FitnessClub {
    
    public static MemberList members;
    public static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args)
    {
        ActivityList act = new ActivityList(10);
        members = new MemberList(30);
        System.out.println("Welcome to GG Fitness Club");
        System.out.println("");
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
            System.out.println("");
            System.out.print("Your choice? ");
            option  = sc.nextInt();
            System.out.println("");
            
            switch(option)
            {
                case 1: addActivity(act); break;
                case 2: viewActivityInformation(act); break;
                case 3: updateActivityInformation(act); break;
                case 4: addMember(); break;
                case 5: if (members.getNoOfMember() > 0)
                            showMemberInfo();
                        else 
                            System.out.println("No members are added.");
                        break;
                case 6: if (members.getNoOfMember() > 0)
                            changeMemberInfo();
                        else 
                            System.out.println("No members are added.");
                        break;
                case 7: ; break;
                case 0: System.out.println("Thank you for using our program. Thank you and have a nice day."); break;
                default: System.out.println("Invalid option. \n"); break;
            } // end of switch            
        }
        while (option != 0); // end of do-while loop
    } // end of main
    
    public static void addActivity(ActivityList a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the activity's name: ");
        String activityName = sc.nextLine();
        Activity similarActivity = a.findActivity(activityName);
        
        if (similarActivity == null)
        {
            System.out.print("Enter the MET value for " + activityName + " activity: ");
            double MET = sc.nextDouble();
            System.out.print("Enter the duration of " + activityName + " activity done (in hour): ");
            double durationInHours = sc.nextDouble();
            System.out.print("Enter the cost per hour for this " + activityName + " activity: ");
            double costPerHour = sc.nextDouble();
            System.out.println("");
            
            while (activityName.equals(""))
            {
                System.out.println("No input.");
                System.out.print("Please re-enter the activity's name: ");
                activityName = sc.nextLine();
            }
            while (MET <= 0 || MET >= 25)
            {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's MET: ");
                MET = sc.nextDouble();
            }
            while (durationInHours <= 0 || durationInHours >= 100)
            {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's duration: ");
                MET = sc.nextDouble();
            }
            while (costPerHour <= 0 || costPerHour >= 1000)
            {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's cost per hour: ");
                MET = sc.nextDouble();
            }
            
            Activity act = new Activity(activityName, MET, durationInHours, costPerHour);
            if (a.addActivity(act))
            {
                System.out.printf("Activity %s has been added into the program.", activityName);
                System.out.println("\n");
            }
            else
                System.out.println("Sorry. The activities list is full. This actitivity couldn't be added in.");
        }
        else
        {
            System.out.printf("Sorry. %s has already exist in the program.", activityName);
            System.out.println("\n");
        }
    }
    
    public static void viewActivityInformation(ActivityList a)
    {
        System.out.println(a.getAll());
        
        System.out.print("Average MET of all activities: ");
        System.out.println(a.calcAverageMET());
        
        System.out.print("Activity with the highest total cost: ");
        System.out.println(a.getHighest().getActivityName());
        System.out.println("");
    }
    
    public static void updateActivityInformation(ActivityList a)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Which activity's information you wish to change? ");
        String wantedActivity = sc.nextLine();
        Activity foundAct = a.findActivity(wantedActivity);
        if (foundAct == null)
        {
            System.out.printf("This activity %s has not yet stored in the system.", wantedActivity);
            System.out.println("\n");
        }
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
                while (duration <= 0 || duration >= 100)
                {
                    System.out.println("Invalid value.");
                    System.out.print("Please re-enter the activity's new duration: ");
                    duration = sc.nextDouble();
                }
                foundAct.setDurationInHours(duration);
                System.out.println("");
            }
            else if (choice == 2)
            {
                System.out.print("Enter new cost: ");
                double cost = sc.nextDouble();
                while (cost <= 0 || cost >= 1000)
                {
                    System.out.println("Invalid value.");
                    System.out.print("Please re-enter the activity's new cost: ");
                    cost = sc.nextDouble();
                }
                foundAct.setCostPerHour(cost);
                System.out.println("");
            }
            else
                System.out.println("Invalid choice. \n");            
        }        
    }
    
    public static void addMember() {
        String name;
        double mWeight, mHeight;
        System.out.print("Enter the member's name: ");
        name = sc.nextLine();
        while (name.equals("")) {
            System.out.print("Name cannot be blank!\nEnter again: ");
            name = sc.nextLine();
        }
        
        System.out.print("Enter the member's weight (in KG): ");
        mWeight = sc.nextDouble();
        sc.nextLine();
        while (mWeight <= 0 || mWeight >= 200) {
            System.out.print("Please enter a valid weight!\nEnter again: ");
            mWeight = sc.nextDouble();
            sc.nextLine();
        }
        
        System.out.print("Enter the member's height (in M): ");
        mHeight = sc.nextDouble();
        sc.nextLine();
        while (mHeight <= 0 || mHeight >= 2.5) {
            System.out.print("Please enter a valid height!\nEnter again: ");
            mHeight = sc.nextDouble();
            sc.nextLine();
        }
        
        Member newMember = new Member(name, mWeight, mHeight);
        if (members.addMember(newMember))
            System.out.println(newMember.toString() + " has succesfully been added."); 
        else
            System.out.println("Failed to add member due to list being full.");
        
    } // end of add member method
    
    public static void showMemberInfo() {
        System.out.println(members.getAll());
        System.out.print("The highest BMI: ");
        System.out.println(members.highestBMI().getMemberName() 
                + " with a BMI of " + members.highestBMI().getBMI());
        System.out.println("The average weight of all members is: " + members.averageWeight());
    } // end of show info method
    
    public static void changeMemberInfo() {
        double weight, height;
        System.out.print("Enter the name of member to update: ");
        String name = sc.nextLine();
        while (name.equals("")) {
            System.out.println("Name cannot be blank");
            name = sc.nextLine();
        }
        Member updated = members.findMember(name);
        if (updated == null)
            System.out.println("Member not found.");
        else {
            System.out.println("What would you like to change?");
            System.out.println("1. Weight");
            System.out.println("2. Height");
            System.out.print("Your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            while (!(choice == 1 || choice == 2 )) {
                System.out.print("Please select 1 or 2: ");
                choice = sc.nextInt();
                sc.nextLine();
            }
        }
        
    } // end of change member info method
} // end of class
