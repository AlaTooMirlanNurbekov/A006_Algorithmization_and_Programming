/*
    P000_Z10 - GRAPH 3 COLORING EXISTS

    TASK: given an undirected graph with N nodes (N small),
    check if it can be colored using 3 colors so that
    no edge connects two nodes with the same color.

    BRUTE FORCE IDEA: each node can have color 0, 1, or 2.
    That is 3^N possibilities.
    We generate all assignments using recursion and check edges.

    OUTPUT: true or false for each test graph.
*/

public class P000_Z10 {

    static boolean[][] g;
    static int[] color;
    static boolean ok;
    static void dfs(int v) {
        if (ok) return;

        if (v == color.length) {
            ok = true;
            return;
        }
        for (int c = 0; c < 3; c++) {
            color[v] = c;

            boolean good = true;
            for (int u = 0; u < color.length; u++) {
                if (g[v][u] && u < v && color[u] == color[v]) {
                    good = false;
                    break;
                }
            }
            if (good) dfs(v + 1);
        }
    }

    static boolean threeColoringExists(boolean[][] graph) {
        g = graph;
        color = new int[g.length];
        ok = false;
        dfs(0);
        return ok;
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
                {0,1},{1,2},{2,3},{3,4},{4,0}
        });
        boolean[][] g2 = graph(4, new int[][]{
                {0,1},{1,2},{2,3},{3,0},{0,2},{1,3}
        });
        System.out.println(threeColoringExists(g1));
        System.out.println(threeColoringExists(g2));
    }
}


// Made by JetiHub - J000
