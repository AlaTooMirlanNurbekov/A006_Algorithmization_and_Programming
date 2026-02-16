/*
    P000_M13 - LONGEST DISTINCT SUBSTRING 

    Task: given a string s find the length of the longest substring
    where all characters are different

    The idea is to try every substring check if it has duplicates and keep the best length

    Output: for each test string print the best length
*/

public class P000_M13 {

    static boolean allDistinct(String s, int L, int R) {
        boolean[] seen = new boolean[256];

        for (int i = L; i <= R; i++) {
            int c = s.charAt(i);
            if (seen[c]) return false;
            seen[c] = true;
        }

        return true;
    }

    static int longestDistinctLen(String s) {
        int best = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                int len = j - i + 1;
                if (len <= best) continue;
                if (allDistinct(s, i, j)) {
                    best = len;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String[] tests = {
                "abcabcbb",
                "bbbbb",
                "pwwkew",
                "jetihub",
                ""
        };

        for (String s : tests) {
            System.out.println(longestDistinctLen(s));
        }
    }
}


// Made by JetiHub - J000
