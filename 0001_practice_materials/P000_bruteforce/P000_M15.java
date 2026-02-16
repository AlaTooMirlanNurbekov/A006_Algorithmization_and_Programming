/*
    P000_M15 - LONGEST REPEATED SUBSTRING 

    Task: given a string s find the length of the longest substring
    that appears at least twice in s
    Overlap is allowed

    The idea is to try every pair of start positions i and j
    Extend while characters match
    Track the best length

    Output: for each test string print the best length
*/

public class P000_M15 {

    static int longestRepeatedSubstringLen(String s) {
        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                int k = 0;
                while (i + k < s.length() && j + k < s.length()
                        && s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                }
                if (k > best) best = k;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        String[] tests = {
                "banana",
                "aaaaa",
                "abcdef",
                "mississippi",
                "abababa"
        };

        for (String s : tests) {
            System.out.println(longestRepeatedSubstringLen(s));
        }
    }
}

// Made by JetiHub - J000
