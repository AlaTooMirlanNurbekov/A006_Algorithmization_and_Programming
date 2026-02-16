/*
    P000_E09 - COUNT PRIMES IN RANGE (BRUTE FORCE)

    TASK:
    Given two integers L and R, count how many prime numbers are in [L, R].

    BRUTE FORCE IDEA:
    For every number x in the range:
        - check if x is prime using trial division
        - count the primes

    WHAT THIS PROGRAM PRINTS:for each test (L, R), it prints: L..R -> primeCount
*/

public class P000_E09 {

    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int d = 2; d <= n - 1; d++) {
            if (n % d == 0) return false;
        }
        return true;
    }
    static int countPrimesInRange(int L, int R) {
        int count = 0;

        for (int x = L; x <= R; x++) {
            if (isPrime(x)) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        int[] Ls = {1, 10, -5};
        int[] Rs = {10, 30, 10};

        for (int i = 0; i < Ls.length; i++) {
            int L = Ls[i];
            int R = Rs[i];
            System.out.println(L + ".." + R + " -> " + countPrimesInRange(L, R));
        }
    }
}

// Made by JetiHub - J000
