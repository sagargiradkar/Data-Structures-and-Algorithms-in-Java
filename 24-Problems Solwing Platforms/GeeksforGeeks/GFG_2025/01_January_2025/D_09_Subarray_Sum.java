// D_09_Subarray_Sum.java
import java.util.ArrayList;

public class D_09_Subarray_Sum {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 7, 5};
        int target = 12;

        ArrayList<Integer> result = solution.subarraySum(arr, target);
        System.out.println("Subarray with the given sum: " + result);
    }
}

// User function Template for Java
class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0, currentSum = 0;

        for (int end = 0; end < arr.length; end++) {
            currentSum += arr[end];

            // Shrink the window from the left if currentSum exceeds target
            while (currentSum > target && start <= end) {
                currentSum -= arr[start];
                start++;
            }

            // Check if currentSum equals the target
            if (currentSum == target) {
                result.add(start + 1); // Convert to 1-based index
                result.add(end + 1);
                return result;
            }
        }

        // If no subarray is found, return [-1]
        result.add(-1);
        return result;
    }
}
