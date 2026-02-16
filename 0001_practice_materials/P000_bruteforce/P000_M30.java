/*
    P000_M30 - TRAVELING SALESMAN MIN TOUR

    TASK: given a distance matrix dist for N cities (N small)
    start at city 0, visit every other city exactly once, and return to city 0
    Output the minimum possible tour cost

    IDEA: the order of visiting cities 1..N-1 is a permutation
    For each permutation:
    0 -> perm[0] -> perm[1] -> ... -> perm[last] -> 0
    Compute the cost and keep the minimum

    OUTPUT: for each test matrix, it prints the minimum tour cost.
*/

public class P000_M30 {

    static int best;

    static int tourCost(int[] perm, int[][] dist) {
        int cost = 0;
        int cur = 0;

        for (int x : perm) {
            cost += dist[cur][x];
            cur = x;
        }
        cost += dist[cur][0];
        return cost;
    }

    static void permute(int[] perm, int pos, int[][] dist) {
        if (pos == perm.length) {
            int cost = tourCost(perm, dist);
            if (cost < best) best = cost;
            return;
        }

        for (int i = pos; i < perm.length; i++) {
            int tmp = perm[pos];
            perm[pos] = perm[i];
            perm[i] = tmp;
            permute(perm, pos + 1, dist);
            tmp = perm[pos];
            perm[pos] = perm[i];
            perm[i] = tmp;
        }
    }

    static int tspMinTour(int[][] dist) {
        int n = dist.length;
        int[] perm = new int[n - 1];
        for (int i = 0; i < n - 1; i++) perm[i] = i + 1;

        best = Integer.MAX_VALUE;
        permute(perm, 0, dist);
        return best;
    }

    public static void main(String[] args) {
        int[][] dist1 = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int[][] dist2 = {
                {0, 2, 9, 10, 7},
                {2, 0, 6, 4, 3},
                {9, 6, 0, 8, 5},
                {10, 4, 8, 0, 6},
                {7, 3, 5, 6, 0}
        };

        System.out.println(tspMinTour(dist1));
        System.out.println(tspMinTour(dist2));
    }
}


// Made by JetiHub - J000