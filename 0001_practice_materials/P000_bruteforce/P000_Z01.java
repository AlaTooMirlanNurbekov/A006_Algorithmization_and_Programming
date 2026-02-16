/*
    P000_H01 - CRYPTARITHM SOLVER

    TASK: solve the classic puzzle:
        SEND
      + MORE
      = MONEY

    Each letter is a different digit 0..9
    Leading letters cannot be zero
    Print one valid solution

    IDEA: Assign digits to letters by trying all possibilities
    Use used[] to avoid repeating digits
    Check the equation when all letters are assigned

    OUTPUT: One valid assignment and the numbers
*/

public class P000_H01 {

    static boolean[] used = new boolean[10];

    static int S, E, N, D, M, O, R, Y;

    static int number(int a, int b, int c, int d) {
        return a * 1000 + b * 100 + c * 10 + d;
    }

    static void solve() {
        for (S = 1; S <= 9; S++) {
            used[S] = true;

            for (E = 0; E <= 9; E++) if (!used[E]) {
                used[E] = true;

                for (N = 0; N <= 9; N++) if (!used[N]) {
                    used[N] = true;

                    for (D = 0; D <= 9; D++) if (!used[D]) {
                        used[D] = true;

                        for (M = 1; M <= 9; M++) if (!used[M]) {
                            used[M] = true;

                            for (O = 0; O <= 9; O++) if (!used[O]) {
                                used[O] = true;

                                for (R = 0; R <= 9; R++) if (!used[R]) {
                                    used[R] = true;

                                    for (Y = 0; Y <= 9; Y++) if (!used[Y]) {
                                        int SEND = number(S, E, N, D);
                                        int MORE = number(M, O, R, E);
                                        int MONEY = M * 10000 + O * 1000 + N * 100 + E * 10 + Y;

                                        if (SEND + MORE == MONEY) {
                                            System.out.println("S=" + S + " E=" + E + " N=" + N + " D=" + D +
                                                    " M=" + M + " O=" + O + " R=" + R + " Y=" + Y);
                                            System.out.println(SEND + " + " + MORE + " = " + MONEY);
                                            return;
                                        }
                                    }

                                    used[R] = false;
                                }

                                used[O] = false;
                            }

                            used[M] = false;
                        }

                        used[D] = false;
                    }

                    used[N] = false;
                }

                used[E] = false;
            }

            used[S] = false;
        }
    }

    public static void main(String[] args) {
        solve();
    }
}

// Made by JetiHub - J000