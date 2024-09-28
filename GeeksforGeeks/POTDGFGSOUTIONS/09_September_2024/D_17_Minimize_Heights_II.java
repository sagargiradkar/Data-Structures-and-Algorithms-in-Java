import java.util.*;
public class D_17_Minimize_Heights_II {

    public static void main(String[] args) {

        // Sample test cases (replace with your desired inputs)
        int[] arr1 = {1, 5, 8, 10};
        int k1 = 2;
        int result1 = getMinDiff(arr1, k1);
        System.out.println("Minimum difference for arr1 and k1: " + result1); // Expected output: 5

        int[] arr2 = {3, 9, 12, 16, 20};
        int k2 = 3;
        int result2 = getMinDiff(arr2, k2);
        System.out.println("Minimum difference for arr2 and k2: " + result2); // Expected output: 11
    }

    public static int getMinDiff(int[] arr, int k) {
        // Code for calculating minimum height difference (unchanged)
        Arrays.sort(arr);

        int n = arr.length;
        int minDiff = arr[n - 1] - arr[0]; // Initial difference

        for (int i = 1; i < n; i++) {
            int min = Math.max(arr[0] + k, arr[i] - k);
            int max = Math.min(arr[n - 1] - k, arr[i] + k);
            minDiff = Math.min(minDiff, max - min);
        }

        return minDiff;
    }
}