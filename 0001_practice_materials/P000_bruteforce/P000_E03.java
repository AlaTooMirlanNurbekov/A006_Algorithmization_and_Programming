/*
    P000_E03 - REVERSE NUMBER (BRUTE FORCE SCAN)

    TASK:
    Given an integer N, reverse its digits
    Example: 120 -> 21, 507 -> 705

    BRUTE FORCE IDEA:
    Read digits from right to left (N % 10)
    and build a new number by shifting previous digits (rev * 10 + digit)

    WHAT THIS PROGRAM PRINTS: For each test number it prints: N -> reversed
*/
public class P000_E03 {

    static int reverseNumber(int n) {
        int sign = n < 0 ? -1 : 1;
        n = Math.abs(n);
        int rev = 0;
        while (n > 0) {
            int digit = n % 10;
            rev = rev * 10 + digit;
            n /= 10;
        }
        return rev * sign;
    }
    public static void main(String[] args) {
        int[] tests = {0, 7, 42, 120, -507};
        for (int n : tests) {
            System.out.println(n + " -> " + reverseNumber(n));
        }
    }
}

// Made by JetiHub - J000
