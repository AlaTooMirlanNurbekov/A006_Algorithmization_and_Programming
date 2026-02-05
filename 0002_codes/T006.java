/*
    MAGIC SQUARE SOLVER (WORLD TWO APPROACH)

    The idea:
    We want to build the magic square slowly, one cell at a time.
    After every number we place, we immediately check:
    "Can this still become a valid magic square?"

    If the answer is NO → we stop and go back.
    This saves a lot of useless work.

    This algorightm is Backtracking + Pruning (using constraints)

    This is smart cuz:
    - We do NOT try all permutations
    - We stop early when something is already wrong
    - We only continue when success is still possible
*/

public class T006 {

    // This is the 3x3 grid we are trying to fill
    static int[][] grid = new int[3][3];

    // This array remembers which numbers are already used
    // Example: used[5] == true means number 5 is already in the grid
    static boolean[] used = new boolean[10];

    /*
        This function checks whether the current grid
        is still valid after placing a number at (r, c).

        IMPORTANT:
        We are NOT checking the full grid here.
        We are only checking whether we have already broken the rules.
    */
    static boolean isValid(int r, int c) {
        int sum;

        // To check the row 
        // Add all numbers in the current row
        sum = 0;
        for (int j = 0; j < 3; j++) {
            sum += grid[r][j];
        }

        // If the row sum is already bigger than 15, it can never be fixed
        if (sum > 15) return false;

        // If this row is complete and the sum is not exactly 15, it's wrong
        if (c == 2 && sum != 15) return false;

        // Check the column
        sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += grid[i][c];
        }

        if (sum > 15) return false;
        if (r == 2 && sum != 15) return false;

        //Checking the main diagonal
        // Only if this cell is part of the diagonal
        if (r == c) {
            sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += grid[i][i];
            }

            if (sum > 15) return false;
            if (r == 2 && sum != 15) return false;
        }

        // This is where we checkthe second diagonal
        if (r + c == 2) {
            sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += grid[i][2 - i];
            }

            if (sum > 15) return false;
            if (r == 2 && sum != 15) return false;
        }

        // If we reach here, nothing is broken yet
        return true;
    }

    /*
        This function tries to fill the grid step by step.

        pos tells us which cell we are filling right now:
        pos = 0 → first cell
        pos = 8 → last cell
    */
    static void solve(int pos) {

        // If we placed numbers in all 9 cells, we found a solution
        if (pos == 9) {
            printGrid();
            System.exit(0); // Stop after finding the first solution
        }

        // Convert position number into row and column
        int r = pos / 3;
        int c = pos % 3;

        // Try every number from 1 to 9
        for (int num = 1; num <= 9; num++) {

            // Only try numbers that are not used yet
            if (!used[num]) {

                // Place the number into the grid
                grid[r][c] = num;
                used[num] = true;

                // Check if this choice is still reasonable
                if (isValid(r, c)) {
                    // If yes, move to the next cell
                    solve(pos + 1);
                }

                // If it didn't work, undo everything and try another number
                grid[r][c] = 0;
                used[num] = false;
            }
        }
    }

    // Prints the grid nicely
    static void printGrid() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Program starts here
    public static void main(String[] args) {
        solve(0);
    }
}


// Made by JetiHub - J000