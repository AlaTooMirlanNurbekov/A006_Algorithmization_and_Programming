/*
    P000_E25 - ANAGRAM CHECK (BRUTE FORCE COUNTING)

    TASK:
    Given two strings, check if they are anagrams. We treat them as case-sensitive and include spaces as characters
    Example: "abc" and "bca" -> true

    BRUTE FORCE IDEA:
    Count how many times each character (ASCII 0..255) appears in both strings. If all counts match, they are anagrams

    WHAT THIS PROGRAM PRINTS:
    For each test pair, it prints: true/false
*/

public class P000_E25 {

    static boolean areAnagrams(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] cnt = new int[256];

        for (int i = 0; i < a.length(); i++) {
            cnt[a.charAt(i)]++;
            cnt[b.charAt(i)]--;
        }
        for (int x : cnt) {
            if (x != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] A = {"abc", "listen", "aabb", "Hello", "a b"};
        String[] B = {"bca", "silent", "abab", "Olelh", "b a"};
        for (int i = 0; i < A.length; i++) {
            System.out.println(areAnagrams(A[i], B[i]));
        }
    }
}


// Made by JetiHub - J000