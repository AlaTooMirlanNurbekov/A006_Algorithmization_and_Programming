/*
    P000_E17 - PAIR WITH GIVEN SUM (BRUTE FORCE DOUBLE LOOP)

    TASK:
    Given an array and a target sum S, check if there exists a pair (i, j)
    with i < j such that a[i] + a[j] == S.

    BRUTE FORCE IDEA:  try every pair using two loops. If any pair matches, return true

    WHAT THIS PROGRAM PRINTS: For each test (array, S) it prints: true/false
*/

public class P000_E17 {

    static boolean hasPairWithSum(int[] a, int S) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] + a[j] == S) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 1, 7, 3};

        int[] testsS = {10, 8, 14, 20};
        for (int S : testsS) {
            System.out.println(hasPairWithSum(a, S));
        }
    }
}


// Made by JetiHub - J000