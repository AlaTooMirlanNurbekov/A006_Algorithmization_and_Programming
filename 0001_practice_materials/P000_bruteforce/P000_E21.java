/*
    P000_E21 - COUNT VOWELS AND CONSONANTS (BRUTE FORCE SCAN)

    TASK:
    Given a string, count how many vowels and consonants it contains
    We count only English letters a-z and A-Z. Everything else (spaces, digits, symbols) is ignored

    BRUTE FORCE IDEA: Scan characters one by one and classify each letter.

    WHAT THIS PROGRAM PRINTS:for each test string, it prints: vowels consonants
*/

public class P000_E21 {

    static boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
    static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    static void printVowelsConsonants(String s) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!isLetter(ch)) continue;

            if (isVowel(ch)) vowels++;
            else consonants++;
        }
        System.out.println(vowels + " " + consonants);
    }

    public static void main(String[] args) {
        String[] tests = {
                "Hello World!",
                "AEIOU xyz",
                "123 !!!",
                "Jetihub",
                "Algorithms are fun"
        };
        for (String s : tests) {
            printVowelsConsonants(s);
        }
    }
}

// Made by JetiHub - J000