/*
    P000_E37 - LCM (BRUTE FORCE MULTIPLE SCAN)

    TASK:
    Given two positive integers A and B, find their LCM (least common multiple)

    BRUTE FORCE IDEA: Start from max(A, B) and move upward
    The first number that is divisible by both A and B is the LCM

    WHY THIS IS A GOOD EARLY TASK:
    It shows a classic brute-force pattern:
      "Try candidates in increasing order and stop at the first success"

    WHAT THIS PROGRAM PRINTS: for each test pair, it prints: A, B -> lcm
*/

public class P000_E37 {

    static int lcmBrute(int A, int B) {
        if (A <= 0 || B <= 0) return 0;
        int start = Math.max(A, B);
        //we scan upward until we find a number divisible by both A and B
        for (int x = start; ; x++) {
            if (x % A == 0 && x % B == 0) {
                return x;
            }
        }
    }
    public static void main(String[] args) {
        int[] As = {2, 6, 10, 12, 21};
        int[] Bs = {3, 8, 15, 18, 14};

        for (int i = 0; i < As.length; i++) {
            int A = As[i];
            int B = Bs[i];
            System.out.println(A + ", " + B + " -> " + lcmBrute(A, B));
        }
    }
}


// Made by JetiHub - J000