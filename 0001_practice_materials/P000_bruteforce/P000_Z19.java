/*
    P000_Z19 - N QUEENS COUNT

    TASK:
    Given N, count how many ways to place N queens on an N x N board
    so that no two queens attack each other

    IDEA: Place one queen per row and then try every column
    reject choices that conflict with earlier rows
    Count every complete solution

    WHAT THIS PROGRAM PRINTS:
    For each test N, it prints the number of solutions
*/

public class P000_Z19 {

    static int N;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;
    static long count;

    static void dfs(int r) {
        if (r == N) {
            count++;
            return;
        }

        for (int c = 0; c < N; c++) {
            int d1 = r - c + (N - 1);
            int d2 = r + c;

            if (!col[c] && !diag1[d1] && !diag2[d2]) {
                col[c] = true;
                diag1[d1] = true;
                diag2[d2] = true;

                dfs(r + 1);

                col[c] = false;
                diag1[d1] = false;
                diag2[d2] = false;
            }
        }
    }

    static long countNQueens(int n) {
        N = n;
        col = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];
        count = 0;
        dfs(0);
        return count;
    }

    public static void main(String[] args) {
        int[] tests = {4, 5, 6, 7, 8};

        for (int n : tests) {
            System.out.println("N=" + n + " -> " + countNQueens(n));
        }
    }
}


// Made by JetiHub - J000