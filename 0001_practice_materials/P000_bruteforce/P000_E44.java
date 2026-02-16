/*
    P000_E44 - COUNT SUBSETS OF SIZE K (BRUTE FORCE BITMASK)

    TASK: given N and K (N is small), count how many subsets of {1..N}
    have exactly K elements.

    BRUTE FORCE IDEA:
    Every subset can be represented as a bitmask from 0 to (2^N - 1).
    We simply generate all masks and count how many have K bits set.

    WHAT THIS PROGRAM PRINTS: for each test (N, K), it prints: count
*/

public class P000_E44 {

    static int countBits(int mask) {
        int cnt = 0;
        while (mask > 0) {
            cnt += (mask & 1);
            mask >>= 1;
        }
        return cnt;
    }
    static int countSubsetsOfSizeK(int N, int K) {
        int total = 1 << N;
        int count = 0;

        for (int mask = 0; mask < total; mask++) {
            if (countBits(mask) == K) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] Ns = {3, 4, 5, 6};
        int[] Ks = {1, 2, 2, 3};
        for (int i = 0; i < Ns.length; i++) {
            int N = Ns[i];
            int K = Ks[i];
            System.out.println("N=" + N + ", K=" + K + " -> " + countSubsetsOfSizeK(N, K));
        }
    }
}


// Made by JetiHub - J000