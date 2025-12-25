import java.util.Scanner;

public class GroceryBillCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter discount rate as a decimal: ");
        double discountRate = scanner.nextDouble();

        // Ensures the discount is between 0 and 1
        if (discountRate <= 0 || discountRate > 1) {
            System.out.println("Invalid discount. Using default 10%.");
            discountRate = 0.10;
        }

        // Using an array to store weekly grocery costs elimnates repeat code
        double[] weeklyCosts = new double[4];

        // Loop to collect weekly grocery costs.
        for (int i = 0; i < weeklyCosts.length; i++) {
            System.out.print("Enter grocery cost for Week " + (i + 1) + ": $");
            weeklyCosts[i] = scanner.nextDouble();
        }

        // Calculate monthly total using a loop, avoids manually adding each week and scales better
        double monthlyGroceryTotal = 0;
        for (double cost : weeklyCosts) {
            monthlyGroceryTotal += cost;
        }

        // Calculate averages.
        double averageWeeklyCost = monthlyGroceryTotal / weeklyCosts.length;

        // Apply discount.
        double discountedMonthlyTotal = monthlyGroceryTotal * (1 - discountRate);
        double discountedWeeklyAverage = discountedMonthlyTotal / weeklyCosts.length;

        // Rounding values to 2 decimal places.
        monthlyGroceryTotal = Math.round(monthlyGroceryTotal * 100.0) / 100.0;
        averageWeeklyCost = Math.round(averageWeeklyCost * 100.0) / 100.0;
        discountedMonthlyTotal = Math.round(discountedMonthlyTotal * 100.0) / 100.0;
        discountedWeeklyAverage = Math.round(discountedWeeklyAverage * 100.0) / 100.0;

    
        System.out.println("\nGrocery Spending Summary");
        System.out.println("------------------------");
        System.out.println("Monthly Total (Before Discount): $" + monthlyGroceryTotal);
        System.out.println("Weekly Average (Before Discount): $" + averageWeeklyCost);
        System.out.println("Monthly Total (After Discount): $" + discountedMonthlyTotal);
        System.out.println("Weekly Average (After Discount): $" + discountedWeeklyAverage);

        scanner.close();
    }
}
