/*
    P000_M14 - SMALLEST WINDOW CONTAINS T 

    Task: given strings s and t find the shortest substring of s
    that contains all characters of t with needed counts
    If not possible print NONE

    Yhe idae : try every window s[i..j]
    Check if this window covers t
    Keep the shortest valid window

    Output: for each test print the window or NONE
*/

public class P000_M14 {

    static boolean covers(String window, String t) {
        int[] need = new int[256];
        int[] have = new int[256];
        for (int i = 0; i < t.length(); i++) need[t.charAt(i)]++;
        for (int i = 0; i < window.length(); i++) have[window.charAt(i)]++;
        for (int c = 0; c < 256; c++) {
            if (have[c] < need[c]) return false;
        }
        return true;
    }

    static String smallestWindow(String s, String t) {
        if (t.length() == 0) return "";

        String best = null;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = j - i + 1;
                if (best != null && len >= best.length()) continue;
                String w = s.substring(i, j + 1);
                if (covers(w, t)) {
                    best = w;
                }
            }
        }

        return best == null ? "NONE" : best;
    }

    public static void main(String[] args) {
        String[] S = {"ADOBECODEBANC", "a", "aa", "hello", "mississippi"};
        String[] T = {"ABC", "a", "aaa", "eo", "iss"};

        for (int i = 0; i < S.length; i++) {
            System.out.println(smallestWindow(S[i], T[i]));
        }
    }
}

// Made by JetiHub - J000
