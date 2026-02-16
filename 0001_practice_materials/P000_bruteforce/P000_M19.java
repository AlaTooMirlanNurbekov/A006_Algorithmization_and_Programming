/*
    P000_M19 - PARTITION MIN DIFFERENCE

    TASK: given an array of integers, split it into two groups (A and B)
    such that the absolute difference |sum(A) - sum(B)| is minimized.
    Output the minimum possible difference.

    THE IDEA: Each element either goes into group A or group B.
    That is exactly a bitmask decision:
    - bit = 1 -> goes to A
    - bit = 0 -> goes to B
    Try all 2^n masks and keep the best difference.

    OUTPUT: for each test array, it prints: minDifference
*/

public class P000_M19 {

    static int minPartitionDifference(int[] a) {
        int n = a.length;
        int totalMasks = 1 << n;
        int best = Integer.MAX_VALUE;

        for (int mask = 0; mask < totalMasks; mask++) {
            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) sumA += a[i];
                else sumB += a[i];
            }
            int diff = Math.abs(sumA - sumB);
            if (diff < best) best = diff;
        }

        return best;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 2, 3, 4},
                {10, 20, 15},
                {5, 5, 5, 5},
                {7},
                {3, 9, 8, 2}
        };
        for (int[] arr : tests) {
            System.out.println(minPartitionDifference(arr));
        }
    }
}


// Made by JetiHub - J000