/*
    P000_E11 - MIN AND MAX (BRUTE FORCE SCAN)

    TASK:
    Given an array of integers find the minimum and maximum values

    BRUTE FORCE IDEA:scan every element and keep updating min and max

    WHAT THIS PROGRAM PRINTS: for each test array, it prints: min max
*/

public class P000_E11 {

    static void printMinMax(int[] a) {
        int min = a[0];
        int max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
            if (a[i] > max) max = a[i];
        }
        System.out.println(min + " " + max);
    }

    public static void main(String[] args) {
        int[][] tests = {
                {5, 2, 9, 1, 7},
                {-3, -10, 0, 8},
                {42},
                {100, 100, 100},
                {9, 8, 7, 6, 5}
        };

        for (int[] arr : tests) {
            printMinMax(arr);
        }
    }
}


// Made by JetiHub - J000