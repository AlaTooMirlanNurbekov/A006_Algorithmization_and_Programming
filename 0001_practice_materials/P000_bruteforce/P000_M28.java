/*
    P000_M28 - MINIMIZE TOTAL WAITING TIME

    TASK: You have N tasks with durations.
    If you do tasks in some order, each task waits for all previous tasks to finish.
    Total waiting time is the sum of waiting times for all tasks.
    Find the minimum possible total waiting time.

    EXAMPLE:
    If durations are [3, 1, 2]
    Order [1,2,3] gives smaller total waiting than [3,2,1]

    IDEA: try every permutation of tasks as the order.
    Compute total waiting time and keep the minimum.

    OUTPUT: for each test array, it prints the minimum total waiting time.
*/

public class P000_M28 {

    static long best;

    static long totalWaiting(int[] order) {
        long timePassed = 0;
        long totalWait = 0;
        for (int i = 0; i < order.length; i++) {
            totalWait += timePassed;
            timePassed += order[i];
        }
        return totalWait;
    }

    static void permute(int[] a, int pos) {
        if (pos == a.length) {
            long w = totalWaiting(a);
            if (w < best) best = w;
            return;
        }

        for (int i = pos; i < a.length; i++) {
            int tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
            permute(a, pos + 1);
            tmp = a[pos];
            a[pos] = a[i];
            a[i] = tmp;
        }
    }

    static long minTotalWaiting(int[] durations) {
        int[] a = durations.clone();
        best = Long.MAX_VALUE;
        permute(a, 0);
        return best;
    }

    public static void main(String[] args) {
        int[] t1 = {3, 1, 2};
        int[] t2 = {5, 2, 4, 1};
        System.out.println(minTotalWaiting(t1));
        System.out.println(minTotalWaiting(t2));
    }
}

// Made by JetiHub - J000
