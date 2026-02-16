/*
    P000_M22 - MAXIMUM CLIQUE SIZE

    TASK: given an undirected graph with N nodes (N small),
    find the size of the largest clique.
    A clique means every pair of nodes in the subset has an edge.

    BRUTE FORCE IDEA: Try every subset of nodes.
    Check if it is a clique by verifying all pairs inside the subset.
    Track the maximum size.

    WHAT THIS PROGRAM PRINTS: for each test graph, it prints the maximum clique size.
*/

public class P000_M22 {

    static boolean isClique(boolean[][] g, int mask) {
        int n = g.length;

        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 0) continue;

            for (int j = i + 1; j < n; j++) {
                if (((mask >> j) & 1) == 0) continue;

                if (!g[i][j]) return false;
            }
        }

        return true;
    }

    static int maxCliqueSize(boolean[][] g) {
        int n = g.length;
        int total = 1 << n;
        int best = 0;

        for (int mask = 0; mask < total; mask++) {
            if (!isClique(g, mask)) continue;

            int size = Integer.bitCount(mask);
            if (size > best) best = size;
        }

        return best;
    }

    static boolean[][] graphFromEdges(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) g[i][i] = true;
        for (int[] e : edges) {
            int a = e[0];
            int b = e[1];
            g[a][b] = true;
            g[b][a] = true;
        }

        return g;
    }

    public static void main(String[] args) {
        boolean[][] g1 = graphFromEdges(5, new int[][]{
                {0,1},{1,2},{0,2}, // triangle 0-1-2
                {2,3},
                {3,4}
        });
        boolean[][] g2 = graphFromEdges(6, new int[][]{
                {0,1},{0,2},{1,2},{1,3},{2,3} // clique of size 4 on 0,1,2,3
        });
        System.out.println(maxCliqueSize(g1));
        System.out.println(maxCliqueSize(g2));
    }
}


// Made by JetiHub - J000