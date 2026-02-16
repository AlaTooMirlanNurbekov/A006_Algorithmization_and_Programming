/*
    P000_Z11 - EXACT COVER EXISTS

    TASK: Universe has U elements 0..U-1
    You are given M sets (each set is a subset of the universe)
    Check if there exists a selection of sets such that
      - every element is covered exactly once
    This means no overlaps and no missing elements

    REPRESENTATION: each set is a bitmask over U elements
    Example U=5, set mask 10101 means elements 0,2,4

    BRUTE FORCE IDEA: Try every subset of the M sets
    Combine selected sets with OR
    Also detect overlap using AND
    Valid exact cover means
      - overlap never happens
      - final cover equals all elements

    OUTPUT: true or false for each test case
*/

public class P000_Z11 {

    static boolean exactCoverExists(int U, int[] sets) {
        int M = sets.length;
        int all = (1 << U) - 1;
        int total = 1 << M;

        for (int mask = 0; mask < total; mask++) {
            int cover = 0;
            boolean overlap = false;
            for (int i = 0; i < M; i++) {
                if (((mask >> i) & 1) == 1) {
                    int s = sets[i];

                    if ((cover & s) != 0) {
                        overlap = true;
                        break;
                    }
                    cover |= s;
                }
            }

            if (!overlap && cover == all) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int U1 = 5;
        int[] sets1 = {
                (1 << 0) | (1 << 1),
                (1 << 2),
                (1 << 3) | (1 << 4)
        };
        int U2 = 5;
        int[] sets2 = {
                (1 << 0) | (1 << 1),
                (1 << 1) | (1 << 2),
                (1 << 3) | (1 << 4)
        };
        System.out.println(exactCoverExists(U1, sets1));
        System.out.println(exactCoverExists(U2, sets2));
    }
}


// Made by JetiHub - J000