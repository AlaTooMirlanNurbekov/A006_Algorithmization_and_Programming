/*
    P000_Z14 - MAXIMUM BIPARTITE MATCHING

    TASK: You have a bipartite graph Left side size L and Right side size R
    edges[u][v] means left u can match right v
    Find the maximum number of matches

    BRUTE FORCE IDEA: for each left node you either match it to one right node or leave it unmatched
    We use recursion over left nodes
    usedRight[] keeps track of which right nodes are already taken
    Try all possibilities and keep the best

    WHAT THIS PROGRAM PRINTS: Maximum matching size for each test graph
*/

public class P000_Z14 {

    static boolean[][] edges;
    static boolean[] usedRight;
    static int best;
    static void dfs(int u, int current) {
        if (u == edges.length) {
            if (current > best) best = current;
            return;
        }
        dfs(u + 1, current);
        for (int v = 0; v < edges[0].length; v++) {
            if (edges[u][v] && !usedRight[v]) {
                usedRight[v] = true;
                dfs(u + 1, current + 1);
                usedRight[v] = false;
            }
        }
    }

    static int maxMatching(boolean[][] e) {
        edges = e;
        usedRight = new boolean[e[0].length];
        best = 0;
        dfs(0, 0);
        return best;
    }
    public static void main(String[] args) {
        boolean[][] g1 = {
                {true,  true,  false},
                {false, true,  true },
                {true,  false, true }
        };
        boolean[][] g2 = {
                {true, false, false, true},
                {false, true, false, false},
                {true, true, false, false}
        };

        System.out.println(maxMatching(g1));
        System.out.println(maxMatching(g2));
    }
}


// Made by JetiHub - J000