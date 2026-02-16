/*
    P000_Z18 - COUNT ALL TOPOLOGICAL ORDERS

    TASK: given a directed acyclic graph with N nodes (N small)
    count how many different topological orders exist

    BRUTE FORCE IDEA: At each step choose any node with indegree 0 that is not used
    Place it next in the ordering
    Remove it and reduce indegree of its outgoing neighbors
    Continue until all nodes are placed

    WHAT THIS PROGRAM PRINTS: Number of topological orders for each test DAG
*/

public class P000_Z18 {

    static int n;
    static boolean[][] edge;
    static int[] indeg;
    static boolean[] used;
    static long count;

    static void dfs(int placed) {
        if (placed == n) {
            count++;
            return;
        }

        for (int v = 0; v < n; v++) {
            if (!used[v] && indeg[v] == 0) {
                used[v] = true;

                int[] changed = new int[n];
                int ch = 0;

                for (int to = 0; to < n; to++) {
                    if (edge[v][to]) {
                        indeg[to]--;
                        changed[ch++] = to;
                    }
                }
                dfs(placed + 1);

                for (int i = 0; i < ch; i++) {
                    indeg[changed[i]]++;
                }

                used[v] = false;
            }
        }
    }

    static long countTopOrders(int N, int[][] edges) {
        n = N;
        edge = new boolean[n][n];
        indeg = new int[n];
        used = new boolean[n];
        count = 0;

        for (int[] e : edges) {
            int a = e[0], b = e[1];
            if (!edge[a][b]) {
                edge[a][b] = true;
                indeg[b]++;
            }
        }

        dfs(0);
        return count;
    }

    public static void main(String[] args) {
        int[][] e1 = {
                {0,2},{1,2}
        };

        int[][] e2 = {
                {0,1},{0,2},{1,3},{2,3}
        };

        System.out.println(countTopOrders(3, e1));
        System.out.println(countTopOrders(4, e2));
    }
}


// Made by JetiHub - J000