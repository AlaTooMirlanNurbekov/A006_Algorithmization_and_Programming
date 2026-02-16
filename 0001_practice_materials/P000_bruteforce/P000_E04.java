/*
    P000_E04 - PALINDROME NUMBER (BRUTEFORCE CHECK)

    TASK:
    Given an integer N check if it reads the same forward and backward
    Examples:
        121 -> true
        123 -> false
        -121 -> false (we treat negative as not palindrome)

    BRUTE FORCE IDEA: reverse the number and compare it to the original

    WHAT THIS PROGRAM PRINTS: For each test number it prints: N -> true/false
*/

public class P000_E04 {

    static int reversePositive(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + (n % 10);
            n /= 10;
        }
        return rev;
    }
    static boolean isPalindromeNumber(int n) {
        if (n < 0) return false;
        return n == reversePositive(n);
    }

    public static void main(String[] args) {
        int[] tests = {0, 7, 11, 121, 123, -121, 1001, 120};
        for (int n : tests) {
            System.out.println(n + " -> " + isPalindromeNumber(n));
        }
    }
}

// Made by JetiHub - J000
