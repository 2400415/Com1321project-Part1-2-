import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

public class BuyVehicle extends Expenses {

    private String model;
    private String make;
    private Double purchasePrice;
    private Double totalDeposit;
    private Double interestRate;
    private Double insurancePremium;

    // Setter methods
    public void setModel(String model) {
        this.model = model;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setTotalDeposit(Double totalDeposit) {
        this.totalDeposit = totalDeposit;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public void setInsurancePremium(Double insurancePremium) {
        this.insurancePremium = insurancePremium;
    }

    // Method to calculate monthly loan payment
    private Double calculateMonthlyLoanPayment() {
        Double loanAmount = purchasePrice - totalDeposit;
        Double monthlyInterestRate = interestRate / 100 / 12;
        int numberOfPayments = 5 * 12; // 5 years
        return (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));
    }

    // Method to calculate total monthly cost
    private Double calculateTotalMonthlyCost() {
        return calculateMonthlyLoanPayment() + insurancePremium;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Do you want to buy a vehicle? (yes/no)");
        String response = input.next();

        if (response.equalsIgnoreCase("yes")) {
            BuyVehicle vehicle = new BuyVehicle();

            // User inputs
            System.out.println("Enter your salary: ");
            Double salary = input.nextDouble();

            System.out.println("Enter the model of the vehicle: ");
            vehicle.setModel(input.next());

            System.out.println("Enter the make of the vehicle: ");
            vehicle.setMake(input.next());

            System.out.println("Enter the purchase price of the vehicle: ");
            vehicle.setPurchasePrice(input.nextDouble());

            System.out.println("Enter the total deposit: ");
            vehicle.setTotalDeposit(input.nextDouble());

            System.out.println("Enter the interest rate (percentage): ");
            vehicle.setInterestRate(input.nextDouble());

            System.out.println("Enter the estimated insurance premium: ");
            vehicle.setInsurancePremium(input.nextDouble());

            // Calculate total monthly cost
            Double totalMonthlyCost = vehicle.calculateTotalMonthlyCost();

            // Add expenses to the list
            List<Double> expenses = new ArrayList<>();
            expenses.add(totalMonthlyCost);

            // Calculate the sum of expenses
            sum = expenses.stream().mapToDouble(Double::doubleValue).sum();

            // Define the limit (75% of salary)
            Double limit = 0.75 * salary;

            // Define the delegate (Consumer) to notify the user
            Consumer<Double> notifyUser = totalExpenses -> {
                if (totalExpenses > limit) {
                    System.out.println("Warning: Your total expenses of " + totalExpenses + " have exceeded 75% of your salary of " + salary + ".");
                }
            };

            // Check expenses and notify if they exceed the limit
            checkExpenses(expenses, limit, notifyUser);

            // Display expenses in ascending order
            Collections.sort(expenses);
            System.out.println("Expenses in ascending order: " + expenses);
        } else {
            System.out.println("Goodbye!");
        }
    }

    public static void checkExpenses(List<Double> expenses, Double limit, Consumer<Double> notifyUser) {
        Double totalExpenses = expenses.stream().mapToDouble(Double::doubleValue).sum();
        notifyUser.accept(totalExpenses);
    }
}

