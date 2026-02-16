/*
    P000_M07 - LONGEST SUBARRAY WITH SUM >= S (BRUTE FORCE O(n^2))

    TASK: given an array and a target S, find the maximum length of a contiguous subarray
    whose sum is >= S

    WHY THIS IS A USEFUL "REAL" PATTERN:
    Imagine you want a period of time where:
      - you earned at least S money
      - or produced at least S units
      - or collected at least S data points
    You want the longest period that meets the threshold

    BRUTE FORCE IDEA: enumerate all subarrays (i..j), compute sums, and keep the best length

    WHAT THIS PROGRAM PRINTS: for each test (array, S), it prints: bestLength
*/

public class P000_M07 {

    static int longestSubarraySumAtLeast(int[] a, int S) {
        int n = a.length;
        int bestLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum >= S) {
                    int len = j - i + 1;
                    if (len > bestLen) bestLen = len;
                }
            }
        }

        return bestLen;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4},
                {3, -1, 2, -2, 5},
                {10, 1, 1, 1},
                {0, 0, 0, 0},
                {-5, -2, -1, 10}
        };

        int[] targets = {6, 4, 12, 1, 5};
        for (int i = 0; i < arrays.length; i++) {
            System.out.println("S=" + targets[i] + " -> " + longestSubarraySumAtLeast(arrays[i], targets[i]));
        }
    }
}


// Made by JetiHub - J000