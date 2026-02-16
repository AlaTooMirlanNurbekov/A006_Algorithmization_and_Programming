/*
    P000_Z15 - 3 SAT CHECK

    TASK: You are given a boolean formula in CNF
    Each clause has 3 literals
    A literal is a variable x or its negation !x
    Check if there exists an assignment of true false values that satisfies all clauses

    REPRESENTATION:
    Variables are numbered 1..N
    A literal is an int
      positive means x
      negative means !x
    Example clause: (x1 OR !x2 OR x3) is {1, -2, 3}

    BRUTE FORCE IDEA:
    Try all 2^N assignments
    For each assignment, check all clauses
    If any assignment satisfies, answer is true

    WHAT THIS PROGRAM PRINTS: true or false for each test formula
*/

public class P000_Z15 {

    static boolean valueOfLiteral(int lit, boolean[] val) {
        int var = Math.abs(lit);
        boolean x = val[var];
        return lit > 0 ? x : !x;
    }

    static boolean satisfiable(int nVars, int[][] clauses) {
        int total = 1 << nVars;
        for (int mask = 0; mask < total; mask++) {
            boolean[] val = new boolean[nVars + 1];

            for (int v = 1; v <= nVars; v++) {
                val[v] = ((mask >> (v - 1)) & 1) == 1;
            }

            boolean ok = true;
            for (int[] cl : clauses) {
                boolean clauseOk =
                        valueOfLiteral(cl[0], val) ||
                        valueOfLiteral(cl[1], val) ||
                        valueOfLiteral(cl[2], val);
                if (!clauseOk) {
                    ok = false;
                    break;
                }
            }
            if (ok) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] f1 = {
                {1, 2, 3},
                {-1, 2, -3},
                {1, -2, 3}
        };
        int[][] f2 = {
                {1, 1, 1},
                {-1, -1, -1}
        };
        System.out.println(satisfiable(3, f1));
        System.out.println(satisfiable(1, f2));
    }
}


// Made by JetiHub - J000