/*
    P000_M20 - 0/1 KNAPSACK

    TASK: u have items with weights and values
    You can take an item at most once. Given capacity W, find the maximum total value you can carry

    THE IDEA: each item is either taken or not taken -> bitmask.
    For every subset:
    - compute total weight
    - compute total value
    If weight <= W, it is valid. Keep the best value.

    OUTPUT: for each test case, it prints: bestValue
*/

public class P000_M20 {

    static int knapsackBrute(int[] w, int[] v, int W) {
        int n = w.length;
        int totalMasks = 1 << n;
        int bestValue = 0;

        for (int mask = 0; mask < totalMasks; mask++) {
            int weightSum = 0;
            int valueSum = 0;

            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) {
                    weightSum += w[i];
                    valueSum += v[i];
                }
            }
            if (weightSum <= W && valueSum > bestValue) {
                bestValue = valueSum;
            }
        }
        return bestValue;
    }

    public static void main(String[] args) {
        int[] w1 = {2, 3, 4, 5};
        int[] v1 = {3, 4, 5, 8};

        int[] w2 = {5, 4, 6, 3};
        int[] v2 = {10, 40, 30, 50};

        int[] caps = {5, 7, 10};

        for (int W : caps) {
            System.out.println("W=" + W + " -> " + knapsackBrute(w1, v1, W));
        }
        System.out.println();

        for (int W : caps) {
            System.out.println("W=" + W + " -> " + knapsackBrute(w2, v2, W));
        }
    }
}


// Made by JetiHub - J000