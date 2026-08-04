import java.util.Scanner;

public class Task0002 {
    //Calculate the average score of all students
    public static double calculateAverage(
            int[] scores,
            int numberOfStudents) {
        int total = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            total += scores[i];
        }
        return (double) total / numberOfStudents;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print( "Enter number of students: " );
        int numberOfStudents = input.nextInt();
        // array to  store all scores
        int[] scores = new int[numberOfStudents];
        int highestScore = 0;
        int lowestScore = 0;
        int passedStudents = 0;
        int failedStudents = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            System.out.print("Enter score for student " + (i + 1) + ": ");
            scores[i] = input.nextInt();
            // for the first student, use the score as both highest and lowest
            if (i == 0) {
                highestScore = scores[i];
                lowestScore = scores[i];
            }
            if (scores[i] > highestScore) {
                highestScore = scores[i];
            }
            if (scores[i] < lowestScore) {
                lowestScore = scores[i];
            }
            if (scores[i] >= 50) {
                passedStudents++;
            } else {
                failedStudents++;
            }
        }
        double averageScore = calculateAverage(scores,numberOfStudents);
        System.out.println();
        System.out.println("========== QUIZ REPORT ==========");
        System.out.println("Highest Score : "+ highestScore);
        System.out.println("Lowest Score  : "+ lowestScore);
        System.out.printf("Average Score : %.2f%n",averageScore);
        System.out.println("Passed Students : " + passedStudents);
        System.out.println("Failed Students : "+ failedStudents);
        System.out.println("=================================");
        input.close();
    }
}