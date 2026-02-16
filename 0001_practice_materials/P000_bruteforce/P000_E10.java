/*
    P000_E10 - GREATEST DIVISOR LESS THAN N (BRUTE FORCE)

    TASK:
    Given an integer N (N > 1) find the largest divisor of N that is smaller than N
    Example: N = 10 -> 5, N = 15 -> 5, N = 13 -> 1 (prime number)

    BRUTE FORCE IDEA: Try all numbers d from N-1 down to 1 The first d that divides N is the answer

    WHAT THIS PROGRAM PRINTS:
    For each test number it prints: N -> greatestDivisorBelowN
*/

public class P000_E10 {
    
    static int greatestDivisorBelowN(int n) {
        if (n <= 1) return 0;
        for (int d = n - 1; d >= 1; d--) {
            if (n % d == 0) return d;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        int[] tests = {2, 6, 10, 15, 13, 36};
        for (int n : tests) {
            System.out.println(n + " -> " + greatestDivisorBelowN(n));
        }
    }
}

// Made by JetiHub - J000
