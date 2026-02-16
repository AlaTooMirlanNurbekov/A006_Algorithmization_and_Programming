/*
    P000_E33 - FIRST 3-DIGIT PALINDROME IN RANGE (BRUTE FORCE SEARCH)

    TASK: given L and R, find the first 3-digit palindrome number in [L, R].
    If none exists, print: NONE

    BRUTE FORCE IDEA:
    We scan from L to R and test each number.
    A 3-digit palindrome looks like: aba
    That means:
      hundreds digit == ones digit

    WHAT THIS PROGRAM PRINTS: for each test range, it prints the first palindrome or NONE.
*/

public class P000_E33 {

    static boolean isThreeDigitPalindrome(int n) {
        if (n < 100 || n > 999) return false;
        int hundreds = n / 100;
        int ones = n % 10;
        return hundreds == ones;
    }
    static String firstPalindromeInRange(int L, int R) {
        for (int n = L; n <= R; n++) {
            if (isThreeDigitPalindrome(n)) {
                return String.valueOf(n);
            }
        }
        return "NONE";
    }

    public static void main(String[] args) {
        int[] Ls = {90, 120, 500, 800, 901};
        int[] Rs = {150, 130, 520, 805, 950};
        for (int i = 0; i < Ls.length; i++) {
            int L = Ls[i];
            int R = Rs[i];
            System.out.println(L + ".." + R + " -> " + firstPalindromeInRange(L, R));
        }
    }
}


// Made by JetiHub - J000