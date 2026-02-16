/*
    P000_E34 - SMALLEST X THAT SATISFIES A CONDITION (BRUTE FORCE)

    TASK:
    Given A and B, find the smallest integer x in [A, B] such that:
      x is divisible by 7 AND x is divisible by 5
    If no such x exists, print: NONE

    BRUTE FORCE IDEA: simply try every x from A to B until the condition becomes true.

    WHY THIS TASK IS USEFUL:
    This is the simplest form of brute force:
    "Try candidates in order and stop at the first success."
*/

public class P000_E34 {

    static String smallestDivBy7And5(int A, int B) {
        for (int x = A; x <= B; x++) {
            if (x % 7 == 0 && x % 5 == 0) {
                return String.valueOf(x);
            }
        }
        return "NONE";
    }
    public static void main(String[] args) {
        int[] As = {1, 30, 40, 100, 101};
        int[] Bs = {20, 60, 69, 130, 134};
        for (int i = 0; i < As.length; i++) {
            int A = As[i];
            int B = Bs[i];
            System.out.println(A + ".." + B + " -> " + smallestDivBy7And5(A, B));
        }
    }
}


// Made by JetiHub - J000