import java.util.Scanner;

public class Task0001 {
    //Calculate the fine for one book based on overdue days
    public static double calculateFine(int overdueDays) {
        //15 som for every overdue day
        double fine = overdueDays * 15;

        //If the book is overdue for more than 10 days then add an extra penalty of 50 som
        if (overdueDays > 10) {
            fine += 50;
        }
        return fine;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //number of books
        System.out.print("Enter number of returned books: ");
        int numberOfBooks = input.nextInt();
        int[] overdueDays = new int[numberOfBooks];
        //Store the fine for each book
        double[] fines = new double[numberOfBooks];
        double totalFine = 0;
        //overdue days for every book
        for (int i = 0; i < numberOfBooks; i++) {
            System.out.print("Enter overdue days for book " + (i + 1) + ": ");
            overdueDays[i] = input.nextInt();
            //Calculate fine
            fines[i] = calculateFine( overdueDays[i]);
            //Add  fine to  total
            totalFine += fines[i];
        }
        System.out.println();
        System.out.println("========== LIBRARY FINES ==========");
        //Display fine for every book
        for (int i = 0; i < fines.length; i++) {

            System.out.printf( "Book %d Fine: %.2f som%n", (i + 1), fines[i]);
        }
        System.out.println("-----------------------------------");
        System.out.printf( "Total Fine: %.2f som%n", totalFine );
        input.close();
    }
}