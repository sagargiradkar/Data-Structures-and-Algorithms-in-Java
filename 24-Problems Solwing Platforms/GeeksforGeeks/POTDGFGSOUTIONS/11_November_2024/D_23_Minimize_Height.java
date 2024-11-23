import java.util.*;

public class D_23_Minimize_Height {
    public static void main(String[] args) {
        // Sample Input
        int k = 3;
        int[] arr = {3, 9, 12, 16, 20};

        // Create an instance of the solution class
        Solution solution = new Solution();

        // Get the result and print it
        int result = solution.getMinDiff(k, arr);
        System.out.println("Minimum difference after modification: " + result);
    }
}

class Solution {
    public int getMinDiff(int k, int[] arr) {
        // Base case: If there is only one tower
        if (arr.length == 1) return 0;

        // Sort the array
        Arrays.sort(arr);

        int n = arr.length;
        int result = arr[n - 1] - arr[0]; // Initial max difference

        // Iterate over each tower and find the minimum difference
        for (int i = 0; i < n - 1; i++) {
            int newMin = Math.min(arr[0] + k, arr[i + 1] - k);
            int newMax = Math.max(arr[n - 1] - k, arr[i] + k);

            // Update the result with the minimum difference found
            result = Math.min(result, newMax - newMin);
        }

        return result;
    }
}
