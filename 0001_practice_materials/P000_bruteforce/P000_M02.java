/*
    P000_M02 - 3SUM COUNT (BRUTE FORCE TRIPLE LOOP)

    TASK:
    Given an array and a target sum S, count how many triples (i<j<k) satisfy:
        a[i] + a[j] + a[k] == S

    WHY THIS IS BRUTE FORCE:
    Same as M01, but instead of stopping at the first success, we count every successful triple

    WHAT THIS PROGRAM PRINTS: for each test (array, S), it prints: count
*/

public class P000_M02 {

    static int threeSumCount(int[] a, int S) {
        int n = a.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] + a[j] + a[k] == S) count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {0, 0, 0, 0},
                {-1, 0, 1, 2, -2},
                {5, 5, 5, 5, 5},
                {2, 2, 2, 2}
        };

        int[] targets = {9, 0, 0, 15, 6};

        for (int i = 0; i < arrays.length; i++) {
            System.out.println("S=" + targets[i] + " -> " + threeSumCount(arrays[i], targets[i]));
        }
    }
}


// Made by JetiHub - J000