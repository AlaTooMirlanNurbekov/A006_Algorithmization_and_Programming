/*
    P000_E05 -COUNT DIGIT OCCURRENCES (BRUTE FORCE SCAN)

    TASK:Given an integer N and a digit D (0..9), count how many times D appears in N

    Example: N = 707070, D = 7 -> 3

    BRUTE FORCE IDEA : Scan digits one by one using % 10, and count matches

    WHAT THIS PROGRAM PRINTS: For each test (N, D) it prints: N, D -> count
*/

public class P000_E05 {

    static int countDigit(int n, int d) {
        n = Math.abs(n);
        if (n == 0) return d == 0 ? 1 : 0;
        int count = 0;
        while (n > 0) {
            int digit = n % 10;
            if (digit == d) count++;
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] Ns = {0, 707070, 123456, -99999};
        int[] Ds = {0, 7, 3, 9};
        for (int i = 0; i < Ns.length; i++) {
            int n = Ns[i];
            int d = Ds[i];
            System.out.println(n + ", " + d + " -> " + countDigit(n, d));
        }
    }
}

// Made by JetiHub - J000
