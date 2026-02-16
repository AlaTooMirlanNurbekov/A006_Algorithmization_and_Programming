/*
    P000_E43 - NO CONSECUTIVE ONES (BRUTE FORCE CHECK)

    TASK:
    Given N (small), count how many binary strings of length N
    do NOT contain "11" as a substring

    BRUTE FORCE IDEA:
    Generate every binary string (2^N of them).
    For each string, check if it contains consecutive ones. If it doesn't, count it

    WHAT THIS PROGRAM PRINTS:
    For each test N, it prints: count
*/

public class P000_E43 {

    static boolean hasConsecutiveOnes(int mask) {
        // If mask has two adjacent 1 bits, then (mask & (mask >> 1)) will be non-zero
        return (mask & (mask >> 1)) != 0;
    }

    static int countNoConsecutiveOnes(int N) {
        int total = 1 << N;
        int count = 0;

        for (int mask = 0; mask < total; mask++) {
            if (!hasConsecutiveOnes(mask)) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] tests = {1, 2, 3, 4, 5, 10};

        for (int N : tests) {
            System.out.println("N=" + N + " -> " + countNoConsecutiveOnes(N));
        }
    }
}


// Made by JetiHub - J000