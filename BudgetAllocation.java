import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class BudgetAllocation {
    public static void main(String[] args) {
        // Ask user for total spending amount
        System.out.println("How much can you spend?");
        Scanner scan = new Scanner(System.in);
        double total = scan.nextDouble();

        double sum = 0;
        Map<String, Double> proportion = new HashMap<String, Double>();
        // Ask user for expense proportions
        System.out.println("Enter your proportion of various expenses.");
        System.out.println("Type 'done' to stop entering expenses.");
        while (true) {
            // Ask user for expense type
            System.out.println("Enter an expense type (or 'done' to exit):");
            String type = scan.next();
            if (type.equals("done")) {
                // Exit input loop if user enters "done"
                break;
            }
            // Ask user for proportion of this expense type
            System.out.println("Your proportion of " + type + " expenses:");
            double value = scan.nextDouble();
            sum += value;
            if (sum > 100) {
                // Handle error if total proportion exceeds 100%
                System.out.println("Proportions exceed 100%. Re-enter the last proportion.");
                sum -= value;
            } else {
                proportion.put(type, value);
            }
        }
        scan.close();

        // Calculate and display expense amounts for each expense type
        for (String type : proportion.keySet()) {
            double value = proportion.get(type);
            double expense = value * total / 100.0;
            // Display expense amount for this expense type
            System.out.println("Your " + value + "% for " + type + " expenses equals $" + expense);
        }
    }
}
