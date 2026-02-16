/*
    P000_E16 - COUNT EQUAL PAIRS (BRUTE FORCE DOUBLE LOOP)

    TASK:
    Given an array, count how many pairs (i, j) exist such that:
    i < j AND a[i] == a[j]

    BRUTE FORCE IDEA: try every pair using two loops and count matches

    WHAT THIS PROGRAM PRINTS:for each test array it prints: pairCount
*/

public class P000_E16 {

    static int countEqualPairs(int[] a) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] == a[j]) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 2, 3, 2, 1},
                {5, 5, 5},
                {1, 2, 3, 4},
                {7},
                {2, 2, 2, 3, 3}
        };

        for (int[] arr : tests) {
            System.out.println(countEqualPairs(arr));
        }
    }
}


// Made by JetiHub - J000