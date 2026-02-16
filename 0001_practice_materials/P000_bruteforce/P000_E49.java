/*
    P000_E49 - FIND IF ANY PERMUTATION WORKS (BRUTE FORCE SEARCH)

    TASK:
    Given N (small), check if there exists a permutation of 1..N
    where the first two numbers add up to 10
    If such permutation exists, print true, otherwise false

    BRUTE FORCE IDEA:
    Generate all permutations and test the condition.
    The moment we find one valid permutation, we can stop early

    WHAT THIS PROGRAM PRINTS: for each test N it prints: true/false
*/

public class P000_E49 {

    static boolean existsValidPermutation(int[] a, int pos) {
        if (pos == a.length) {
            return a.length >= 2 && (a[0] + a[1] == 10);
        }
        for (int i = pos; i < a.length; i++) {
            int tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
            if (existsValidPermutation(a, pos + 1)) return true;
            tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
        }
        return false;
    }

    static boolean hasPermutationWhereFirstTwoSumTo10(int N) {
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = i + 1;
        return existsValidPermutation(a, 0);
    }
    public static void main(String[] args) {
        int[] tests = {3, 5, 9, 10};
        for (int N : tests) {
            System.out.println("N=" + N + " -> " + hasPermutationWhereFirstTwoSumTo10(N));
        }
    }
}


// Made by JetiHub - J000