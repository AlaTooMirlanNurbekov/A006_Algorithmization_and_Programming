/*
    P000_M17 - LONGEST COMMON SUBSTRING

    TASK: given two strings A and B, find the length of the longest substring that appears in both strings.
    Substring means contiguous

    BRUTE FORCE IDEA: generate every substring of A
    Check if it appears in B using naive search
    Keep the maximum length found

    OUTPUT: for each test pair (A, B), it prints: bestLength
*/

public class P000_M17 {

    static boolean containsSubstring(String text, String pat) {
        if (pat.length() == 0) return true;
        if (pat.length() > text.length()) return false;
        for (int start = 0; start <= text.length() - pat.length(); start++) {
            boolean ok = true;
            for (int j = 0; j < pat.length(); j++) {
                if (text.charAt(start + j) != pat.charAt(j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
    }

    static int longestCommonSubstringLen(String A, String B) {
        int best = 0;

        for (int i = 0; i < A.length(); i++) {
            for (int j = i; j < A.length(); j++) {
                int len = j - i + 1;
                if (len <= best) continue;
                String sub = A.substring(i, j + 1);
                if (containsSubstring(B, sub)) {
                    best = len;
                }
            }
        }

        return best;
    }

    public static void main(String[] args) {
        String[] A = {"abcdef", "banana", "jetihub", "aaaa", "abc"};
        String[] B = {"zabxy", "ananas", "hubjeti", "baaa", "def"};
        for (int i = 0; i < A.length; i++) {
            System.out.println(longestCommonSubstringLen(A[i], B[i]));
        }
    }
}


// Made by JetiHub - J000