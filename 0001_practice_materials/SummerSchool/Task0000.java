import java.util.ArrayList;
import java.util.Scanner;

public class Task0000 {
    //To add an item to the order. If the item already exists then increase its quantity, otherwise create a new entry
    public static void addItem(
            String name,
            double price,
            ArrayList<String> names,
            ArrayList<Double> prices,
            ArrayList<Integer> quantities) {
        //this one is to search for the item in the current order
        int index = names.indexOf(name);
        if (index != -1) {

            //Item already exists -> increase quantity
            quantities.set(
                    index,
                    quantities.get(index) + 1
            );
        } else {
            // Item not found, so we add it as a new entry
            names.add(name);
            prices.add(price);
            quantities.add(1);
        }
    }
    public static double calculateTotal(
            ArrayList<Double> prices,
            ArrayList<Integer> quantities) {
        double total = 0;
        for (int i = 0; i < prices.size(); i++) {
            total += prices.get(i)
                    * quantities.get(i);
        }
        return total;
    }
    //This part is to displays all items currently selected by the customer
    public static void displayCurrentOrder(
            ArrayList<String> names,
            ArrayList<Double> prices,
            ArrayList<Integer> quantities) {
        System.out.println( "======================================");
        System.out.println( "CURRENT ORDER");
        System.out.println( "======================================");
        //handle empty orders
        if (names.isEmpty()) {
            System.out.println("No items selected.");
            return;
        }
        double total = 0;
        for (int i = 0; i < names.size(); i++) {
            //to calculate subtotal for the current item
            double subtotal =
                    prices.get(i)
                            * quantities.get(i);
            total += subtotal;
            System.out.println((i + 1) + ". " + names.get(i) + " - " + prices.get(i) + " som" + " (x" + quantities.get(i) + ")");
        }
        System.out.println( "--------------------------------------");
        System.out.printf( "Current Total: %.2f som%n", total);
    }
    //Simulates clearing the console by printing multiple empty lines
    public static void clearScreen() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
    //Pauses execution until the user presses Enter.
    public static void pause(
            Scanner input) {
        System.out.println( "\nPress Enter to continue...");
        input.nextLine();
        input.nextLine();
    }
}
