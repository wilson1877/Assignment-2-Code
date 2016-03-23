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
    
    private String activityName;
    private double MET;
    private double durationInHours;
    private double costPerHour;
    
    public Activity()
    {
        activityName = "not set";
        MET = 0.0;
        durationInHours = 0.0;
        costPerHour = 0.0;
    }
    
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
        
        durationInHours = 0.0;
        
        costPerHour = 0.0;    
    }
    
    public String getActivityName()
    {
        return activityName;
    }
    
    public double getMET()
    {
        return MET;
    }
    
    public double getDurationInHours()
    {
        return durationInHours;
    }
    
    public double getCostPerHour()
    {
        return costPerHour;
    }
    
    public void setActivityName(String InActivityName)
    {
        if (!InActivityName.equals(""))    
            activityName = InActivityName;
    }
    
    public void setMET(double InMET)
    {
        if (InMET > 0)
            MET = InMET;
    }
    
    public void setDurationInHours(double InDurationInHours)
    {
        if (InDurationInHours > 0)
            durationInHours = InDurationInHours;
    }
    
    public void setCostPerHour(double InCostPerHour)
    {
        if (InCostPerHour >= 0)
            costPerHour = InCostPerHour;
    }
    
    @Override
    public String toString()
    {
        return "You in " + activityName + " with MET of " + MET + " have play " + durationInHours + " hrs which cost RM" + costPerHour + " per hour. Thank you for playing. Have a nice day.";
    }
    
    public double totalCost()
    {
        if (costPerHour > 0 && durationInHours > 0)
            return costPerHour * durationInHours;
        else
            return 0;
    }
}
