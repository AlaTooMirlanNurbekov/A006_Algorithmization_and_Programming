/*
    P000_E35 - COUNT COPRIME PAIRS (BRUTE FORCE DOUBLE LOOP)

    TASK:
    Given N, count how many pairs (a, b) exist such that:
      1 <= a <= N
      1 <= b <= N
      gcd(a, b) == 1
    Such pairs are called coprime pairs.

    BRUTE FORCE IDEA:
    We try every pair (a, b) and compute gcd(a, b) using brute-force checking.
    (Not Euclid yet — this is intentionally "World One" style.)

    WHAT THIS PROGRAM PRINTS: For each N, it prints: N -> count
*/

public class P000_E35 {
    static int gcdBrute(int a, int b) {
        int best = 1;
        int limit = Math.min(a, b);

        // Check every possible divisor
        for (int d = 1; d <= limit; d++) {
            if (a % d == 0 && b % d == 0) {
                best = d;
            }
        }
        return best;
    }
    static int countCoprimePairs(int N) {
        int count = 0;

        for (int a = 1; a <= N; a++) {
            for (int b = 1; b <= N; b++) {
                if (gcdBrute(a, b) == 1) {
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] tests = {1, 2, 3, 5, 10};
        for (int N : tests) {
            System.out.println(N + " -> " + countCoprimePairs(N));
        }
    }
}


// Made by JetiHub - J000