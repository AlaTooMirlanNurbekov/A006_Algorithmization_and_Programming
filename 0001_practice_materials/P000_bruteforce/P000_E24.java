/*
    P000_E24 - FIRST NON-REPEATING CHARACTER (BRUTE FORCE)

    TASK:
    Given a string, find the first character that appears exactly once.
    If there is no such character, output: NONE

    BRUTE FORCE IDEA:
    For each character at position i:
    - count how many times it appears in the whole string
    - if count == 1, return it immediately

    WHAT THIS PROGRAM PRINTS: For each test stringg it prints the first non-repeating character or NONE.
*/

public class P000_E24 {
    static String firstNonRepeating(String s) {
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);

            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == target) cnt++;
            }

            if (cnt == 1) return String.valueOf(target);
        }

        return "NONE";
    }
    public static void main(String[] args) {
        String[] tests = {
                "aabbcc",
                "swiss",
                "programming",
                "aabbccd",
                ""
        };
        for (String s : tests) {
            System.out.println(firstNonRepeating(s));
        }
    }
}


// Made by JetiHub - J000