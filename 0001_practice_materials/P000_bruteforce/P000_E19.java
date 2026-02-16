/*
    P000_E19 - MAX PRODUCT PAIR (BRUTE FORCE DOUBLE LOOP)

    TASK:
    Given an array (length >= 2) find the maximum product of any pair (i, j), i < j.Output the maximum product value

    BRUTE FORCE IDEA: Try every pair and keep the largest product

    WHAT THIS PROGRAM PRINTS:for each test array, it prints: maxProduct
*/

public class P000_E19 {

    static int maxProductPair(int[] a) {
        int best = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                int prod = a[i] * a[j];
                if (prod > best) best = prod;
            }
        }
        return best;
    }
    public static void main(String[] args) {
        int[][] tests = {
                {5, 2, 9, 1, 7},
                {-10, -3, 2, 4},
                {0, 5, 6},
                {2, 3},
                {-5, 1, 2, 3}
        };

        for (int[] arr : tests) {
            System.out.println(maxProductPair(arr));
        }
    }
}


// Made by JetiHub - J000