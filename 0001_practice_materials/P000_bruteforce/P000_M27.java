/*
    P000_M27 - HAMILTONIAN PATH EXISTS

    TASK: given an undirected graph with N nodes (N small)
    check if there exists a Hamiltonian path
    A Hamiltonian path visits every node exactly once

    IDEA: any possible visiting order is a permutation of nodes
    For each permutation, check if every consecutive pair has an edge
    If any permutation works, answer is true

    OUTPUT:for each test graph, it prints true or false.
*/

public class P000_M27 {

    static boolean found;

    static void permute(int[] p, int pos, boolean[][] g) {
        if (found) return;

        if (pos == p.length) {
            for (int i = 0; i < p.length - 1; i++) {
                if (!g[p[i]][p[i + 1]]) return;
            }
            found = true;
            return;
        }
        for (int i = pos; i < p.length; i++) {
            int tmp = p[pos];
            p[pos] = p[i];
            p[i] = tmp;
            permute(p, pos + 1, g);
            tmp = p[pos];
            p[pos] = p[i];
            p[i] = tmp;
        }
    }

    static boolean hamiltonianPathExists(boolean[][] g) {
        int n = g.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        found = false;
        permute(p, 0, g);
        return found;
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

        boolean[][] g2 = graph(5, new int[][]{
                {0,1},{1,2},{2,0},
                {3,4}
        });
        System.out.println(hamiltonianPathExists(g1));
        System.out.println(hamiltonianPathExists(g2));
    }
}


// Made by JetiHub - J000