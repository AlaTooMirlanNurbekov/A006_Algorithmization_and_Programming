/*
    P000_E26 - NAIVE SUBSTRING SEEARCH (BRUTE FORCE)

    TASK:
    Given a text string T and a pattern string P find the first index where P occurs in T
    If P does not occur, return -1

    BRUTE FORCE IDEA:
    Try aligning P at every possible start position in T
    For each alignment, compare characters one by one.

    WHAT THIS PROGRAM PRINTS:
    For each test (T, P), it prints: firstIndex
*/

public class P000_E26 {
    static int firstIndexOfPattern(String T, String P) {
        if (P.length() == 0) return 0;
        if (P.length() > T.length()) return -1;
        for (int start = 0; start <= T.length() - P.length(); start++) {
            boolean ok = true;
            for (int j = 0; j < P.length(); j++) {
                if (T.charAt(start + j) != P.charAt(j)) {
                    ok = false;
                    break;
                }
            }

            if (ok) return start;
        }

        return -1;
    }
    public static void main(String[] args) {
        String[] T = {"abracadabra", "hello world", "aaaaa", "jetihub", ""};
        String[] P = {"cad", "world", "aa", "hub", "a"};
        for (int i = 0; i < T.length; i++) {
            System.out.println(firstIndexOfPattern(T[i], P[i]));
        }
    }
}


// Made by JetiHub - J000