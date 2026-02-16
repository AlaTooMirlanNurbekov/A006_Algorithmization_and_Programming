/*
    P000_M23 - MAXIMUM INDEPENDENT SET SIZE

    TASK: given an undirected graph with N nodes (N small)
    find the size of the largest independent set
    Independent set means no two chosen nodes have an edge between them

    THE IDEA: try every subset of nodes. Check if it is independent by verifying all pairs inside the subset
    Track the largest size.

    Output: for each test graph, it prints the maximum independent set size
*/

public class P000_M23 {

    static boolean isIndependent(boolean[][] g, int mask) {
        int n = g.length;
        for (int i = 0; i < n; i++) {
            if (((mask >> i) & 1) == 0) continue;

            for (int j = i + 1; j < n; j++) {
                if (((mask >> j) & 1) == 0) continue;

                if (g[i][j]) return false;
            }
        }
        return true;
    }

    static int maxIndependentSize(boolean[][] g) {
        int n = g.length;
        int total = 1 << n;
        int best = 0;

        for (int mask = 0; mask < total; mask++) {
            if (!isIndependent(g, mask)) continue;

            int size = Integer.bitCount(mask);
            if (size > best) best = size;
        }

        return best;
    }

    static boolean[][] graphFromEdges(int n, int[][] edges) {
        boolean[][] g = new boolean[n][n];
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
                {0,1},{1,2},{0,2}, // triangle
                {2,3},
                {3,4}
        });

        boolean[][] g2 = graphFromEdges(6, new int[][]{
                {0,1},{1,2},{2,3},{3,4},{4,5} // path
        });
        System.out.println(maxIndependentSize(g1));
        System.out.println(maxIndependentSize(g2));
    }
}


// Made by JetiHub - J000