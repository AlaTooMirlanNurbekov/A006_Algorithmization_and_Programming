/*
    P000_E15 - CHECK SORTED (BRUTE FORCE SCAN)

    TASK: given an array, check if it is sorted in non-decreasing order
    That means: a[i] <= a[i+1] for all valid i

    BRUTE FORCE IDEA:
    Scan adjacent pairs. If any pair is out of order it is not sorted

    WHAT THIS PROGRAM PRINTS:
    For each test array, it prints: true/false
*/

public class P000_E15 {

    static boolean isSortedNonDecreasing(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 2, 2, 5, 9},
                {5, 4, 3, 2, 1},
                {1},
                {1, 3, 2},
                {-10, -5, 0, 0, 7}
        };

        for (int[] arr : tests) {
            System.out.println(isSortedNonDecreasing(arr));
        }
    }
}


// Made by JetiHub - J000