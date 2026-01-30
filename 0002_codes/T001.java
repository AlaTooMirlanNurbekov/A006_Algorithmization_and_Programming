public class T001 {

    static int runCount = 0;
    static int solutionCount = 0;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        permute(nums, 0);
        System.out.println("Total permutations checked: " + runCount);
    }

    public static void permute(int[] arr, int l) {
        if (l == arr.length - 1) {
            runCount++; 
            
            if (isMagic(arr)) {
                solutionCount++;
                
                System.out.println("Solution #" + solutionCount + " found at Run: " + runCount);
                printGrid(arr);
            }
            return;
        }

        for (int i = l; i < arr.length; i++) {
            swap(arr, l, i);
            permute(arr, l + 1);
            swap(arr, l, i);
        }
    }

    public static boolean isMagic(int[] p) {
        return (p[0] + p[1] + p[2] == 15 && 
                p[3] + p[4] + p[5] == 15 && 
                p[6] + p[7] + p[8] == 15 &&
                p[0] + p[3] + p[6] == 15 && 
                p[1] + p[4] + p[7] == 15 && 
                p[2] + p[5] + p[8] == 15 &&
                p[0] + p[4] + p[8] == 15 && 
                p[2] + p[4] + p[6] == 15);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printGrid(int[] p) {
        System.out.println("-------------");
        for (int i = 0; i < 9; i++) {
            System.out.print("| " + p[i] + " ");
            if ((i + 1) % 3 == 0) System.out.println("|");
        }
        System.out.println("-------------");
    }
}