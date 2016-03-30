/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.code;

/**
 *
 * @author Wilson5801
 */
public class ActivityList {
    private final int SIZE = 20;
    private Activity[] activityType;
    private int activityCount;
    
    // Creates an array for activities default to 50
    public ActivityList() {
        activityType = new Activity[SIZE];
        activityCount = 0;
    }
    
    public ActivityList(int inSize) {
        if (inSize > 0) {
            activityType = new Activity[inSize];
        } else {
            activityType = new Activity[SIZE];
        }
        
        activityCount = 0;
    }
    
    public boolean addActivity(Activity newActivity) {
        if (activityType.length == activityCount) {
            return false;
        }
        activityType[activityCount] = newActivity;
        activityCount++;
        return true;
        }
    
    public Activity findActivity(String inName) {
        for (int i = 0 ; i < activityCount ; i++) {
            if (activityType[i].getActivityName().equals(inName)) 
                return activityType[i]; 
            }
        return null;
        }
    
    public double calcAverageMET() {
        double sum = 0;
        for (int i = 0 ; i < activityCount ; i++) {
            sum += activityType[i].getMET();
        }
        
        double average = sum / activityCount;
        return average;
    }
    
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
    
    public String getAll()
    {
        String message = "All members :-";
        for (int j = 0; j < activityCount; j++)
            message += activityType[j].toString() + "\n";
        return message;
    }
}

