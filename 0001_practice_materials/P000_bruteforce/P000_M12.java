/*
    P000_M12 - COUNT PALINDROMIC SUBSTRINGS

    Task: given a string s count how many substrings are palindromes
    Single letters count too

    The idea is to try every substring then check if palindrome increase counter

    Output: for each test string print the count
*/

public class P000_M12 {

    static boolean isPalindrome(String s, int L, int R) {
        while (L < R) {
            if (s.charAt(L) != s.charAt(R)) return false;
            L++;
            R--;
        }
        return true;
    }

    static int countPalSubstrings(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j)) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] tests = {
                "aaa",
                "abc",
                "abba",
                "racecar",
                ""
        };
        for (String s : tests) {
            System.out.println(countPalSubstrings(s));
        }
    }
}


// Made by JetiHub - J000