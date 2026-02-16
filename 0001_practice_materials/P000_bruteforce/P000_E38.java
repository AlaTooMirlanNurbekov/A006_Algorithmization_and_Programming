/*
    P000_E38 - GCD (BRUTEE FORCE DIVISOR CHECK)

    TASK:
    Given two positive integers A and B, find their GCD (greatest common divisor)

    THE IDEA: GCD must be between 1 and min(A, B) We try every d in that range and keep the largest one that divides both numbers

    IMPORTANT:
    This is intentionally NOT Euclid’s algorithm yet.
    We are practicing the brute-force way first.

    WHAT THIS PROGRAM PRINTS:
    For each test pair, it prints: A, B -> gcd
*/

public class P000_E38 {
    static int gcdBrute(int A, int B) {
        if (A <= 0 || B <= 0) return 0;

        int limit = Math.min(A, B);
        int best = 1;
        // Scan all possible divisors and remember the largest valid one
        for (int d = 1; d <= limit; d++) {
            if (A % d == 0 && B % d == 0) {
                best = d;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        int[] As = {12, 10, 21, 36, 7};
        int[] Bs = {18, 15, 14, 48, 13};
        for (int i = 0; i < As.length; i++) {
            int A = As[i];
            int B = Bs[i];
            System.out.println(A + ", " + B + " -> " + gcdBrute(A, B));
        }
    }
}

// Made by JetiHub - J000
