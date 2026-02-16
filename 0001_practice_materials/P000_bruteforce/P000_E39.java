/*
    P000_E39 - INTEGER SQUARE ROOT (BRUTE FORCE SCAN)

    TASK:
    Given a non-negative integer N, find floor(sqrt(N))
    Example:
      N = 15 -> 3
      N = 16 -> 4

    BRUTE FORCE IDEA:
    We try i = 0, 1, 2, ...
    and keep going while i*i <= N. The last valid i is the answer

    WHY THIS IS USEFUL:
    This teaches the “keep best so far” brute-force pattern

    WHAT THIS PROGRAM PRINTS:
    For each test N, it prints: N -> floorSqrt
*/

public class P000_E39 {

    static int floorSqrtBrute(int N) {
        if (N < 0) return -1;

        int best = 0;

        //stop when i*i becomes bigger than N
        for (int i = 0; i * i <= N; i++) {
            best = i;
        }

        return best;
    }
    public static void main(String[] args) {
        int[] tests = {0, 1, 2, 15, 16, 17, 99, 100};

        for (int N : tests) {
            System.out.println(N + " -> " + floorSqrtBrute(N));
        }
    }
}

// Made by JetiHub - J000
