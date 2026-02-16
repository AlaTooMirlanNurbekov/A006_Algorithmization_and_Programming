/*
    P000_M08 - COUNT INCREASING TRIPLETS (BRUTE FORCE O(n^3))

    TASK:
    Given an array, count the number of triples (i < j < k) such that:
        a[i] < a[j] < a[k]

    WHY THIS IS IMPORTANT:
    This pattern appears in:
      - trend detection (values increasing over time)
      - analyzing sequences in data
      - understanding how quickly combinations explode

    BRUTE FORCE IDEA: try every triple and check the inequality

    WHAT THIS PROGRAM PRINTS: for each test array, it prints: count
*/

public class P000_M08 {

    static int countIncreasingTriplets(int[] a) {
        int n = a.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (a[i] < a[j] && a[j] < a[k]) count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] tests = {
                {1, 2, 3, 4},
                {4, 3, 2, 1},
                {1, 5, 2, 4, 3},
                {2, 2, 2},
                {-1, 0, 1, 2}
        };
        for (int[] arr : tests) {
            System.out.println(countIncreasingTriplets(arr));
        }
    }
}


// Made by JetiHub - J000