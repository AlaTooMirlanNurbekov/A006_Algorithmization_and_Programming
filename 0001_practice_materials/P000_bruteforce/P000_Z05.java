/*
    P000_Z05 - MAGIC SQUARE 3x3

    TASK: place numbers 1..9 into a 3x3 grid so that every row, column, and diagonal sums to 15
    Print one valid square

    BRUTE FORCE IDEA: try all permutations of 1..9
    For each permutation check if it matches the magic rules
    Stop at the first valid one

    OUTPUT: One 3x3 magic square
*/

public class P000_Z05 {

    static boolean isMagic(int[] p) {
        return p[0] + p[1] + p[2] == 15 &&
               p[3] + p[4] + p[5] == 15 &&
               p[6] + p[7] + p[8] == 15 &&
               p[0] + p[3] + p[6] == 15 &&
               p[1] + p[4] + p[7] == 15 &&
               p[2] + p[5] + p[8] == 15 &&
               p[0] + p[4] + p[8] == 15 &&
               p[2] + p[4] + p[6] == 15;
    }

    static boolean solve(int[] a, int pos) {
        if (pos == a.length) {
            if (isMagic(a)) {
                for (int i = 0; i < 9; i++) {
                    System.out.print(a[i] + " ");
                    if (i % 3 == 2) System.out.println();
                }
                return true;
            }
            return false;
        }

        for (int i = pos; i < a.length; i++) {
            int tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
            if (solve(a, pos + 1)) return true;
            tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
        }

        return false;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9};
        solve(a, 0);
    }
}



// Made by JetiHub - J000
