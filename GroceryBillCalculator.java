import java.util.Scanner;

public class GroceryBillCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter discount rate as a decimal : ");
        double discountRate = scanner.nextDouble();

        if (discountRate <= 0 || discountRate > 1) {
            System.out.println("Invalid discount. Using default 10%.");
            discountRate = 0.10;
        }

        System.out.print("Enter grocery cost for Week 1: $");
        double weekOneCost = scanner.nextDouble();

        System.out.print("Enter grocery cost for Week 2: $");
        double weekTwoCost = scanner.nextDouble();

        System.out.print("Enter grocery cost for Week 3: $");
        double weekThreeCost = scanner.nextDouble();

        System.out.print("Enter grocery cost for Week 4: $");
        double weekFourCost = scanner.nextDouble();

        double monthlyGroceryTotal = weekOneCost + weekTwoCost + weekThreeCost + weekFourCost;
        double averageWeeklyCost = monthlyGroceryTotal / 4;

        double discountedMonthlyTotal = monthlyGroceryTotal * (1 - discountRate);
        double discountedWeeklyAverage = discountedMonthlyTotal / 4;

        // Round all values to 2 decimal places 
        monthlyGroceryTotal = Math.round(monthlyGroceryTotal * 100.0) / 100.0;
        averageWeeklyCost = Math.round(averageWeeklyCost * 100.0) / 100.0;
        discountedMonthlyTotal = Math.round(discountedMonthlyTotal * 100.0) / 100.0;
        discountedWeeklyAverage = Math.round(discountedWeeklyAverage * 100.0) / 100.0;

        // Results
        System.out.println("\n Grocery Spending Summary ");
        System.out.println("Monthly Total (Before Discount): $" + monthlyGroceryTotal);
        System.out.println("Weekly Average (Before Discount): $" + averageWeeklyCost);
        System.out.println("Monthly Total (After Discount): $" + discountedMonthlyTotal);
        System.out.println("Weekly Average (After Discount): $" + discountedWeeklyAverage);

        scanner.close();
    }
}