/*
    P000_E46 - COUNT SUBSETS WITH SUM S (BRUTE FORCE BITMASK)

    TASK:
    Given an array of integers and a target sum S
    count how many different subsets have sum exactly S

    BRUTE FORCE IDEA: each subset corresponds to a bitmask from 0 to (2^n - 1)
    We generate every subset, compute its sum, and count matches.

    WHAT THIS PROGRAM PRINTS: For each test (array, S), it prints: count
*/

public class P000_E46 {

    static int countSubsetsWithSum(int[] a, int S) {
        int n = a.length;
        int total = 1 << n;
        int count = 0;

        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    sum += a[i];
                }
            }
            if (sum == S) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {3, 5, 7, 10};
        int[] targets = {0, 10, 15, 25};
        for (int S : targets) {
            System.out.println("S=" + S + " -> " + countSubsetsWithSum(a, S));
        }
    }
}


// Made by JetiHub - J000