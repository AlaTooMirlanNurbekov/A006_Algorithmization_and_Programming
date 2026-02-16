/*
    P000_E20 - COUNT PAIRS WITH DIFFERENCE K (BRUTE FORCE DOUBLE LOOP)

    TASK:
    Given an array and an integer K (K >= 0), count how many pairs (i, j) exist such that:
    i < j AND abs(a[i] - a[j]) == K

    BRUTE FORCE IDEA: try every pair using two loops and count pairs that match the difference.

    WHAT THIS PROGRAM PRINTS:
    for each test (array, K) it prints: pairCount
*/

public class P000_E20 {

    static int countPairsWithDiff(int[] a, int K) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (Math.abs(a[i] - a[j]) == K) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7, 3};
        int[] testsK = {0, 2, 4, 10};
        for (int K : testsK) {
            System.out.println(countPairsWithDiff(a, K));
        }
    }
}

// Made by JetiHub - J000
