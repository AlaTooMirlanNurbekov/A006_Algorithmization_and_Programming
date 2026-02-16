/*
    P000_E50 - SMALLEST VALID PERMUTATION (BRUTE FORCE SEARCH)

    TASK:
    Given N (small), find the lexicographically smallest permutation of 1..N
    such that:
      a[0] < a[1] < a[2]   (the first three positions are strictly increasing)
    If no permutation exists (example: N < 3) print NONE

    EXPLANATION OF "LEXICOGRAPHICALLY SMALLEST":
    Like dictionary order:
    - compare first element
    - if tie, compare second
    - then third, ...

    BRUTE FORCE IDEA:generate all permutations and keep the best one that satisfies the rule

    WHAT THIS PROGRAM PRINTS: for each N, it prints the permutation or NONE
*/

public class P000_E50 {

    static boolean isValid(int[] a) {
        return a.length >= 3 && a[0] < a[1] && a[1] < a[2];
    }
    static boolean isLexSmaller(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return a[i] < b[i];
        }
        return false;
    }
    static void permuteAndPickBest(int[] a, int pos, int[] bestHolder) {
        if (pos == a.length) {
            if (isValid(a)) {
                if (bestHolder[0] == -1) {
                    for (int i = 0; i < a.length; i++) bestHolder[i] = a[i];
                } else {
                    if (isLexSmaller(a, bestHolder)) {
                        for (int i = 0; i < a.length; i++) bestHolder[i] = a[i];
                    }
                }
            }
            return;
        }
        for (int i = pos; i < a.length; i++) {
            int tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
            permuteAndPickBest(a, pos + 1, bestHolder);
            tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
        }
    }

    static String smallestValidPermutation(int N) {
        if (N < 3) return "NONE";
        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = i + 1;
        // We'll store best permutation inside this array.
        // If bestHolder[0] stays -1, it means no solution was found.
        int[] bestHolder = new int[N];
        bestHolder[0] = -1;

        permuteAndPickBest(a, 0, bestHolder);

        if (bestHolder[0] == -1) return "NONE";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(" ");
            sb.append(bestHolder[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] tests = {2, 3, 4, 5};
        for (int N : tests) {
            System.out.println("N=" + N + " -> " + smallestValidPermutation(N));
        }
    }
}


// Made by JetiHub - J000