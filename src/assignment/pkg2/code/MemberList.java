/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2.code;

/**
 *
 * @author Wilson Chang Kai Mun     B1500510    27.3.2016
 */
public class MemberList {
    
    private final int SIZE = 10;
    private Member[] customer;  //array of Member objects
    private int numOfCustomer;
    
    //constructor which sets to default size
    public MemberList()
    {
        customer = new Member[SIZE];
        numOfCustomer = 0;
    }
    
    //constuctor which sets to size passed in
    public MemberList(int size)
    {
        if (size < 0)
            customer = new Member[SIZE];
        else
            customer = new Member[size];
        numOfCustomer = 0;
    }
    
    //method to add member
    public boolean addMember(Member custo)
    {
        //return false if the list is full
        if (numOfCustomer == customer.length)
            return false;
        customer[numOfCustomer++] = custo;
        return true;
    }
    
    //method to find a particular member
    public Member findMember(String name)
    {
        for (int j = 0; j < numOfCustomer; j++)
            if (customer[j].getMemberName().equalsIgnoreCase(name))
                return customer[j];
        return null;    //not found
    }
    
    //method to calculate highest BMI
    public Member highestBMI()
    {
        double highestBmi = 0;
        int customerPos = 0;
        for (int j = 0; j < numOfCustomer; j++)
            if (highestBmi < customer[j].getBMI())
            {
                highestBmi = customer[j].getBMI();
                customerPos = j;
            }
        return customer[customerPos];   //return customer position in array
    }
    
    //method to calculate average weight
    public double averageWeight()
    {
        double total = 0.0;
        double average = 0.0;
        for (int j = 0; j < numOfCustomer; j++)
        {
            total += customer[j].getMemberWeight();
            average = total / numOfCustomer;
        }
        return average;    
    }
    
    //method to return all information of every members stored
    public String getAll()
    {
        String message = "All members :\n";
        for (int j = 0; j < numOfCustomer; j++)
            message += customer[j].toString() + "\n";
        return message;
    }
    
    //method to return total number of member
    public int getNoOfMember()
    {
        return numOfCustomer;
    }
}
