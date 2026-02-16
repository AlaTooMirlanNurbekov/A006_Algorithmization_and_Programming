/*
    P000_E08 - PRIME CHECK (BRUTE FORCE TRIAL DIVISION)

    TASK: Given an integer N check if it is prime (prime means N > 1 and it has exactly two divisors: 1 and N)

    BRUTE FORCE IDEA:
    Try dividing N by every number d from 2 to N-1
    If any division works N is not prime

    WHAT THIS PROGRAM PRINTS: for each test number, it prints: N -> true/false
*/

public class P000_E08 {
    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int d = 2; d <= n - 1; d++) {
            if (n % d == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] tests = {-5, 0, 1, 2, 3, 4, 5, 9, 11, 25};

        for (int n : tests) {
            System.out.println(n + " -> " + isPrime(n));
        }
    }
}


// Made by JetiHub - J000
