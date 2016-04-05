/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.code;

/**
 *
 * @author Wilson Chang Kai Mun     B1500510    17.3.2016
 */
public class Activity {
    
    //instant variables
    private String activityName;
    private double MET;
    private double durationInHours;
    private double costPerHour;
    
    //default constructor with no arguments
    public Activity()
    {
        activityName = "not set";
        MET = 0.0;
        durationInHours = 0.0;
        costPerHour = 0.0;
    }
    
    //default constructor with no arguments
    public Activity(String InActivityName, double InMET, double InDurationInHours, double InCostPerHour)
    {
        if (!InActivityName.equals(""))
            activityName = InActivityName;
        else
            activityName  = "not set";
        
        if (InMET > 0)
            MET = InMET;
        else
            MET = 0.0;
        
        if (InDurationInHours > 0)
            durationInHours = InDurationInHours;
        else
            durationInHours = 0.0;
        
        if (InCostPerHour > 0)
            costPerHour = InCostPerHour;
        else
            costPerHour = 0.0;  
    }
    
    //activity name getter
    public String getActivityName()
    {
        return activityName;
    }
    
    //MET getter
    public double getMET()
    {
        return MET;
    }
    
    //duration in hours getter
    public double getDurationInHours()
    {
        return durationInHours;
    }
    
    //cost per hour getter
    public double getCostPerHour()
    {
        return costPerHour;
    }
    
    //activity name setter
    public void setActivityName(String InActivityName)
    {
        if (!InActivityName.equals(""))    
            activityName = InActivityName;
    }
    
    //MET setter
    public void setMET(double InMET)
    {
        if (InMET > 0)
            MET = InMET;
    }
    
    //duration in hours setter
    public void setDurationInHours(double InDurationInHours)
    {
        if (InDurationInHours > 0)
            durationInHours = InDurationInHours;
    }
    
    //cost per hour setter
    public void setCostPerHour(double InCostPerHour)
    {
        if (InCostPerHour >= 0)
            costPerHour = InCostPerHour;
    }
    
    @Override
    //display information about the activity
    public String toString()
    {
        return "Activity: " + activityName + " has MET of " + MET + " with duration of "
                + durationInHours + " hours which costs RM" + costPerHour + " per hour.";
    }
    
    //calculate total cost of an activity
    public double totalCost()
    {
        if (costPerHour > 0 && durationInHours > 0)
            return costPerHour * durationInHours;
        else
            return 0;   //return 0 if no cost and no duration entered
    }
}
