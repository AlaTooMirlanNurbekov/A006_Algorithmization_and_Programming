/*
    P000_Z07 - GRAPH ISOMORPHISM

    TASK: given two undirected graphs G1 and G2 with the same number of nodes N,
    check if they are isomorphic.
    Isomorphic means we can rename nodes in G1 to get exactly G2.

    THE IDEA: to try every permutation mapping of nodes 0..N-1.
    For a mapping p:
      edge (i,j) in G1 must match edge (p[i], p[j]) in G2
    If any permutation works, graphs are isomorphic.

    EXPECTED OUTPUT: true or false for each test pair.
*/

public class P000_Z07 {

    static boolean found;
    static void permute(int[] p, int pos, boolean[][] g1, boolean[][] g2) {
        if (found) return;
        if (pos == p.length) {
            int n = p.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (g1[i][j] != g2[p[i]][p[j]]) return;
                }
            }
            found = true;
            return;
        }

        for (int i = pos; i < p.length; i++) {
            int tmp = p[pos];
            p[pos] = p[i];
            p[i] = tmp;
            permute(p, pos + 1, g1, g2);
            tmp = p[pos];
            p[pos] = p[i];
            p[i] = tmp;
        }
    }

    static boolean isIsomorphic(boolean[][] g1, boolean[][] g2) {
        int n = g1.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) p[i] = i;
        found = false;
        permute(p, 0, g1, g2);

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
        boolean[][] a1 = graph(4, new int[][]{
                {0,1},{1,2},{2,3},{3,0}
        });
        boolean[][] b1 = graph(4, new int[][]{
                {0,2},{2,1},{1,3},{3,0}
        });
        boolean[][] a2 = graph(4, new int[][]{
                {0,1},{1,2},{2,3}
        });
        boolean[][] b2 = graph(4, new int[][]{
                {0,1},{0,2},{0,3}
        });
        System.out.println(isIsomorphic(a1, b1));
        System.out.println(isIsomorphic(a2, b2));
    }
}



// Made by JetiHub - J000
