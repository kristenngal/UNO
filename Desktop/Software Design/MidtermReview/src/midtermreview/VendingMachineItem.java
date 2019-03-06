/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package midtermreview;

import java.util.Scanner;

/**
 * A class that models vending machine items.
 * Items have a name and a price. The possible items are listed in the
 * array called Candies. Use this code to answer questions
 * B.1 and B.2 in the midterm review.
 * @author dancye, 2019
 */
public class VendingMachineItem 
{
    public double price;
    public static String [] candies = {"chocolate bar", "sour candy", "soft drink", "potato chips"};
    public VendingMachineItem()
    {
        //intentionally left blank
    }

    public static String[] getCandies() {
        return candies;
    }
    
    /**
     * A getter method to return the item's price
     * @return the cost of the item
     */
    public double getPrice()
    {
        return price;
    }

    public static void setCandies(String[] candies) {
        VendingMachineItem.candies = candies;
    }
    
    /**
     * A setter for the price, allowing us to change the price of an item
     * @param givenPrice 
     */
    public void setPrice(double givenPrice)
    {
        price = givenPrice;
    }
    
    /**
     * A method to ask the user to select am item from the vending machine.
     * @param args - not used
     */
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the vendin machine, here is a list of the possible candies");
        for(int i=0; i<candies.length; i++)
        {
            System.out.println(candies[i]);
        }
        System.out.println("To re-fill the vending machine, please follow instructions in program 2");
        //there is no program 2 because we haven't created an approprite design for this code yet!
    }
    
}
