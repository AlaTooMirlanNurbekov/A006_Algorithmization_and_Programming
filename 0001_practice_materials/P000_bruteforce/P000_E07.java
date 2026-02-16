/*
    P000_E07 - LIST ALL DIVISORS (BRUTE FORCE CHECK)

    TASK:
    Given an integer N (N > 0) print all divisors of N in increasing order

    BRUTE FORCE IDEA:
    Try every d from 1 to N
    If N % d == 0, then d is a divisor

    WHAT THIS PROGRAM PRINTS: For each test number, it prints: N -> [divisors...]
*/

public class P000_E07 {
    static void printDivisors(int n) {
        if (n <= 0) {
            System.out.println(n + " -> invalid");
            return;
        }
        System.out.print(n + " -> ");

        boolean first = true;
        for (int d = 1; d <= n; d++) {
            if (n % d == 0) {
                if (!first) System.out.print(" ");
                System.out.print(d);
                first = false;
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] tests = {1, 6, 10, 28, 36};

        for (int n : tests) {
            printDivisors(n);
        }
    }
}


// Made by JetiHub - J000
