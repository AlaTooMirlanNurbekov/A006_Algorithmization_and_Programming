/*
    P000_Z12 - SUBSET SUM WITH EXACTLY K ELEMENTS

    TASK: given an array a, a target sum S, and an integer K
    Check if there exists a subset of exactly K elements
    whose sum equals S

    IDEA: Try every subset with a bitmask
    Count how many elements are chosen
    If chosen count is K, compute sum and compare with S

    WHAT THIS PROGRAM PRINTS: true or false for each test case
*/

public class P000_Z12 {

    static boolean subsetSumExactlyK(int[] a, int S, int K) {
        int n = a.length;
        int total = 1 << n;

        for (int mask = 0; mask < total; mask++) {
            if (Integer.bitCount(mask) != K) continue;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) sum += a[i];
            }

            if (sum == S) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[] a1 = {3, 5, 7, 10};
        System.out.println(subsetSumExactlyK(a1, 15, 2));
        System.out.println(subsetSumExactlyK(a1, 15, 3));
        System.out.println(subsetSumExactlyK(a1, 17, 2));

        int[] a2 = {1, 2, 4, 8, 16};
        System.out.println(subsetSumExactlyK(a2, 10, 2));
        System.out.println(subsetSumExactlyK(a2, 10, 3));
    }
}

// Made by JetiHub - J000