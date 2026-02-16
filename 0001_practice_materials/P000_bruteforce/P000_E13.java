/*
    P000_E13 - FIRST OCCURRENCE (BRUTE FORCE LINEAR SEARCH)

    TASK: given an array and a value X, find the first index where X appears
    If X does not exist, return -1

    BRUTE FORCE IDEA:
    Scan from left to right and stop on the first match

    WHAT THIS PROGRAM PRINTS:for each test, it prints: X -> firstIndex
*/

public class P000_E13 {

    static int firstIndexOf(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 2, 7, 2, 1};

        int[] testsX = {2, 7, 1, 10};
        for (int x : testsX) {
            System.out.println(x + " -> " + firstIndexOf(a, x));
        }
    }
}


// Made by JetiHub - J000