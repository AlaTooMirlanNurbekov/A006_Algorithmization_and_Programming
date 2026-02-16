/*
    P000_M25 - MAX CUT

    TASK: given an undirected graph with weighted edges and N nodes (N small)
    split nodes into two groups such that the total weight of edges crossing
    between the groups is maximized. Output the maximum cut value

    THE IDEA: A partition is a bitmask
    bit=0 means left group
    bit=1 means right group
    For each mask compute cut weight and keep the maximumm

    OUTPUT: for each test graph, it prints the maximum cut value.
*/

public class P000_M25 {

    static int maxCut(int n, int[][] edges) {
        int total = 1 << n;
        int best = 0;
        for (int mask = 0; mask < total; mask++) {
            int sum = 0;
            for (int[] e : edges) {
                int u = e[0];
                int v = e[1];
                int w = e[2];

                int gu = (mask >> u) & 1;
                int gv = (mask >> v) & 1;

                if (gu != gv) sum += w;
            }
            if (sum > best) best = sum;
        }

        return best;
    }

    public static void main(String[] args) {
        int n1 = 4;
        int[][] edges1 = {
                {0,1,5},
                {1,2,6},
                {2,3,4},
                {0,3,7},
                {0,2,3}
        };

        int n2 = 5;
        int[][] edges2 = {
                {0,1,1},
                {1,2,2},
                {2,3,3},
                {3,4,4},
                {0,4,5}
        };

        System.out.println(maxCut(n1, edges1));
        System.out.println(maxCut(n2, edges2));
    }
}


// Made by JetiHub - J000