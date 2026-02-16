/*
    P000_E42 - COUNT BINARY STRINGS WITH EXACTLY K ONES (BRUTE FORCE)

    TASK:
    Given N and K (small), count how many binary strings of length N
    contain exactly K ones
    Example: N=4, K=2 -> 6

    BRUTE FORCE IDEA:
    Generate all 2^N binary strings and count how many have exactly K ones
    This is pure exhaustive checking

    WHAT THIS PROGRAM PRINTS:
    For each test (N, K), it prints: count
*/

public class P000_E42 {

    static int countOnes(int mask) {
        int cnt = 0;
        while (mask > 0) {
            cnt += (mask & 1);
            mask >>= 1;
        }

        return cnt;
    }

    static int countBinaryStringsWithKOnes(int N, int K) {
        int total = 1 << N;
        int count = 0;
        for (int mask = 0; mask < total; mask++) {
            if (countOnes(mask) == K) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] Ns = {3, 4, 5, 5};
        int[] Ks = {1, 2, 2, 4};
        for (int i = 0; i < Ns.length; i++) {
            int N = Ns[i];
            int K = Ks[i];
            System.out.println("N=" + N + ", K=" + K + " -> " + countBinaryStringsWithKOnes(N, K));
        }
    }
}


// Made by JetiHub - J000
