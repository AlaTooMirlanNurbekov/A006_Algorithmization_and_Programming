/*
    P000_E36 - FIRST PYTHAGOREAN TRIPLE (BRUTE FORCE SEARCH)

    TASK:
    Given N, find the first Pythagorean triple (a, b, c) such that:
      1 <= a < b < c <= N
      a^2 + b^2 == c^2
    If no triple exists, print: NONE

    WHY THIS IS BRUTE FORCE: we are not using any math tricks. We simply try all possible combinations (a, b, c) and test the formula

    WHAT THIS PROGRAM PRINTS:
    For each test N, it prints the first triple found or NONE
*/

public class P000_E36 {
    static String firstTripleUpTo(int N) {
        // a, b, c must be positive and in increasing order
        for (int a = 1; a <= N; a++) {
            for (int b = a + 1; b <= N; b++) {
                for (int c = b + 1; c <= N; c++) {
                    int left = a * a + b * b;
                    int right = c * c;
                    // The brute-force check: does this triple satisfy the equation?
                    if (left == right) {
                        return a + " " + b + " " + c;
                    }
                }
            }
        }
        return "NONE";
    }

    public static void main(String[] args) {
        int[] tests = {5, 10, 20, 30};
        for (int N : tests) {
            System.out.println("N=" + N + " -> " + firstTripleUpTo(N));
        }
    }
}


// Made by JetiHub - J000