/*
    P000_E27 - COUNT SUBSTRING OCCURRENCES (BRUTE FORCE)

    TASK:
    Given a text string T and a pattern string P, count how many times P occurs in T.
    Overlapping occurrences are allowed. Example: T="aaaa", P="aa" -> 3 (positions 0,1,2)

    BRUTE FORCE IDEA:
    Try every start position and check if pattern matches there.

    WHAT THIS PROGRAM PRINTS:
    for each test (T, P), it prints: count
*/

public class P000_E27 {

    static int countOccurrences(String T, String P) {
        if (P.length() == 0) return T.length() + 1;
        if (P.length() > T.length()) return 0;
        int count = 0;

        for (int start = 0; start <= T.length() - P.length(); start++) {
            boolean ok = true;

            for (int j = 0; j < P.length(); j++) {
                if (T.charAt(start + j) != P.charAt(j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String[] T = {"aaaa", "abracadabra", "hello", "aaaaa", ""};
        String[] P = {"aa", "abra", "ll", "b", ""};
        for (int i = 0; i < T.length; i++) {
            System.out.println(countOccurrences(T[i], P[i]));
        }
    }
}

// Made by JetiHub - J000
