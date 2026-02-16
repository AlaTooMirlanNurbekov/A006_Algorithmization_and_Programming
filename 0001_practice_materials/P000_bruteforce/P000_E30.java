/*
    P000_E30 - STRING ROTATION CHECK (BRUTE FORCE SHIFTS)

    TASK:
    Given strings A and B, check if B is a rotation of A
    Example: A="abcd", B="cdab" -> true

    BRUTE FORCE IDEA: Try all possible rotation shifts of A and see if any equals B

    WHAT THIS PROGRAM PRINTS:
    For each test pair, it prints: true/false
*/

public class P000_E30 {

    static boolean isRotation(String A, String B) {
        if (A.length() != B.length()) return false;
        int n = A.length();
        for (int shift = 0; shift < n; shift++) {
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                char aChar = A.charAt((i + shift) % n);
                if (aChar != B.charAt(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }

        return true && A.equals(B); //covers n==0 and identical strings
    }

    public static void main(String[] args) {
        String[] A = {"abcd", "aaaa", "jetihub", "abc", ""};
        String[] B = {"cdab", "aaaa", "hubjeti", "acb", ""};
        for (int i = 0; i < A.length; i++) {
            System.out.println(isRotation(A[i], B[i]));
        }
    }
}

// Made by JetiHub - J000