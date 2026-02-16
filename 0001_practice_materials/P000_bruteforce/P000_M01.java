/*
    P000_M01 - 3SUM EXISTS (BRUTE FORCE TRIPLE LOOP)

    TASK:
    Given an array and a target sum S, check if there exist THREE different indices i<j<k
    such that:
        a[i] + a[j] + a[k] == S

    WHY THIS IS BRUTE FORCE:
    We try every possible triple (i, j, k) and test the sum directly
    This is O(n^3), so it only works for small arrays — that is the lesson

    WHAT THIS PROGRAM PRINTS: for each test (array, S), it prints: true/false
*/

public class P000_M01 {
    static boolean threeSumExists(int[] a, int S) {
        int n = a.length;

        // Pick i, then j, then k. This covers every triple exactly once.
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = a[i] + a[j] + a[k];
                    if (sum == S) return true; // Found one triple -> we can stop immediately
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {-1, 0, 1, 2, -2},
                {10, 20, 30},
                {5, 5, 5, 5},
                {3, 7, 9, 2}
        };
        int[] targets = {9, 0, 60, 16, 100};
        for (int i = 0; i < arrays.length; i++) {
            System.out.println("S=" + targets[i] + " -> " + threeSumExists(arrays[i], targets[i]));
        }
    }
}


// Made by JetiHub - J000