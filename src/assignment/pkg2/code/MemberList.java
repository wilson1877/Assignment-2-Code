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
    
    private final int SIZE = 50;
    private Member[] customer;
    private int numOfCustomer;
    
    public MemberList()
    {
        customer = new Member[SIZE];
        numOfCustomer = 0;
    }
    
    public MemberList(int size)
    {
        if (size < 0)
            customer = new Member[SIZE];
        else
            customer = new Member[size];
        numOfCustomer = 0;
    }
    
    public boolean addMember(Member custo)
    {
        if (numOfCustomer == customer.length)
            return false;
        customer[numOfCustomer++] = custo;
        return true;
    }
    
    public Member findMember(String name)
    {
        for (int j = 0; j < numOfCustomer; j++)
            if (customer[j].getMemberName().equals(name))
                return customer[j];
        return null;
    }
    
    public Member highestBMI()
    {
        double highestBmi = 0.0;
        int customerPos = 0;
        for (int j = 0; j < numOfCustomer; j++)
            if (highestBmi < customer[j].getBMI())
            {
                highestBmi = customer[j].getBMI();
                customerPos = j;
            }
        return customer[customerPos];
    }
    
    public double averageWeight(double weight)
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
    
    public String getAll()
    {
        String message = "All members :-";
        for (int j = 0; j < numOfCustomer; j++)
            message += customer[j].toString() + "\n";
        return message;
    }
}
