/*
    P000_M26 - ASSIGNMENT MIN COST

    TASK: u have N workers and N jobs
    cost[i][j] is the cost if worker i does job j.
    Assign each worker to exactly one job so that total cost is minimum
    Output the minimum total cost

    IDEA:a complete assignment is just a permutation of jobs.
    Example for N=3:
      perm = [2,0,1] means
      worker 0 -> job 2
      worker 1 -> job 0
      worker 2 -> job 1
    Try all permutations and keep the smallest sum.

    OUTPUT:for each test matrix, it prints the minimum total cost.
*/

public class P000_M26 {

    static int best;
    static void permuteJobs(int[] jobs, int pos, int[][] cost) {
        if (pos == jobs.length) {
            int sum = 0;
            for (int i = 0; i < jobs.length; i++) {
                sum += cost[i][jobs[i]];
            }
            if (sum < best) best = sum;
            return;
        }

        for (int i = pos; i < jobs.length; i++) {
            int tmp = jobs[pos];
            jobs[pos] = jobs[i];
            jobs[i] = tmp;
            permuteJobs(jobs, pos + 1, cost);
            tmp = jobs[pos];
            jobs[pos] = jobs[i];
            jobs[i] = tmp;
        }
    }

    static int minAssignmentCost(int[][] cost) {
        int n = cost.length;
        int[] jobs = new int[n];
        for (int i = 0; i < n; i++) jobs[i] = i;
        best = Integer.MAX_VALUE;
        permuteJobs(jobs, 0, cost);
        return best;
    }

    public static void main(String[] args) {
        int[][] cost1 = {
                {9, 2, 7},
                {6, 4, 3},
                {5, 8, 1}
        };
        int[][] cost2 = {
                {10, 15, 20, 25},
                {5, 9, 10, 13},
                {6, 12, 8, 11},
                {9, 14, 16, 7}
        };
        System.out.println(minAssignmentCost(cost1));
        System.out.println(minAssignmentCost(cost2));
    }
}


// Made by JetiHub - J000