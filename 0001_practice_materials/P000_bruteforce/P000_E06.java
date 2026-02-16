/*
    P000_E06 - COUNT DIVISORS (BRUTE FORCE CHECK)

    TASK:
    Given an integer N (N > 0), count how many divisors it has
    A divisor is a number d such that N % d == 0

    BRUTE FORCE IDEA: Try every d from 1 to N and count the ones that divide N

    WHAT THIS PROGRAM PRINTS: For each test number it prints: N -> divisorCount
*/

public class P000_E06 {
    static int countDivisors(int n) {
        if (n <= 0) return 0;
        int count = 0;
        for (int d = 1; d <= n; d++) {
            if (n % d == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] tests = {1, 6, 10, 28, 36};
        for (int n : tests) {
            System.out.println(n + " -> " + countDivisors(n));
        }
    }
}


// Made by JetiHub - J000
