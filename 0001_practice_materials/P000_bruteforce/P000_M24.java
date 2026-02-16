/*
    P000_M24 - MINIMUM VERTEX COVER SIZE

    TASK: given an undirected graph with N nodes (N small),
    find the size of the smallest vertex cover.
    Vertex cover means every edge has at least one endpoint chosen.

    IDEA: try every subset of nodes.
    A subset is a cover if for every edge (u,v) either u is in subset or v is in subset.
    Keep the smallest subset size.

    OUTPUT: for each test graph, it prints the minimum vertex cover size.
*/

public class P000_M24 {

    static boolean isCover(int n, int[][] edges, int mask) {
        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            boolean uIn = ((mask >> u) & 1) == 1;
            boolean vIn = ((mask >> v) & 1) == 1;

            if (!uIn && !vIn) return false;
        }
        return true;
    }

    static int minVertexCoverSize(int n, int[][] edges) {
        int total = 1 << n;
        int best = Integer.MAX_VALUE;
        for (int mask = 0; mask < total; mask++) {
            int size = Integer.bitCount(mask);
            if (size >= best) continue;

            if (isCover(n, edges, mask)) {
                best = size;
            }
        }
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    public static void main(String[] args) {
        int n1 = 5;
        int[][] edges1 = {
                {0,1},{1,2},{0,2},
                {2,3},
                {3,4}
        };
        int n2 = 6;
        int[][] edges2 = {
                {0,1},{1,2},{2,3},{3,4},{4,5}
        };

        System.out.println(minVertexCoverSize(n1, edges1));
        System.out.println(minVertexCoverSize(n2, edges2));
    }
}


// Made by JetiHub - J000