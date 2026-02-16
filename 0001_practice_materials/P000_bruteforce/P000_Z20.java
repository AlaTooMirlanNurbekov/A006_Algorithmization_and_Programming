/*
    P000_Z20 - MINIMUM GRAPH COLORING NUMBER

    TASK:
    Given an undirected graph with N nodes (N small)
    find the minimum number of colors needed to color the graph
    so that adjacent nodes have different colors
    Output that minimum number

    BRUTE FORCE IDEA:
    Try k = 1..N
    For each k try to color the graph using recursion
    The first k that works is the answer

    WHAT THIS PROGRAM PRINTS:
    Minimum number of colors for each test graph
*/

public class P000_Z20 {

    static boolean[][] g;
    static int[] color;
    static int n;
    static int K;

    static boolean ok(int v, int c) {
        for (int u = 0; u < n; u++) {
            if (g[v][u] && color[u] == c) return false;
        }
        return true;
    }

    static boolean dfs(int v) {
        if (v == n) return true;

        for (int c = 1; c <= K; c++) {
            if (ok(v, c)) {
                color[v] = c;

                if (dfs(v + 1)) return true;

                color[v] = 0;
            }
        }
        return false;
    }

    static int chromaticNumber(boolean[][] graph) {
        g = graph;
        n = g.length;

        for (K = 1; K <= n; K++) {
            color = new int[n];
            if (dfs(0)) return K;
        }

        return n;
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
        boolean[][] g1 = graph(5, new int[][]{
                {0,1},{1,2},{2,3},{3,4}
        });

        boolean[][] g2 = graph(4, new int[][]{
                {0,1},{1,2},{2,3},{3,0},{0,2},{1,3}
        });

        System.out.println(chromaticNumber(g1));
        System.out.println(chromaticNumber(g2));
    }
}


// Made by JetiHub - J000