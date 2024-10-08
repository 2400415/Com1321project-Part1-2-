
import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

import java.util.function.Consumer;

abstract class Expenses extends Main {

    public static Double sum = 0.0;

    // Method to calculate RemainingMoney after deducting the "personal" expenses which are stored in the list.
    public static Double RemainingMoney(Double IncomeAfterTax, Double sum) {
        return IncomeAfterTax - sum;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Ensure GrossIncome and EstimatedTax are initialized
        if (GrossIncome == null || EstimatedTax == null) {
            System.out.println("Please enter the following details:");

            System.out.println("a. Your Gross income (Before deductions) :  ");
            GrossIncome = input.nextDouble();

            System.out.println("b. Estimated Tax deducted :  ");
            EstimatedTax = input.nextDouble();
        }

        // Getting amount spent on personal expenses
        System.out.println("Amount to be spent on Groceries : ");
        Double GroceryAmount = input.nextDouble();

        System.out.println("Amount to be spent on water and lights : ");
        Double WaterAndElectricityAmount = input.nextDouble();

        System.out.println("Amount to be spent on Travel costs (including petrol) : ");
        Double TravelAmount = input.nextDouble();

        System.out.println("Amount to be spent on Cellphone and Telephone : ");
        Double CellphoneAndTelephone = input.nextDouble();

        System.out.println("Amount to be spent on other expenses :");
        Double OtherAmounts = input.nextDouble();

        // Store the expenses in a List
        List<Double> expenses = new ArrayList<>();
        expenses.add(GroceryAmount);
        expenses.add(WaterAndElectricityAmount);
        expenses.add(TravelAmount);
        expenses.add(CellphoneAndTelephone);
        expenses.add(OtherAmounts);

        // Calculate the sum of expenses
        sum = expenses.stream().mapToDouble(Double::doubleValue).sum();

        // Define the limit (75% of GrossIncome - EstimatedTax)
        Double limit = 0.75 * (GrossIncome - EstimatedTax);

        // Define the delegate (Consumer) to notify the user
        Consumer<Double> notifyUser = totalExpenses -> {
            if (totalExpenses > limit) {
                System.out.println("Warning: Your total expenses of " + totalExpenses + " have exceeded 75% of your limit of " + limit + ".");
            }
        };

        // Check expenses and notify if they exceed the limit
        checkExpenses(expenses, limit, notifyUser);
    }

    public static void checkExpenses(List<Double> expenses, Double limit, Consumer<Double> notifyUser) {
        Double totalExpenses = expenses.stream().mapToDouble(Double::doubleValue).sum();
        notifyUser.accept(totalExpenses);
    }
}
