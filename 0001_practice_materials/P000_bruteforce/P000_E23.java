/*
    P000_E23 - CHARACTER FREQUENCY (BRUTE FORCE COUNT)

    TASK:
    Given a string, count the frequency of letters a-z (case-insensitive)
    Non-letters are ignored

    BRUTE FORCE IDEA: scan the string and increment a counter for each letter

    WHAT THIS PROGRAM PRINTS:
    For each test string, it prints the counts of letters that appear
    Format: letter=count (only letters with count > 0)
*/

public class P000_E23 {

    static void printLetterFrequency(String s) {
        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLetter(ch)) {
                ch = Character.toLowerCase(ch);
                if (ch >= 'a' && ch <= 'z') {
                    cnt[ch - 'a']++;
                }
            }
        }
        boolean first = true;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                if (!first) System.out.print(" ");
                System.out.print((char)('a' + i) + "=" + cnt[i]);
                first = false;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] tests = {
                "Hello World",
                "aAaA BBB c!",
                "123",
                "Jetihub",
                "Algorithmization"
        };

        for (String s : tests) {
            printLetterFrequency(s);
        }
    }
}


// Made by JetiHub - J000