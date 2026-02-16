/*
    P000_E29 - LONGEST COMMON PREFIX (BRUTE FORCE COMPARE)

    TASK:
    Given two strings A and B, find their longest common prefix
    Example: "flower" and "flow" -> "flow"
    If there is no common prefix, output an empty string

    BRUTE FORCE IDEA: compare characters from the start until they differ

    WHAT THIS PROGRAM PRINTS:
    For each test pair, it prints the common prefix (may be empty)
*/

public class P000_E29 {

    static String longestCommonPrefix(String A, String B) {
        int n = Math.min(A.length(), B.length());
        int i = 0;
        while (i < n && A.charAt(i) == B.charAt(i)) {
            i++;
        }
        return A.substring(0, i);
    }

    public static void main(String[] args) {
        String[] A = {"flower", "interview", "abc", "Jetihub", ""};
        String[] B = {"flow", "internet", "xyz", "Jeti", "abc"};
        for (int i = 0; i < A.length; i++) {
            System.out.println(longestCommonPrefix(A[i], B[i]));
        }
    }
}

// Made by JetiHub - J000