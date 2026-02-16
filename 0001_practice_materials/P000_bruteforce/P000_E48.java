/*
    P000_E48 - GENERATE ALL PERMUTATIONS OF 1..N (BRUTE FORCE)

    TASK:
    Given N (small), print all permutations of numbers 1..N.
    Example for N=3:
                1 2 3
                1 3 2
                2 1 3
                2 3 1
                3 1 2
                3 2 1

    BRUTE FORCE IDEA:
    A permutation means "every possible order". We generate all orders using recursion and swapping.

    WHAT THIS PROGRAM PRINTS:
    For each test N, it prints all permutations (one per line).
*/

public class P000_E48 {

    static void permute(int[] a, int pos) {
        // If pos reached the end, we built one complete permutation
        if (pos == a.length) {
            for (int i = 0; i < a.length; i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(a[i]);
            }
            System.out.println();
            return;
        }
        // Try each possible number in position 'pos'
        for (int i = pos; i < a.length; i++) {
            // Put a[i] into position pos
            int tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
            permute(a, pos + 1);
            // Undo swap to restore state for the next try
            tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
        }
    }
    static void generatePermutations(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = i + 1;
        permute(a, 0);
    }
    public static void main(String[] args) {
        int[] tests = {2, 3};

        for (int N : tests) {
            System.out.println("N=" + N);
            generatePermutations(N);
            System.out.println();
        }
    }
}


// Made by JetiHub - J000