/*
    P000_H02 - 4x4 SUDOKU SOLVER

    TASK: Solve a 4x4 Sudoku
    Numbers are 1..4
    Each row and column must contain 1..4 exactly once
    Each 2x2 block must contain 1..4 exactly once
    0 means empty

    IDEA: Fill empty cells one by one
    Try numbers 1..4
    If placement breaks rules, undo and try next

    RESULT: One solved grid
*/

public class P000_H02 {
    static int[][] grid = {
            {1, 0, 0, 4},
            {0, 0, 1, 0},
            {0, 3, 0, 0},
            {2, 0, 0, 3}
    };

    static boolean ok(int r, int c, int val) {
        for (int j = 0; j < 4; j++) if (grid[r][j] == val) return false;
        for (int i = 0; i < 4; i++) if (grid[i][c] == val) return false;

        int br = (r / 2) * 2;
        int bc = (c / 2) * 2;
        for (int i = br; i < br + 2; i++) {
            for (int j = bc; j < bc + 2; j++) {
                if (grid[i][j] == val) return false;
            }
        }
        return true;
    }

    static boolean solve(int pos) {
        if (pos == 16) return true;

        int r = pos / 4;
        int c = pos % 4;
        if (grid[r][c] != 0) return solve(pos + 1);
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