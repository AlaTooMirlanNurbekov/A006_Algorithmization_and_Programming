/*
    P000_M06 - LONGEST SUBARRAY WITH SUM <= S (BRUTE FORCE O(n^2))

    TASK: given an array of integers and a limit S, find the maximum length of a contiguous subarray
    whose sum is <= S.

    WHY THIS EXISTS (REAL REASON):
    In real systems we often have a "budget":
      - maximum allowed memory
      - maximum cost
      - maximum time
    and we want the largest segment that still stays inside the budget.

    BRUTE FORCE IDEA: try every start index i, extend end index j, track the running sum
    If sum <= S, update the best length

    WHAT THIS PROGRAM PRINTS:
    For each test (array, S), it prints: bestLength
*/

public class P000_M06 {
    static int longestSubarraySumAtMost(int[] a, int S) {
        int n = a.length;
        int bestLen = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum <= S) {
                    int len = j - i + 1;
                    if (len > bestLen) bestLen = len;
                }
            }
        }
        return bestLen;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {3, -1, 2, -2, 5},
                {10, 1, 1, 1},
                {0, 0, 0, 0},
                {-5, -2, -1}
        };
        int[] limits = {6, 3, 3, 0, -3};
        for (int i = 0; i < arrays.length; i++) {
            System.out.println("S=" + limits[i] + " -> " + longestSubarraySumAtMost(arrays[i], limits[i]));
        }
    }
}


// Made by JetiHub - J000