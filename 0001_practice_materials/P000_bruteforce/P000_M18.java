/*
    P000_M18 - STRING BORDERS

    TASK: a border is a prefix of a string that is also a suffix (but not the whole string)
    Given a string S, print all border lengths in increasing order
    Example: "ababab" has borders of lengths 2 ("ab") and 4 ("abab")

    BRUTE FORCE IDEA:
    For each length L from 1 to n-1:
    - check if prefix S[0..L-1] equals suffix S[n-L..n-1]

    OUTPUT: for each test string, it prints border lengths or NONE
*/

public class P000_M18 {

    static void printBorders(String S) {
        int n = S.length();
        boolean found = false;
        for (int L = 1; L <= n - 1; L++) {
            boolean ok = true;
            for (int i = 0; i < L; i++) {
                if (S.charAt(i) != S.charAt(n - L + i)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                if (found) System.out.print(" ");
                System.out.print(L);
                found = true;
            }
        }
        if (!found) System.out.print("NONE");
        System.out.println();
    }

    public static void main(String[] args) {
        String[] tests = {"ababab", "aaaa", "abcab", "xyz", ""};
        for (String s : tests) {
            printBorders(s);
        }
    }
}


// Made by JetiHub - J000