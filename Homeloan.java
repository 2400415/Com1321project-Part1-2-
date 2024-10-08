// this class should be ran third after (Expenses has been ru)

    import java.util.Scanner;

    public class Homeloan extends Expenses {

        //This method shall display accomodation options to user

        public static void DisplayOptions(){

            System.out.println(" Select accomodation option(Choose a number only): ");

            System.out.println(" 1. Rental accomodation(renting)\n 2. purchase property ");
        }

        //method for calculating the monthly home loan repayment.


        public static double calculateMonthlyRepayment(double PropertyAmount, double DepositAmount, double Percentageinterest, int PayingMonths) {
            // Calculates the loan amount
            double loanAmount = PropertyAmount - DepositAmount;

            // Converts annual interest rate percentage to a monthly rate

            double monthlyInterestRate = (Percentageinterest / 100) / 12;

            // Calculate the monthly repayment using the formula for an annuity
            double MonthlyRepayment = (loanAmount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate, -PayingMonths));

            return MonthlyRepayment;
        }

        // Method to calculate AvailableMonthlyMoney
        public static double AvailableMonthlyMoney(double RemainingMoney, double MonthlyRepayment) {
            return RemainingMoney - MonthlyRepayment;
        }



        public static void main(String[]args){

            DisplayOptions();

            // we take input.

            Scanner input=new Scanner(System.in);
            int AccomodationChoice=input.nextInt();

            if(AccomodationChoice==1){

                //This is for the rental option.

                System.out.println("Enter the rental amount of the accomodation:  ");
                Double RentalAmount=input.nextDouble();//taking the amount.

                System.out.println("Input Accepted !.");

            }else if(AccomodationChoice==2){

                // This is for the purchase rental.

                //we take information related to the home loan

                System.out.println("Enter the Purchase price amount(of the property): ");
                Double PropertyAmount=input.nextDouble();

                System.out.println("Enter the total deposit : ");
                Double DepositAmount=input.nextDouble();

                System.out.println("Enter the interest rate(in percentage ): ");
                Double Percentageinterest=input.nextDouble();

                System.out.println("Enter the number of months to pay(between 240 and 360): ");
                int PayingMonths=input.nextInt();


                //now we calculate the monthly repayment amount.


                double MonthlyRepayment = calculateMonthlyRepayment(PropertyAmount, DepositAmount, Percentageinterest, PayingMonths);
                System.out.println("Monthly Repayment amount is : " + MonthlyRepayment);

                //we check if the monthy loan repayment is a third of users gross income

                // Ensures that exeptions do not occur related to variable GrossIncome and EstimatedTax.
                if (GrossIncome == null || EstimatedTax == null) {
                    System.out.println("Please enter the following details:");

                    System.out.println("a. Your Gross income (Before deductions) :  ");
                    GrossIncome = input.nextDouble();

                    System.out.println("b. Estimated Tax deducted :  ");
                    EstimatedTax = input.nextDouble();
                }

                //determining third of amount
                Double ThirdOfAmount=GrossIncome/3.0;

                if(MonthlyRepayment>ThirdOfAmount){

                    System.out.println("Alert !!! Loan is unlikely ");

                }else{System.out.println("Loan Should be taken");   }

                // Calculate Remaining Money
                Double IncomeAfterTax = calculateIncomeAfterTax(GrossIncome, EstimatedTax); // Use the EstimatedTax entered by the user

                Double RemainingAmount = RemainingMoney(IncomeAfterTax, sum); // Assuming sum is calculated in Expenses class

                Double AvailableMoney = AvailableMonthlyMoney(RemainingAmount, MonthlyRepayment);

                System.out.println("Available Monthly Money after monthly repayment of the house: " + AvailableMoney);



            }else{

                // This is for when wrong input was given instead of provided options.

                System.out.println("invalid input , Try again .");

            }


        }
    }
