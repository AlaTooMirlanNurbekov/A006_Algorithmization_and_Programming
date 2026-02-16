/*
    P000_E40 - CLOSEST PERFECT SQUARE (BRUTE FORCE SEARCH)

    TASK:
    Given a non-negative integer N, find the perfect square number that is closest to N
    If two squares are equally close, choose the smaller one

    BRUTE FORCE IDEA:
    We scan i = 0, 1, 2, ...
    Compute square = i*i and track which square is closest so far.

    WHY THIS IS BRUTE FORCE:
    We are not using formulas to jump directly. We test candidates and keep the best candidate

    WHAT THIS PROGRAM PRINTS:
    For each test N, it prints: N -> closestSquare
*/

public class P000_E40 {

    static int closestPerfectSquare(int N) {
        if (N < 0) return -1;

        int bestSquare = 0;
        int bestDiff = Math.abs(N - 0);

        //we only need to check i*i until it goes past N by more than current bestDiff
        for (int i = 1; ; i++) {
            int sq = i * i;
            int diff = Math.abs(N - sq);

            //update best if we found a closer square
            // If same distance, prefer the smaller square (already handled by scanning upward)
            if (diff < bestDiff) {
                bestDiff = diff;
                bestSquare = sq;
            }

            // onnce squares become too far above N, they can only get wors
            if (sq > N && (sq - N) > bestDiff) break;
        }

        return bestSquare;
    }

    public static void main(String[] args) {
        int[] tests = {0, 1, 2, 3, 8, 10, 15, 16, 18, 24, 26};

        for (int N : tests) {
            System.out.println(N + " -> " + closestPerfectSquare(N));
        }
    }
}

// Made by JetiHub - J000