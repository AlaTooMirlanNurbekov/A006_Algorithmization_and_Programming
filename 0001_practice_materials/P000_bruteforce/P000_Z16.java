/*
    P000_Z16 - COUNT ALL VALID 3 COLORINGS

    TASK: Given an undirected graph with N nodes (N small),
    count how many different 3 colorings exist such that
    no edge connects two nodes with the same color

    BRUTE FORCE IDEA: Each node can be color 0, 1, or 2
    That is 3^N assignments
    We try all assignments using recursion
    When we assign a color to a node, we immediately check edges to already colored nodes
    If a conflict appears, stop that branch

    WHAT THIS PROGRAM PRINTS: Number of valid 3 colorings for each test graph
*/

public class P000_Z16 {

    static boolean[][] g;
    static int[] color;
    static long count;

    static void dfs(int v) {
        if (v == color.length) {
            count++;
            return;
        }

        for (int c = 0; c < 3; c++) {
            color[v] = c;
            boolean ok = true;
            for (int u = 0; u < v; u++) {
                if (g[v][u] && color[u] == color[v]) {
                    ok = false;
                    break;
                }
            }
            if (ok) dfs(v + 1);
        }
    }

    static long count3Colorings(boolean[][] graph) {
        g = graph;
        color = new int[g.length];
        count = 0;
        dfs(0);
        return count;
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
        boolean[][] g1 = graph(4, new int[][]{
                {0,1},{1,2},{2,3},{3,0}
        });

        boolean[][] g2 = graph(4, new int[][]{
                {0,1},{0,2},{0,3}
        });

        System.out.println(count3Colorings(g1));
        System.out.println(count3Colorings(g2));
    }
}


// Made by JetiHub - J000