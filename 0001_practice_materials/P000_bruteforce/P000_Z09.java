/*
    P000_H09 - MIN DOMINATING SET SIZE

    TASK: given an undirected graph with N nodes (N small),
    find the minimum size of a dominating set.
    A dominating set means every node is either:
      - in the chosen set
      - or connected to a chosen node

    IDEA: try every subset of nodes.
    For each subset check if it dominates all nodes.
    Keep the smallest size.

    OUTPUT: minimum dominating set size.
*/

public class P000_H09 {

    static boolean dominates(boolean[][] g, int mask) {
        int n = g.length;
        for (int v = 0; v < n; v++) {
            boolean covered = ((mask >> v) & 1) == 1;
            if (!covered) {
                for (int u = 0; u < n; u++) {
                    if (((mask >> u) & 1) == 1 && g[u][v]) {
                        covered = true;
                        break;
                    }
                }
            }

            if (!covered) return false;
        }
        return true;
    }

    static int minDominatingSetSize(boolean[][] g) {
        int n = g.length;
        int total = 1 << n;
        int best = Integer.MAX_VALUE;

        for (int mask = 0; mask < total; mask++) {
            int size = Integer.bitCount(mask);
            if (size >= best) continue;

            if (dominates(g, mask)) best = size;
        }
        return best;
    }

    static boolean[][] graph(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) g[i][i] = true;
        for (int[] e : edges) {
            g[e[0]][e[1]] = true;
            g[e[1]][e[0]] = true;
        }
        return g;
    }

    public static void main(String[] args) {
        boolean[][] g1 = graph(6, new int[][]{
                {0,1},{1,2},{2,3},{3,4},{4,5}
        });

        boolean[][] g2 = graph(6, new int[][]{
                {0,1},{0,2},{0,3},{0,4},{0,5}
        });

        System.out.println(minDominatingSetSize(g1));
        System.out.println(minDominatingSetSize(g2));
    }
}


// Made by JetiHub - J000