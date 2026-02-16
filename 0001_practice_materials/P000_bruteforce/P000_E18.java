/*
    P000_E18 - MIN DIFFERENCE PAIR (BRUTE FORCE DOUBLE LOOP)

    TASK:
    Given an array, find the minimum absolute difference between any two elements
    Output the minimum difference value

    BRUTE FORCE IDEA:
    Try every pair (i, j) compute abs(a[i] - a[j]) and keep the smallest

    WHAT THIS PROGRAM PRINTS: fro each test array it prints: minDifference
*/

public class P000_E18 {

    static int minDifference(int[] a) {
        int best = Integer.MAX_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int diff = Math.abs(a[i] - a[j]);
                if (diff < best) best = diff;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {5, 2, 9, 1, 7},
                {10, 10, 10},
                {-3, 8, 0, 2},
                {42},
                {100, 50, 52, 49}
        };
        for (int[] arr : tests) {
            if (arr.length < 2) {
                System.out.println("0");
            } else {
                System.out.println(minDifference(arr));
            }
        }
    }
}


// Made by JetiHub - J000