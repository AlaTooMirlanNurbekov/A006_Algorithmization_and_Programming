/*
    P000_Z04 - 4x4 LATIN SQUARE

    TASK: fill a 4x4 grid with numbers 1..4
    Each row must contain 1..4 exactly once
    Each column must contain 1..4 exactly once
    Print one valid grid

    IDEA: Fill cell by cell
    Try values 1..4
    Check row and column constraints
    Backtrack when stuck

    WHAT THIS PROGRAM PRINTS: one valid 4x4 Latin square
*/

public class P000_Z04 {

    static int[][] grid = new int[4][4];
    static boolean ok(int r, int c, int val) {
        for (int j = 0; j < 4; j++) if (grid[r][j] == val) return false;
        for (int i = 0; i < 4; i++) if (grid[i][c] == val) return false;
        return true;
    }

    static boolean solve(int pos) {
        if (pos == 16) return true;
        int r = pos / 4;
        int c = pos % 4;

        for (int val = 1; val <= 4; val++) {
            if (ok(r, c, val)) {
                grid[r][c] = val;

                if (solve(pos + 1)) return true;

                grid[r][c] = 0;
            }
        }
        return false;
    }

    static void print() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        solve(0);
        print();
    }
}



// Made by JetiHub - J000
