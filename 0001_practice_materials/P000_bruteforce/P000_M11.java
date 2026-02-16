/*
    P000_M11 - LONGEST PALINDROMIC SUBSTRING

    Task: given a string s find the longest substring that is a palindrome
    If there are many with same length print the first one

    Brute force idea:
    Try every substring s[i..j]
    Check if it is palindrome and keep the best one

    Output: for each test string print the longest palindromic substring
*/

public class P000_M11 {

    static boolean isPalindrome(String s, int L, int R) {
        while (L < R) {
            if (s.charAt(L) != s.charAt(R)) return false;
            L++;
            R--;
        }
        return true;
    }

    static String longestPalSubstring(String s) {
        String best = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = j - i + 1;
                if (len <= best.length()) continue;
                if (isPalindrome(s, i, j)) {
                    best = s.substring(i, j + 1);
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String[] tests = {
                "babad",
                "cbbd",
                "aaaa",
                "abc",
                "racecarx"
        };
        for (String s : tests) {
            System.out.println(longestPalSubstring(s));
        }
    }
}


// Made by JetiHub - J000