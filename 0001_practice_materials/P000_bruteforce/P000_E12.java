/*
    P000_E12 - COUNT OCCURRENCES (BRUTE FORCE SCAN)

    TASK:
    Given an array and a value X count how many times X appears in the array

    BRUTE FORCE IDEA: Scan the array and count matches

    WHAT THIS PROGRAM PRINTS: For each test, it prints: X -> count
*/

public class P000_E12 {

    static int countX(int[] a, int x) {
        int count = 0;
        for (int v : a) {
            if (v == x) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {5, 2, 9, 2, 7, 2, 1};

        int[] testsX = {2, 5, 10, 1};
        for (int x : testsX) {
            System.out.println(x + " -> " + countX(a, x));
        }
    }
}


// Made by JetiHub - J000