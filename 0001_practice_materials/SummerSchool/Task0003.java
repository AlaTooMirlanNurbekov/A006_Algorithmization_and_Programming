import java.util.ArrayList;
import java.util.Scanner;

public class Task0003 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        //Cars that can enter directly
        ArrayList<String> allowedCars =
                new ArrayList<>();
        // Guest cars
        ArrayList<String> guestCars =
                new ArrayList<>();
        System.out.print(
                "Enter number of arriving cars: "
        );
        int numberOfCars = input.nextInt();
        input.nextLine();
        //Read information for every car
        for (int i = 0; i < numberOfCars; i++) {
            System.out.println();
            System.out.print("Enter plate number for car " + (i + 1) + ": ");
            String plateNumber = input.nextLine();
            System.out.print("Enter driver type (student, teacher, guest): ");
            String driverType = input.nextLine();

            driverType = driverType.toLowerCase();

            //Students and teachers can enter directly
            if (driverType.equals("student") || driverType.equals("teacher")) {
                allowedCars.add(plateNumber);
            } 
            else if (driverType.equals("guest")) {
                guestCars.add(plateNumber);
            } 
            else {
                //Unknown driver type
                System.out.println("Invalid driver type.");
            }
        }
        System.out.println();
        System.out.println( "========== PARKING REPORT ==========");
        System.out.println();
        System.out.println("Allowed Cars:");
        if (allowedCars.isEmpty()) {
            System.out.println(
                    "None"
            );
        } 
        else {
            for (String car : allowedCars) {
                System.out.println(
                        car
                );
            }
        }

        System.out.println();
        System.out.println( "Guest Cars (Manual Approval):");
        if (guestCars.isEmpty()) {
            System.out.println("None");
        } 
        else {
            for (String car : guestCars) {
                System.out.println(
                        car
                );
            }
        }
        System.out.println();
        System.out.println("Total Allowed Cars : " + allowedCars.size());
        System.out.println("Total Guest Cars   : " + guestCars.size());
        System.out.println("====================================");
        input.close();
    }
}