//this class should be ran second (after main class).

    import java.util.Scanner;

    abstract class Expenses extends Main {

        public static Double sum = 0.0;

        // Method to calculate RemainingMoney after deducting the "personal" expenses which are stored in the array.

        public static Double RemainingMoney(Double IncomeAfterTax, Double sum) {
            return IncomeAfterTax - sum;
        }


        public static void main(String[]args){


            Scanner input = new Scanner(System.in);


            // Ensure GrossIncome and EstimatedTax are initialized
            if (GrossIncome == null || EstimatedTax == null) {
                System.out.println("Please enter the following details:");

                System.out.println("a. Your Gross income (Before deductions) :  ");
                GrossIncome = input.nextDouble();

                System.out.println("b. Estimated Tax deducted :  ");
                EstimatedTax = input.nextDouble();
            }


            //getting amount spent on personal expenses

            System.out.println("Amount to be spent on Groceries : ");
            Double GroceryAmount=input.nextDouble();

            System.out.println("Amount to be spent on water and lights : ");
            Double WaterAndElectricityAmount=input.nextDouble();

            System.out.println("Amount to be spent on Travel costs(including petrol) : ");
            Double TravelAmount=input.nextDouble();

            System.out.println("Amount to be spent on Cellphone and Telephone : ");
            Double CellphoneAndTelephone=input.nextDouble();

            System.out.println("Amount to be spent on other expenses :");
            Double OtherAmounts=input.nextDouble();

//Store the expenses in an Array.

            Double [] Expenses = new Double[5]; // Declaring the array.

            Expenses[0] = GroceryAmount;

            Expenses[1] = WaterAndElectricityAmount;

            Expenses[2] =TravelAmount ;

            Expenses[3] = CellphoneAndTelephone;

            Expenses[4] = OtherAmounts;

            Double sum = 0.0;

            // Loop through the array elements and add them to the sum variable
            for (int i = 0; i < Expenses.length; i++) {
                sum += Expenses[i];
            }

            // Print the sum of these expenses.
            System.out.println("The personal expenses add up to : " + sum);

            // Calculate Remaining Money
            Double IncomeAfterTax = calculateIncomeAfterTax(GrossIncome, EstimatedTax); // Use the EstimatedTax entered by the user
            Double RemainingAmount = RemainingMoney(IncomeAfterTax, sum);
            System.out.println("Remaining Amount after paying these personal(Including tax on income) expenses is : " + RemainingAmount);


        }

}
