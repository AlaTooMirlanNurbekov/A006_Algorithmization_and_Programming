/*
    P000_E47 - BEST SUBSET SUM UNDER LIMIT (BRUTE FORCE)

    TASK:
    Given an array of positive integers and a limit S
    find the maximum subset sum that does NOT exceed S
    (If all numbers exceed S, answer can be 0 by choosing the empty set)

    BRUTE FORCE IDEA:
    Try every subset.Compute its sum
    If sum <= S, it is a valid candidate.
    Keep the best (largest) valid sum.

    WHAT THIS PROGRAM PRINTS: for each test limit S, it prints: bestSum
*/

public class P000_E47 {

    static int bestSubsetSumUnder(int[] a, int S) {
        int n = a.length;
        int total = 1 << n;
        int best = 0;

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    sum += a[i];
                }
            }
            if (sum <= S && sum > best) {
                best = sum;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 7, 10};

        int[] limits = {1, 10, 11, 14, 17, 100};

        for (int S : limits) {
            System.out.println("S=" + S + " -> " + bestSubsetSumUnder(a, S));
        }
    }
}

// Made by JetiHub - J000