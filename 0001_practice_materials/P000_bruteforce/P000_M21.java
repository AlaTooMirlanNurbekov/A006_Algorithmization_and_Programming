/*
    P000_M21 - TEAM SELECTION WITH REQUIRED SKILLS

    TASK: u have N candidates. Each candidate has some skills.
    You need a team that covers ALL required skills.
    Find the minimum number of people needed.
    If impossible, print -1.

    SKILLS MODEL: We represent skills using bits.
    Example skills: {Java, SQL, UI, Network}
    A candidate skill mask might look like 1011 (has Java, UI, Network)

    IDEA:
    Try every subset of candidates (2^N subsets).
    For each subset:
    - combine skills using OR
    - count team size
    Keep the smallest team that covers all required skills.

    OUTPUT:
    For each test case, it prints the minimum team size or -1.
*/

public class P000_M21 {

    static int minTeamSize(int[] skills, int requiredMask) {
        int n = skills.length;
        int total = 1 << n;
        int best = Integer.MAX_VALUE;

        for (int mask = 0; mask < total; mask++) {
            int have = 0;
            int size = 0;

            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    have |= skills[i];
                    size++;
                }
            }

            if (have == requiredMask && size < best) {
                best = size;
            }
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    public static void main(String[] args) {
        //skills bits: 1=Java, 2=SQL, 4=UI, 8=Network
        int required = 1 | 2 | 4 | 8;

        int[] skills1 = {
                1 | 2,     // candidate 0: Java SQL
                4,         // candidate 1: UI
                8,         // candidate 2: Network
                2 | 8,     // candidate 3: SQL Network
                1 | 4      // candidate 4: Java UI
        };

        int[] skills2 = {
                1, 2, 4 // missing Network completely
        };

        System.out.println(minTeamSize(skills1, required));
        System.out.println(minTeamSize(skills2, required));
    }
}

// Made by JetiHub - J000
