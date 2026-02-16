/*
    P000_M03 - 3 SUM CLOSEST (BRUTE FORCE SEARCH)

    TASK:
    Given an array and a target sum S, find a triple (i<j<k) whose sum is closest to S
    Output that closest sum (not the indices)
    If there are ties (same distance), choose the smaller sum

    WHY THIS IS BRUTE FORCE:
    We try every triple and measure the distance to S. Keep the best answer seen so far

    WHAT THIS PROGRAM PRINTS: for each test (array, S), it prints: closestSum
*/

public class P000_M03 {

    static int threeSumClosest(int[] a, int S) {
        int n = a.length;
        // Start with any triple sum as "best". (Assume n >= 3 in our tests)
        int bestSum = a[0] + a[1] + a[2];
        int bestDiff = Math.abs(bestSum - S);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = a[i] + a[j] + a[k];
                    int diff = Math.abs(sum - S);
                    // We prefer smaller diff; if tie, prefer smaller sum
                    if (diff < bestDiff || (diff == bestDiff && sum < bestSum)) {
                        bestDiff = diff;
                        bestSum = sum;
                    }
                }
            }
        }
        return bestSum;
    }

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3, 4, 5},
                {-1, 2, 1, -4},
                {10, 20, 30, 40},
                {0, 0, 0, 1},
                {-5, -2, 7, 9}
        };
        int[] targets = {10, 1, 55, 2, 3};

        for (int i = 0; i < arrays.length; i++) {
            System.out.println("S=" + targets[i] + " -> " + threeSumClosest(arrays[i], targets[i]));
        }
    }
}


// Made by JetiHub - J000