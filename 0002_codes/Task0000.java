import java.util.ArrayList;
import java.util.Scanner;

public class Task0000 {

    public static void addItem(
            String name,
            double price,
            ArrayList<String> names,
            ArrayList<Double> prices,
            ArrayList<Integer> quantities) {

        int index = names.indexOf(name);

        if (index != -1) {

            quantities.set(
                    index,
                    quantities.get(index) + 1
            );

        } else {

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

    public static void displayCurrentOrder(
            ArrayList<String> names,
            ArrayList<Double> prices,
            ArrayList<Integer> quantities) {

        System.out.println(
                "======================================"
        );
        System.out.println(
                "CURRENT ORDER"
        );
        System.out.println(
                "======================================"
        );

        if (names.isEmpty()) {

            System.out.println(
                    "No items selected."
            );

            return;
        }

        double total = 0;

        for (int i = 0; i < names.size(); i++) {

            double subtotal =
                    prices.get(i)
                            * quantities.get(i);

            total += subtotal;

            System.out.println(
                    (i + 1)
                            + ". "
                            + names.get(i)
                            + " - "
                            + prices.get(i)
                            + " som"
                            + " (x"
                            + quantities.get(i)
                            + ")"
            );
        }

        System.out.println(
                "--------------------------------------"
        );

        System.out.printf(
                "Current Total: %.2f som%n",
                total
        );
    }

    public static void clearScreen() {

        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }

    public static void pause(
            Scanner input) {

        System.out.println(
                "\nPress Enter to continue..."
        );

        input.nextLine();
        input.nextLine();
    }

     public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> itemNames = new ArrayList<>();
        ArrayList<Double> itemPrices = new ArrayList<>();
        ArrayList<Integer> itemQuantities = new ArrayList<>();

        while (true) {

            clearScreen();

            displayCurrentOrder(
                    itemNames,
                    itemPrices,
                    itemQuantities
            );

            System.out.println();
            System.out.println("========== ALA-TOO CAFETERIA ==========");
            System.out.println("1. Tea       - 20 som");
            System.out.println("2. Samsa     - 70 som");
            System.out.println("3. Salad     - 120 som");
            System.out.println("4. Rice meal - 180 som");
            System.out.println("5. Cancel item");
            System.out.println("6. Exit and pay");
            System.out.println("======================================");

            System.out.print("Choose option: ");

            if (!input.hasNextInt()) {
                System.out.println("\nWrong input. Please try again.");
                input.next();
                pause(input);
                continue;
            }

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    addItem(
                            "Tea",
                            20,
                            itemNames,
                            itemPrices,
                            itemQuantities
                    );
                    break;

                case 2:
                    addItem(
                            "Samsa",
                            70,
                            itemNames,
                            itemPrices,
                            itemQuantities
                    );
                    break;

                case 3:
                    addItem(
                            "Salad",
                            120,
                            itemNames,
                            itemPrices,
                            itemQuantities
                    );
                    break;

                case 4:
                    addItem(
                            "Rice meal",
                            180,
                            itemNames,
                            itemPrices,
                            itemQuantities
                    );
                    break;

                case 5:

                    if (itemNames.isEmpty()) {

                        System.out.println("\nOrder is empty.");
                        pause(input);
                        break;
                    }

                    System.out.println("\nItems in order:");

                    for (int i = 0; i < itemNames.size(); i++) {

                        System.out.println(
                                (i + 1)
                                        + ". "
                                        + itemNames.get(i)
                                        + " (x"
                                        + itemQuantities.get(i)
                                        + ")"
                        );
                    }

                    System.out.print(
                            "\nEnter item number to remove: "
                    );

                    if (!input.hasNextInt()) {

                        System.out.println(
                                "Wrong input. Please try again."
                        );

                        input.next();
                        pause(input);
                        break;
                    }

                    int removeIndex =
                            input.nextInt() - 1;

                    if (removeIndex >= 0 &&
                            removeIndex < itemNames.size()) {

                        int quantity =
                                itemQuantities.get(removeIndex);

                        if (quantity > 1) {

                            itemQuantities.set(
                                    removeIndex,
                                    quantity - 1
                            );

                        } else {

                            itemNames.remove(removeIndex);
                            itemPrices.remove(removeIndex);
                            itemQuantities.remove(removeIndex);
                        }

                        System.out.println(
                                "Item removed successfully."
                        );

                    } else {

                        System.out.println(
                                "Wrong input. Please try again."
                        );
                    }

                    pause(input);
                    break;

                case 6:

                    double total = calculateTotal(
                            itemPrices,
                            itemQuantities
                    );

                    double discount = 0;

                    if (total > 500) {
                        discount = total * 0.10;
                    }

                    double finalPayment =
                            total - discount;

                    clearScreen();

                    System.out.println(
                            "========== RECEIPT =========="
                    );

                    System.out.printf(
                            "Total before discount : %.2f som%n",
                            total
                    );

                    System.out.printf(
                            "Discount amount       : %.2f som%n",
                            discount
                    );

                    System.out.printf(
                            "Final payment         : %.2f som%n",
                            finalPayment
                    );

                    System.out.println(
                            "============================="
                    );

                    input.close();
                    return;

                default:

                    System.out.println(
                            "\nWrong input. Please try again."
                    );

                    pause(input);
            }
        }
    }
}




