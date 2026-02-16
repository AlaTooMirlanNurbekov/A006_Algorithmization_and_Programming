/*
    P000_E41 - GENERATE ALL BINARY STRINGS (BRUTE FORCE ENUMERATION)

    TASK:
    Given N (small), generate and print all binary strings of length N.
    Example for N=3:
      000
      001
      010
      011
      100
      101
      110
      111

    BRUTE FORCE IDEA: A binary string of length N is just a number from 0 to (2^N - 1)
    written in binary with leading zeros. So we simply loop over all masks and print each one.

    WHAT THIS PROGRAM PRINTS:
    For each test N, it prints all binary strings (one per line).
*/

public class P000_E41 {

    static void printBinary(int mask, int N) {
        // Print exactly N bits, from most significant to least significant
        for (int bit = N - 1; bit >= 0; bit--) {
            int value = (mask >> bit) & 1;
            System.out.print(value);
        }
        System.out.println();
    }
    static void generateBinaryStrings(int N) {
        int total = 1 << N; // 2^N strings

        for (int mask = 0; mask < total; mask++) {
            printBinary(mask, N);
        }
    }
    public static void main(String[] args) {
        int[] tests = {1, 2, 3};

        for (int N : tests) {
            System.out.println("N=" + N);
            generateBinaryStrings(N);
            System.out.println();
        }
    }
}


// Made by JetiHub - J000