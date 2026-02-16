/*
    P000_M09 - MIN SUBARRAY SUM (BRUTE FORCE O(n^2))

    TASK:
    Given an array find the minimum sum of any contiguous subarray

    WHY THIS EXISTS (REAL WORLD):
    In finance, this can represent the worst continuous loss period
    In performance monitoring, it can represent the worst continuous drop

    BRUTE FORCE IDEA: Enumerate all subarrays (i..j)
    Maintain running sum as we extend j, track the smallest sum seen

    WHAT THIS PROGRAM PRINTS: for each test array, it prints: minSum
*/

public class P000_M09 {

    static int minSubarraySumBrute(int[] a) {
        int n = a.length;
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum < best) best = sum;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, -2, 3, 4, -1},
                {-5, -1, -8},
                {5, 4, 3},
                {2, -1, 2, -1, 2},
                {0, 0, 0}
        };
        for (int[] arr : tests) {
            System.out.println(minSubarraySumBrute(arr));
        }
    }
}

// Made by JetiHub - J000
