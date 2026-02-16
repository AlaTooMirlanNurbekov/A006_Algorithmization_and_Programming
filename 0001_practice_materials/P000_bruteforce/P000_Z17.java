/*
    P000_Z17 - MAXIMUM INDEPENDENT SET

    TASK: Given an undirected graph with N nodes (N small)
    find the maximum size of an independent set
    Independent set means no two chosen nodes share an edge

    BRUTE FORCE IDEA: Each node can be taken or not taken
    We explore choices using recursion
    If we take node v, we cannot take its neighbors

    PRUNING IDEA: If currentSize + remainingNodes <= best, then this branch cannot beat best
    So we stop early

    WHAT THIS PROGRAM PRINTS: Maximum independent set size for each test graph
*/

public class P000_Z17 {

    static boolean[][] g;
    static int n;
    static int best;

    static void dfs(int v, boolean[] blocked, int size) {
        if (v == n) {
            if (size > best) best = size;
            return;
        }
        if (size + (n - v) <= best) return;

        dfs(v + 1, blocked, size);

        if (!blocked[v]) {
            boolean[] nb = blocked.clone();
            nb[v] = true;
            for (int u = 0; u < n; u++) {
                if (g[v][u]) nb[u] = true;
            }

            dfs(v + 1, nb, size + 1);
        }
    }

    static int maxIndependentSet(boolean[][] graph) {
        g = graph;
        n = g.length;
        best = 0;
        boolean[] blocked = new boolean[n];
        dfs(0, blocked, 0);
        return best;
    }

    static boolean[][] graph(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
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

        System.out.println(maxIndependentSet(g1));
        System.out.println(maxIndependentSet(g2));
    }
}


// Made by JetiHub - J000