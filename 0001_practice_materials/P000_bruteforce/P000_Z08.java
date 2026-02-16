/*
    P000_Z08 - SET COVER MINIMUM SETS

    TASK: You have a universe of elements 0..U-1
    You also have M sets, each set covers some elements
    Choose the minimum number of sets so that all elements are covered
    If impossible, print -1

    IDEA: Each set is either taken or not taken
    That is a bitmask over M sets
    For each mask:
      - combine coverage by OR
      - count how many sets are used
      - keep the smallest that covers everything

    OUTPUT:
    Minimum number of sets or -1
*/

public class P000_Z08 {

    static int minSetCover(int U, int[] sets) {
        int M = sets.length;
        int all = (1 << U) - 1;

        int total = 1 << M;
        int best = Integer.MAX_VALUE;

        for (int mask = 0; mask < total; mask++) {
            int usedCount = Integer.bitCount(mask);
            if (usedCount >= best) continue;
            int cover = 0;
            for (int i = 0; i < M; i++) {
                if (((mask >> i) & 1) == 1) {
                    cover |= sets[i];
                }
            }
            if (cover == all) best = usedCount;
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    public static void main(String[] args) {
        int U = 5; // elements 0..4
        int[] sets1 = {
                (1 << 0) | (1 << 1),
                (1 << 2),
                (1 << 3) | (1 << 4),
                (1 << 1) | (1 << 2) | (1 << 3),
                (1 << 0) | (1 << 4)
        };
        int[] sets2 = {
                (1 << 0),
                (1 << 1),
                (1 << 2)
        };
        System.out.println(minSetCover(U, sets1));
        System.out.println(minSetCover(U, sets2));
    }
}



// Made by JetiHub - J000
