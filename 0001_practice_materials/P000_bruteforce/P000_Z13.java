/*
    P000_Z13 - COUNT HAMILTONIAN CYCLES 

    TASK: Given an undirected graph with N nodes (N small)
    Count how many Hamiltonian cycles exist

    IMPORTANT NOTE: We fix the start node as 0
    We generate permutations of nodes 1..N-1
    Each permutation represents one possible cycle:
      0 -> p[0] -> p[1] -> ... -> p[last] -> 0

    DOUBLE COUNT NOTE: In undirected graphs, a cycle can be traversed forward or backward
    This program counts both directions as different
    That is fine for brute force practice

    WHAT THIS PROGRAM PRINTS: Cycle count for each test graph
*/

public class P000_Z13 {

    static int count;

    static void permute(int[] p, int pos, boolean[][] g) {
        if (pos == p.length) {
            int prev = 0;

            for (int i = 0; i < p.length; i++) {
                int cur = p[i];
                if (!g[prev][cur]) return;
                prev = cur;
            }

            if (!g[prev][0]) return;

            count++;
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

    static int countHamiltonianCycles(boolean[][] g) {
        int n = g.length;

        if (n <= 2) return 0;

        int[] p = new int[n - 1];
        for (int i = 0; i < n - 1; i++) p[i] = i + 1;

        count = 0;
        permute(p, 0, g);

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
                {0,1},{1,2},{2,3},{3,0},{0,2},{1,3}
        });

        boolean[][] g2 = graph(5, new int[][]{
                {0,1},{1,2},{2,3},{3,4},{4,0}
        });

        System.out.println(countHamiltonianCycles(g1));
        System.out.println(countHamiltonianCycles(g2));
    }
}

// Made by JetiHub - J000