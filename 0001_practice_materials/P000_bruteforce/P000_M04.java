/*
    P000_M04 - MAX SUBARRAY SUM (BRUTE FORCE O(n^2))

    TASK: given an array, find the maximum sum of any contiguous subarray
    (Subarray means consecutive elements.)

    WHY THIS IS BRUTE FORCE:
    We try all possible subarrays by choosing:
      start index i
      end index j
    and computing their sum

    Note:
    There is a faster algorithm (Kadane), but we intentionally do brute force here to train enumeration thinking

    WHAT THIS PROGRAM PRINTS: for each test array, it prints: maxSum
*/

public class P000_M04 {

    static int maxSubarraySumBrute(int[] a) {
        int n = a.length;
        int best = Integer.MIN_VALUE;

        //fix start
        for (int i = 0; i < n; i++) {
            int sum = 0; // we will extend the end and update sum progressively

            //extend end
            for (int j = i; j < n; j++) {
                sum += a[j];
                if (sum > best) best = sum;
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
            System.out.println(maxSubarraySumBrute(arr));
        }
    }
}


// Made by JetiHub - J000