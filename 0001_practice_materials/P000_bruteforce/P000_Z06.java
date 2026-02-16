/*
    P000_H06 - HAMILTONIAN CYCLE EXISTS

    TASK: given an undirected graph with N nodes (N small),
    check if there exists a Hamiltonian cycle.
    A Hamiltonian cycle visits every node exactly once and returns to the start.

    IDEA:
    Fix the start node as 0.
    Generate every permutation of nodes 1..N-1 as a visiting order.
    Check:
      0 -> p[0] -> p[1] -> ... -> p[last] -> 0
    If all edges exist, we found a cycle.

    OUTPUT: for each test graph, it prints true or false.
*/

public class P000_H06 {

    static boolean found;

    static void permute(int[] p, int pos, boolean[][] g) {
        if (found) return;

        if (pos == p.length) {
            int prev = 0;
            for (int i = 0; i < p.length; i++) {
                int cur = p[i];
                if (!g[prev][cur]) return;
                prev = cur;
            }
            if (!g[prev][0]) return;
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

    static boolean hamiltonianCycleExists(boolean[][] g) {
        int n = g.length;
        if (n <= 1) return true;
        int[] p = new int[n - 1];
        for (int i = 0; i < n - 1; i++) p[i] = i + 1;
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
                {0,1},{1,2},{2,3},{3,4},{4,0}
        });

        boolean[][] g2 = graph(5, new int[][]{
                {0,1},{1,2},{2,3},{3,4}
        });
        System.out.println(hamiltonianCycleExists(g1));
        System.out.println(hamiltonianCycleExists(g2));
    }
}


// Made by JetiHub - J000