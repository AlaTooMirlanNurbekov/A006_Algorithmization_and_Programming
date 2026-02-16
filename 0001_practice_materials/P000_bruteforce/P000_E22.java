/*
    P000_E22 - PALINDROME STRING (BRUTE FORCE TWO POINTERS)

    TASK:
    Given a string check if it is a palindrome
    We compare characters exactly (case-sensitive, spaces included).

    BRUTE FORCE IDEA: compare first and last characters, then move inward.

    WHAT THIS PROGRAM PRINTS: For each test string, it prints: true/false
*/

public class P000_E22 {

    static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    public static void main(String[] args) {
        String[] tests = {
                "level",
                "Level",
                "abcba",
                "abca",
                "a",
                ""
        };
        for (String s : tests) {
            System.out.println(isPalindrome(s));
        }
    }
}


// Made by JetiHub - J000