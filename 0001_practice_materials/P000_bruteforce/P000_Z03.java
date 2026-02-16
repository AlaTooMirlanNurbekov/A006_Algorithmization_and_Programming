/*
    P000_Z03 - 8 QUEENS

    TASK: Place 8 queens on a chessboard so that no two queens attack each other
    Print one valid board

    BRUTE FORCE IDEA: place one queen per row
    Try every column in that row
    If it conflicts with previous queens, skip
    If we fill all rows, we found a solution

    WHAT THIS PROGRAM PRINTS: A board using Q and 
*/

public class P000_Z03 {

    static int[] col = new int[8];
    static boolean safe(int row, int c) {
        for (int r = 0; r < row; r++) {
            int pc = col[r];
            if (pc == c) return false;
            if (Math.abs(pc - c) == Math.abs(r - row)) return false;
        }
        return true;
    }

    static boolean solve(int row) {
        if (row == 8) return true;
        for (int c = 0; c < 8; c++) {
            if (safe(row, c)) {
                col[row] = c;

                if (solve(row + 1)) return true;
            }
        }
        return false;
    }

    static void print() {
        for (int r = 0; r < 8; r++) {
            for (int c = 0; c < 8; c++) {
                System.out.print(col[r] == c ? "Q " : ". ");
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
