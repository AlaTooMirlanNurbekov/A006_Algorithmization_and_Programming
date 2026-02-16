/*
    P000_E32 - COUNT 3-DIGIT ARMSTRONG NUMBERS (BRUTE FORCE ENUMERATION)

    TASK:
    Count how many 3-digit Armstrong numbers exist.
    A 3-digit number abc is Armstrong if:
      abc = a^3 + b^3 + c^3
    Example: 153 = 1^3 + 5^3 + 3^3

    BRUTE FORCE IDEA: try every number from 100 to 999 and check the definition directly.

    WHAT THIS PROGRAM PRINTS: It prints the count, and also prints one example list for learning.
*/

public class P000_E32 {

    static boolean isArmstrong3(int n) {
        int a = n / 100;
        int b = (n / 10) % 10;
        int c = n % 10;
        int sum = a * a * a + b * b * b + c * c * c;

        return sum == n;
    }
    public static void main(String[] args) {
        int count = 0;
        //small "learning bonus": also show which ones are Armstrong
        StringBuilder list = new StringBuilder();
        for (int n = 100; n <= 999; n++) {
            if (isArmstrong3(n)) {
                count++;
                if (list.length() > 0) list.append(" ");
                list.append(n);
            }
        }
        System.out.println("COUNT -> " + count);
        System.out.println("VALUES -> " + list);
    }
}

// Made by JetiHub - J000