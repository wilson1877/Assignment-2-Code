/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.code;

/**
 *
 * @author TAN ZHELIANG B1400653 21/3/2016
 * Container class for activity.java
 */
public class ActivityList {
    private final int SIZE = 10;
    private Activity[] activityType;
    private int activityCount;
    
    // Creates an array for activities default to 10
    public ActivityList() {
        activityType = new Activity[SIZE];
        activityCount = 0;
    }
    
    // Create array with determined size
    public ActivityList(int inSize) {
        if (inSize > 0) {
            activityType = new Activity[inSize];
        } else {
            activityType = new Activity[SIZE];
        }
        
        activityCount = 0;
    }
    
    // Adds activity into array
    public boolean addActivity(Activity newActivity) {
        if (activityType.length == activityCount) {
            return false;
        }
        activityType[activityCount] = newActivity;
        activityCount++;
        return true;
        }
    
    // Finds and returns activity based on given name
    public Activity findActivity(String inName) {
        for (int i = 0 ; i < activityCount ; i++) {
            if (activityType[i].getActivityName().equalsIgnoreCase(inName)) 
                return activityType[i]; 
            }
        return null;
        }
    
    // Calculate the average MET in the array
    public double calcAverageMET() {
        double sum = 0;
        for (int i = 0 ; i < activityCount ; i++) {
            sum += activityType[i].getMET();
        }
        
        double average = sum / activityCount;
        return average;
    }
    
    // Returns activity with highest Total cost
    public Activity getHighest() {
        double highestTotal = 0;
        int index = 0;
        for (int i = 0 ; i < activityCount ; i++) {
            if (highestTotal < activityType[i].totalCost()) {
                highestTotal = activityType[i].totalCost();
                index = i;
            }
        }
        return activityType[index];
    }
    
    // Return all activities in the list
    public String getAll() {
        String message = "Activities :- \n";
        for (int i = 0; i < activityCount; i++)
            message += activityType[i].toString() + "\n";
        return message;
    }
    
    // Returns all available activities member can join
    public String getActivityList() {
        String message = "Available activities :\n";
        for (int i = 0 ; i < activityCount; i++)
            message += (i+1) + ". " + activityType[i].getActivityName() + "\n";
        return message;
    }
    
    // Returns number of activities stored
    public int getActivityCount() {
        return activityCount;
    }
    
    // Returns activity based on position
    public Activity getActivity(int i) {
        return activityType[i];
    }
    
    // Removes activity from the activity list
    public Activity[] removeActivity(Activity act) {
        for (int i = 0; i < activityCount; i++) {
            if (act.getActivityName().equalsIgnoreCase(activityType[i].getActivityName())) {
                activityType[i] = null;
                activityCount --;
            }
        }
        
        for (int i = 0; i < activityCount; i++) {
            if (activityType[i] == null) {
                activityType[i] = activityType[i+1];
                activityType[i+1] = null;
            }
        }
        
        return activityType;
    }
}

