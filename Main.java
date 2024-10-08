//this class should be ran first

import java.util.Scanner;

//This class shall contain and store user data & Methods to be shared across all the other child classes

public class Main {

    public static Double GrossIncome; // Make GrossIncome a class variable
    public static Double EstimatedTax; // Make EstimatedTax a class variable


    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        //getting user s data:

        System.out.println("Welcome !! , Please enter the following : ");

        System.out.println("a. Your Gross income(Before deductions) :  ");
        Double GrossIncome=input.nextDouble();

        System.out.println("b. Estimated Tax deduced(Amount) :  ");
        Double EstimatedTax=input.nextDouble();

        //We print the income after tax

        Double IncomeAfterTax = calculateIncomeAfterTax(GrossIncome, EstimatedTax);
        System.out.println("Your Income After Tax is : " + IncomeAfterTax);



    }

    // Method to calculate IncomeAfterTax
    public static Double calculateIncomeAfterTax(Double GrossIncome, Double EstimatedTax) {
        return GrossIncome - EstimatedTax;
    }

}