package assignment.pkg2.code;

/**
 *
 * @author TAN ZHELIANG B1400653 12/3/2016  
 */
 
 // Class for member
public class Member {

    /**
     * @param args the command line arguments
     */
    // Initialise variables
    private String name;
    private double weightInKg, heightInM;
    
    // No argument constructor
    public Member() {
        name = "Unassigned";
        weightInKg = 0.0;
        heightInM = 0.0;
    }
    
    // Constructor with arguments
    public Member(String inName, double inWeight, double inHeight) {
        if (!inName.equals(" ")) {
            name = inName;
        } 
        else {
            name = "Unassigned";
        }
        if (inWeight > 0) {
            weightInKg = inWeight;
        } 
        else {
            weightInKg = 0.0;
        }
        
        if (inHeight > 0) {
            heightInM = inHeight;
        } 
        else {
            heightInM = 0.0;
        }
    }
    
    // Getter methods
    public String getMemberName() {
        return name;
    }
    
    public double getMemberWeight() {
        return weightInKg;
    }
    
    public double getMemberHeight() {
        return heightInM;
    }
    
    // Setter methods
    public void setMemberName(String inName) {
        if (!inName.equals(" ")) {
            name = inName;
        } 
    }
    
    public void setMemberWeight(double inWeight) {
        if (inWeight > 0) {
            weightInKg = inWeight;
        }
    }
    
    public void setMemberHeight(double inHeight) {
        if (inHeight > 0) {
            heightInM = inHeight;
        }
    }
    
    // toString method
    public String toString() {
        return "Club member: " + name + " with weight: " + weightInKg + "KG and height: " + heightInM +
                "M";
    }
    
    // calculate BMI method
    public double getBMI() {
        return weightInKg / (heightInM * heightInM);
    }
}