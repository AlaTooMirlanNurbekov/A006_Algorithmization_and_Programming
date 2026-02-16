/*
    P000_E28 - ALL START INDICES (BRUTE FORCE)

    TASK:
    Given a text string T and a pattern string P, print all start indices where P occurs in T
    If no occurrence exists, print: NONE

    BRUTE FORCE IDEA:
    Try every possible start position and check if pattern matches there.

    WHAT THIS PROGRAM PRINTS:
    For each test (T, P), it prints either:
    - indices separated by spaces
    - or NONE
*/

public class P000_E28 {

    static void printAllIndices(String T, String P) {
        if (P.length() == 0) {
            System.out.println("0");
            return;
        }
        boolean found = false;

        for (int start = 0; start <= T.length() - P.length(); start++) {
            boolean ok = true;
            for (int j = 0; j < P.length(); j++) {
                if (T.charAt(start + j) != P.charAt(j)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                if (found) System.out.print(" ");
                System.out.print(start);
                found = true;
            }
        }

        if (!found) System.out.print("NONE");
        System.out.println();
    }

    public static void main(String[] args) {
        String[] T = {"aaaa", "abracadabra", "hello world", "jetihub", "aaaaa"};
        String[] P = {"aa", "abra", "o", "hub", "b"};
        for (int i = 0; i < T.length; i++) {
            printAllIndices(T[i], P[i]);
        }
    }
}


// Made by JetiHub - J000