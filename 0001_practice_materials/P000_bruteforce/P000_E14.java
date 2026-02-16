/*
    P000_E14 - LAST OCCURRENCE (BRUTE FORCE LINEAR SEARCH)

    TASK:given an array and a value X, find the last index where X appears
    If X does not exist, return -1.

    BRUTE FORCE IDEA:
    scan from left to right and keep updating the answer when a match is found

    WHAT THIS PROGRAM PRINTS:
    for each test it prints: X -> lastIndex
*/

public class P000_E14 {

    static int lastIndexOf(int[] a, int x) {
        int ans = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) ans = i;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 2, 7, 2, 1};

        int[] testsX = {2, 7, 1, 10};
        for (int x : testsX) {
            System.out.println(x + " -> " + lastIndexOf(a, x));
        }
    }
}


// Made by JetiHub - J000