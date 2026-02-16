/*
    P000_E31 - TWO-DIGIT NUMBERS WITH GIVEN DIGIT SUM (BRUTE FORCE ENUMERATION)

    TASK: Given an integer S, print the first two-digit number (10..99) whose digits sum to S
    If no such number exists, print: NONE

    BRUTE FORCE IDEA:
    We literally try every two-digit number from 10 to 99
    For each number, we compute:
      tens = n / 10
      ones = n % 10
    If tens + ones == S, we found the answer

    WHAT THIS PROGRAM PRINTS: For each test S, it prints either the first matching number or NONE
*/

public class P000_E31 {

    static String firstTwoDigitWithSum(int S) {
        // Try every possible two-digit number
        for (int n = 10; n <= 99; n++) {
            int tens = n / 10;
            int ones = n % 10;

            if (tens + ones == S) {
                return String.valueOf(n);
            }
        }
        return "NONE";
    }

    public static void main(String[] args) {
        int[] tests = {1, 5, 10, 18, 19};
        for (int S : tests) {
            System.out.println("S=" + S + " -> " + firstTwoDigitWithSum(S));
        }
    }
}


// Made by JetiHub - J000