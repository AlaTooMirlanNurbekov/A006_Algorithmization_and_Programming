/*
    P000_E02 - SUM OF DIGITS (BRUTE FORCE SCAN)

    TASK: Given an integer N compute the sum of its digits

    BRUTE FORCE IDEA:
        Peel digits one by one using:
            digit = N % 10
            N = N / 10
        Add each digit to the sum

    WHAT THIS PROGRAM PRINTS: for each test number it prints: N -> digitSum
*/

public class P000_E02 {
    static int digitSum(int n) {
        n = Math.abs(n);
        int sum = 0;
        //keep taking the last digit until no digits remain
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] tests = {0, 7, 42, 1000, -987654};
        for (int n : tests) {
            System.out.println(n + " -> " + digitSum(n));
        }
    }
}

// Made by JetiHub - J000
