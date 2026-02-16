/*
    P000_M29 - MINIMIZE LATE PENALTY

    TASK: You have N jobs
    Each job has:
    - duration time[i]
    - deadline deadline[i]
    - penalty penalty[i] if it finishes after its deadline
    Choose an order to minimize total penalty

    HOW PENALTY WORKS:
    We simulate the schedule in the chosen order.
    If finishTime > deadline then add penalty.

    IDEA:try every permutation of job indices.
    Simulate and compute penalty and keep the minimum

    OUTPUT:for each test case, it prints the minimum total penalty
*/

public class P000_M29 {

    static int best;
    static int penaltyForOrder(int[] order, int[] time, int[] deadline, int[] penalty) {
        int t = 0;
        int total = 0;
        for (int idx : order) {
            t += time[idx];
            if (t > deadline[idx]) total += penalty[idx];
        }
        return total;
    }

    static void permute(int[] order, int pos, int[] time, int[] deadline, int[] penalty) {
        if (pos == order.length) {
            int p = penaltyForOrder(order, time, deadline, penalty);
            if (p < best) best = p;
            return;
        }
        for (int i = pos; i < order.length; i++) {
            int tmp = order[pos];
            order[pos] = order[i];
            order[i] = tmp;
            permute(order, pos + 1, time, deadline, penalty);
            tmp = order[pos];
            order[pos] = order[i];
            order[i] = tmp;
        }
    }

    static int minLatePenalty(int[] time, int[] deadline, int[] penalty) {
        int n = time.length;
        int[] order = new int[n];
        for (int i = 0; i < n; i++) order[i] = i;
        best = Integer.MAX_VALUE;
        permute(order, 0, time, deadline, penalty);
        return best;
    }

    public static void main(String[] args) {
        int[] time1 = {3, 2, 4};
        int[] dead1 = {3, 3, 6};
        int[] pen1  = {10, 5, 20};

        // 2
        int[] time2 = {2, 3, 1, 4};
        int[] dead2 = {2, 3, 3, 6};
        int[] pen2  = {8, 6, 4, 12};

        System.out.println(minLatePenalty(time1, dead1, pen1));
        System.out.println(minLatePenalty(time2, dead2, pen2));
    }
}


// Made by JetiHub - J000