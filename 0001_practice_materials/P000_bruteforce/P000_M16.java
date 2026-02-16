/*
    P000_M16 - ANAGRAM SUBSTRING EXISTS

    TASK:given a string S and a pattern P, check if S contains a substring that is an anagram of P
    Example: S="cbaebabacd", P="abc" -> true (substring "cba")

    THE IDEA: try every window of length |P| inside S. For each window, compare character counts with P.

    OUTPUT: for each test (S, P), it prints: true/false
*/

public class P000_M16 {

    static boolean sameCounts(String a, String b) {
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

    static boolean hasAnagramSubstring(String S, String P) {
        if (P.length() > S.length()) return false;
        int m = P.length();
        for (int i = 0; i <= S.length() - m; i++) {
            String window = S.substring(i, i + m);
            if (sameCounts(window, P)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String[] S = {"cbaebabacd", "hello", "aaaa", "jetihub", "abab"};
        String[] P = {"abc", "oll", "aa", "hub", "bba"};
        for (int i = 0; i < S.length; i++) {
            System.out.println(hasAnagramSubstring(S[i], P[i]));
        }
    }
}


// Made by JetiHub - J000