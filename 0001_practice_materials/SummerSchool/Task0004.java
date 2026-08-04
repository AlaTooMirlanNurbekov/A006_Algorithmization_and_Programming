import java.util.Scanner;

public class Task0004 {
    public static String getUsageStatus(
            double usage) {
        if (usage > 300) {
            return "High Usage";
        }
        return "Normal Usage";
    }
    public static double calculateTotalUsage(
            double[] usages) {
            double total = 0;
        for (int i = 0; i < usages.length; i++) {
            total += usages[i];
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print( "Enter number of rooms: ");
        int numberOfRooms = input.nextInt();
        String[] roomNumbers = new String[numberOfRooms];
        double[] usages = new double[numberOfRooms];
        int highUsageRooms = 0;
        //Read information for every room
        for (int i = 0; i < numberOfRooms; i++) {
            System.out.println();
            System.out.print( "Enter room number: " );
            roomNumbers[i] = input.next();
            System.out.print( "Enter electricity usage (kWh): " );
            usages[i] = input.nextDouble();
            //Count rooms that exceed the limit
            if (usages[i] > 300) { highUsageRooms++;}
        }
        double totalUsage = calculateTotalUsage( usages );
        double averageUsage = totalUsage / numberOfRooms;
        System.out.println();
        System.out.println( "========== ELECTRICITY REPORT ==========");
        //Display information for every room
        for (int i = 0; i < numberOfRooms; i++) {
            System.out.println( "Room Number : " + roomNumbers[i]);
            System.out.println( "Usage       : "  + usages[i]  + " kWh");
            System.out.println("Status      : " + getUsageStatus( usages[i]));
            System.out.println( "----------------------------------------");
        }
        System.out.printf( "Total Usage          : %.2f kWh%n", totalUsage);
        System.out.printf( "Average Usage        : %.2f kWh%n", averageUsage);
        System.out.println( "High Usage Rooms     : " + highUsageRooms);
        System.out.println( "========================================");
        input.close();
    }
}
