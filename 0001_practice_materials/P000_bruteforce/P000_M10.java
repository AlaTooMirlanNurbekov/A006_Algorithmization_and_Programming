/*
    P000_M10 - MIN LENGTH SUBARRAY WITH SUM >= S (BRUTE FORCE O(n^2))

    TASK:
    Given an array and a target sum S, find the minimum length of a contiguous subarray
    whose sum is >= S. If no such subarray exists, return 0

    WHY THIS IS A PRACTICAL PROBLEM:
    You want the smallest time window that reaches a goal:
      - minimum days to earn S revenue
      - minimum packets to reach S bytes
      - minimum readings to reach S total

    BRUTE FORCE IDEA:
    For each start i, extend j until sum >= S.
    When it happens, update the minimum length

    WHAT THIS PROGRAM PRINTS: for each test (array, S), it prints: minLength
*/

public class P000_M10 {

    static int minLengthSubarrayAtLeast(int[] a, int S) {
        int n = a.length;
        int best = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum >= S) {
                    int len = j - i + 1;
                    if (len < best) best = len;
                    break; // for this i, longer j will only increase length
                }
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {2, 3, 1, 2, 4, 3},
                {1, 1, 1, 1},
                {5, -1, 2, 3},
                {10, 1, 1}
        };

        int[] targets = {11, 7, 10, 6, 12};

        for (int i = 0; i < arrays.length; i++) {
            System.out.println("S=" + targets[i] + " -> " + minLengthSubarrayAtLeast(arrays[i], targets[i]));
        }
    }
}


// Made by JetiHub - J000