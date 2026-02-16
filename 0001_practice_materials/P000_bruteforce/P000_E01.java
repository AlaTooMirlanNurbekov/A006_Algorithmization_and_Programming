/*
    P000_E01 - COUNT DIGITS (BRUTE FORCE SCAN)

    TASK:
    Given an integer N, count how many digits it has

    BRUTE FORCE IDEA:
    We repeatedly divide N by 10 untiil it becomes 0, each division removes one digit, so the number of steps is the answer
    WHAT THIS PROGRAM PRINTS:
    For each test number, it prints: N -> digitCount
*/

public class P000_E01 {
    static int countDigits(int n) {
        if (n == 0) return 1;
        n = Math.abs(n);
        int count = 0;
        //each loop removes one digit
        while (n > 0) {
            n /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // vales for N are here so you can see output of this 
        int[] tests = {0, 7, 42, 1000, -987654};
        for (int n : tests) {
            System.out.println(n + " -> " + countDigits(n));
        }
    }
}

// Made by JetiHub - J000
