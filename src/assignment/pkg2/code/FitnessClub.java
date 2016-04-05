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
        ActivityList act = new ActivityList(5);    //array of max 5 activities
        members = new MemberList(10);   //array of max 10 members
        System.out.println("Welcome to GG Fitness Club");
        System.out.println("");
        int option;
        
        do      //menu
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
            sc.nextLine();
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
                case 7: recordInfo(act); break;
                case 0: System.out.println("Thank you for using our program. Thank you and have a nice day."); break;
                default: System.out.println("Invalid option. \n"); break;
            } // end of switch   
            
        }
        while (option != 0); // end of do-while loop
        
    } // end of main
    
    //add activity
    public static void addActivity(ActivityList a)
    {
        System.out.print("Enter the activity's name: ");
        String activityName = sc.nextLine();
        Activity similarActivity = a.findActivity(activityName);
        
        //if no similar activity stored in the program
        if (similarActivity == null)
        {
            //input cannot leave blank
            while (activityName.equals(""))
            {
                System.out.println("No input.");
                System.out.print("Please re-enter the activity's name: ");
                activityName = sc.nextLine();
            }
            
            System.out.print("Enter the MET value for " + activityName + " activity: ");
            double MET = sc.nextDouble();
            while (MET <= 0 || MET >= 25)
            {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's MET: ");
                MET = sc.nextDouble();
            }
            
            System.out.print("Enter the duration of " + activityName + " activity done (in minutes): ");
            double durationInMin = sc.nextDouble();
            while (durationInMin <= 0 || durationInMin >= 750)
            {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's duration: ");
                durationInMin = sc.nextDouble();
            }
            double durationInHours = (durationInMin / 60);
            
            System.out.print("Enter the cost per hour for this " + activityName + " activity: ");
            double costPerHour = sc.nextDouble();
            while (costPerHour <= 0 || costPerHour >= 1000)
            {
                System.out.println("Invalid value.");
                System.out.print("Please re-enter the activity's cost per hour: ");
                costPerHour = sc.nextDouble();
            }
            
            System.out.println("");
            //activity recorded as an array
            Activity act = new Activity(activityName, MET, durationInHours, costPerHour);
            
            //if activity is added into the program
            if (a.addActivity(act))
            {
                System.out.printf("Activity %s has been added into the program.", activityName);
                System.out.println("\n");
            }
            //latest activity cannot be stored
            else
                System.out.println("Sorry. The activities list is full. This actitivity couldn't be added in. \n");
        }
        //user prompt in activity already present in the program
        else
        {
            System.out.printf("Sorry. %s has already exist in the program.", activityName);
            System.out.println("\n");
        }
    } //end of addActivity
    
    //view activity's information
    public static void viewActivityInformation(ActivityList a)
    {
        //display all activities' information
        System.out.println(a.getAll());
        
        //calculate and display average MET
        System.out.print("Average MET of all activities: ");
        System.out.println(a.calcAverageMET());
        
        //calculate and display activity with the highest total cost
        System.out.print("Activity with the highest total cost: ");
        System.out.println(a.getHighest().getActivityName());
        System.out.println("");
    } //end of viewActivityInformation
    
    //change an activity's information
    public static void updateActivityInformation(ActivityList a)
    {
        System.out.print("Which activity's information you wish to change? ");
        String wantedActivity = sc.nextLine();
        
        //input cannot be blank
        while (wantedActivity.equals(""))
            {
                System.out.println("No input.");
                System.out.print("Please re-enter the activity's name: ");
                wantedActivity = sc.nextLine();
            }
        
        Activity foundAct = a.findActivity(wantedActivity);
        
        //no activity found
        if (foundAct == null)
        {
            System.out.printf("This activity %s has not yet stored in the system.", foundAct.getActivityName());
            System.out.println("\n");
        }
        else
        {
            System.out.println("Activity found: " + foundAct.getActivityName());
            System.out.println("");
            System.out.println("Please choose to proceed");
            System.out.println("1.  Change duration");
            System.out.println("2.  Change cost");
            System.out.print("Your choice? ");
            int choice = sc.nextInt();
            
            if (choice == 1)
            {
                System.out.print("Enter new duration: ");
                double duration = sc.nextDouble();
                
                while (duration <= 0 || duration >= 750)
                {
                    System.out.println("Invalid value.");
                    System.out.print("Please re-enter the activity's new duration: ");
                    duration = sc.nextDouble();
                }
                //set new duration
                double betterDuration = duration / 60;
                foundAct.setDurationInHours(betterDuration);
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
                //set new cost
                foundAct.setCostPerHour(cost);
                System.out.println("");
            }
            else
                System.out.println("Invalid choice. \n");            
        }        
    } //end of updateActivityInformation
    
    // Add member method
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
        System.out.println("");
        
        Member newMember = new Member(name, mWeight, mHeight);
        if (members.addMember(newMember))
            System.out.println(newMember.toString() + " has succesfully been added."); 
        else
            System.out.println("Failed to add member due to list being full.");
        
    } // end of add member method
    
    // Show all member information method
    public static void showMemberInfo() {
        System.out.println(members.getAll());
        System.out.print("The highest BMI: ");
        System.out.println(members.highestBMI().getMemberName() 
                + " with a BMI of " + members.highestBMI().getBMI());
        System.out.println("The average weight of all members is: " + members.averageWeight());
    } // end of show info method
    
    // Update member info method
    public static void changeMemberInfo() {
        double weight, height;
        System.out.print("Enter the name of member to update: ");
        String name = sc.nextLine();
        while (name.equals("")) {
            System.out.println("Name cannot be blank\nEnter again: ");
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
            
            if (choice == 1) {
                System.out.print("Enter weight:");
                weight = sc.nextDouble();
                sc.nextLine();
                while (weight <= 0 || weight >= 200) {
                    System.out.print("Please enter a valid weight!\nEnter again: ");
                    weight = sc.nextDouble();
                    sc.nextLine();
                }
                updated.setMemberWeight(weight);
                System.out.println("Succesfully updated");
            } // end of first condition
            else {
                System.out.print("Enter height:");
                height = sc.nextDouble();
                sc.nextLine();
                while (height <= 0 || height >= 2.5) {
                    System.out.print("Please enter a valid height!\nEnter again: ");
                    height = sc.nextDouble();
                    sc.nextLine();
                }
                updated.setMemberHeight(height);
                System.out.println("Succesfully updated");
            } // end of else condition
        }
        
    } // end of change member info method
    
    // record member's activity
    public static void recordInfo(ActivityList a) 
    {
        String activity;
        Activity found;
        System.out.print("Enter the name of member to record: ");
        String name = sc.nextLine();
        
        // input cannot be blank
        while (name.equals("")) {
            System.out.print("Name cannot be blank! Enter again: ");
            name = sc.nextLine();
        }
        
        Member recorded = members.findMember(name);
        
        //member not found
        if (recorded == null)
            System.out.println("No such member exists");
        else {
            int choice;
            ActivityList tempList = recorded.cloneList(a);
            do {
                System.out.println("");
                System.out.println("1. Add activity for member");
                System.out.println("2. View member BMI");
                System.out.println("3. View total cost of all activities");
                System.out.println("4. View total calories burned");
                System.out.println("5. View activities member has joined");
                System.out.println("0. Quit");
                System.out.print("Your choice: ");
                choice = sc.nextInt();
                sc.nextLine();
                System.out.println("");
                
                switch (choice) {
                    case 1:
                        if (tempList.getActivityCount() == 0)
                            System.out.println("No more available activities");
                        else {
                            System.out.println(tempList.getActivityList());
                            System.out.print("Enter activity name: ");
                            activity = sc.nextLine();
                            System.out.println("");
                        
                            // input cannot be blank
                            while (activity.equals(""))
                                {
                                    System.out.println("No input.");
                                    System.out.print("Please re-enter the activity's name: ");
                                    activity = sc.nextLine();
                                }
                            found = a.findActivity(activity);
                        
                            //activity not found
                            if (found == null)
                                System.out.println("No such activity exists");
                            else {
                                recorded.getActivityList().addActivity(found);
                                System.out.println("Activity recorded! \n");
                                tempList.removeActivity(found);
                            
                                // calculate cost for this activity
                                double cost = found.totalCost();
                                // sum up cost
                                recorded.increaseTotalCost(cost);
                            
                                // calculate calories burned for this activity
                                double caloriesBurned = (found.getDurationInHours() *
                                        found.getMET() * recorded.getMemberWeight());
                                // sum up calories burned
                                recorded.increaseTotalCaloriesBurned(caloriesBurned);
                            
                                System.out.printf("This activity costs RM%.2f\n" ,cost);
                                System.out.printf("Calories burned while doing this activity is %.2fkcal.\n",
                                    caloriesBurned);
                            } // end of nested else
                        } // end of else
                        
                        break;
                    case 2:
                        System.out.printf("%s has a BMI of %.2f",recorded.getMemberName(),recorded.getBMI());
                        System.out.println("");
                        break;
                    case 3:
                        System.out.printf("The total cost of all activities: RM%.2f\n"
                        ,recorded.getTotalCost());
                        break;
                    case 4:
                        System.out.printf("The total calories burned from all activities: %.2fkcal\n"
                        ,recorded.getTotalCaloriesBurned());
                        break;
                    case 5:    
                        System.out.printf("This member %s has joined: ", recorded.getMemberName());
                        System.out.println("");
                        System.out.println(recorded.getActivityList().getAll());
                        break;
                    case 0:
                        System.out.println("End.");
                        break;
                    default:
                        System.out.println("Invalid choice. \n");
                        break;
                }
            } while (choice != 0); //end of do-while loop
            
        }
    } // end of recordInfo method
    

} // end of class
