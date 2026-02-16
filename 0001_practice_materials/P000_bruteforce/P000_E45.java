/*
    P000_E45 - SUBSET SUM EXISTS (BRUTE FORCE SUBSETS)

    TASK:given an array of integers and a target sum S,
    check if there exists any subset whose sum equals S.
    If yes, print true, otherwise print false.

    BRUTE FORCE IDEA:
    Try every subset using a bitmask:
      - bit i = 1 means we take a[i]
      - bit i = 0 means we skip a[i]
    Compute subset sum and stop at the first success.

    WHAT THIS PROGRAM PRINTS: for each test, it prints: true/false
*/

public class P000_E45 {

    static boolean subsetSumExists(int[] a, int S) {
        int n = a.length;
        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;

            // Build the sum of this subset
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    sum += a[i];
                }
            }

            if (sum == S) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 5, 7, 10};
        int[] a2 = {1, 2, 4, 8};
        int[] testsS = {10, 15, 6, 14};

        for (int S : testsS) {
            System.out.println("S=" + S + " -> " + subsetSumExists(a1, S));
        }
        System.out.println();
        for (int S : testsS) {
            System.out.println("S=" + S + " -> " + subsetSumExists(a2, S));
        }
    }
}


// Made by JetiHub - J000