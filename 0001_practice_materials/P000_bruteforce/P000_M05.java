/*
    P000_M05 - COUNT SUBARRAYS WITH SUM S (BRUTE FORCE O(n^2))

    TASK:
    Given an array and a target sum S, count how many contiguous subarrays
    have sum exactly S

    WHY THIS IS BRUTE FORCE:
    We try all subarrays (i..j) and compute their sums
    This is O(n^2) using the "extend end" technique

    WHAT THIS PROGRAM PRINTS:
    For each test (array, S) it printss: count
*/

public class P000_M05 {

    static int countSubarraysWithSum(int[] a, int S) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum == S) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 0, 3},
                {0, 0, 0},
                {3, -1, -2, 5, -5},
                {2, 2, 2},
                {1, -1, 1, -1}
        };

        int[] targets = {3, 0, 0, 4, 0};

        for (int i = 0; i < arrays.length; i++) {
            System.out.println("S=" + targets[i] + " -> " + countSubarraysWithSum(arrays[i], targets[i]));
        }
    }
}


// Made by JetiHub - J000