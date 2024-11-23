import java.util.Arrays;

public class D_16_Power_Of_K_Size {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] results = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            // Extract the current subarray
            int[] subarray = new int[k];
            for (int j = 0; j < k; j++) {
                subarray[j] = nums[i + j];
            }
            
            // Check if the subarray is sorted and consecutive
            if (isSorted(subarray) && isConsecutive(subarray)) {
                results[i] = subarray[k - 1]; // Maximum element of a sorted subarray
            } else {
                results[i] = -1;
            }
        }
        
        return results;
    }
    
    // Helper method to check if an array is sorted
    private boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
    
    // Helper method to check if an array contains consecutive numbers
    private boolean isConsecutive(int[] arr) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (max - min + 1 == arr.length);
    }

    // Main method for testing
    public static void main(String[] args) {
        D_16_Power_Of_K_Size solution = new D_16_Power_Of_K_Size();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 4, 3, 2, 5};
        int k1 = 3;
        System.out.println("Test Case 1: " + Arrays.toString(solution.resultsArray(nums1, k1)));
        // Output: [3, 4, -1, -1, -1]

        // Test Case 2
        int[] nums2 = {2, 2, 2, 2, 2};
        int k2 = 4;
        System.out.println("Test Case 2: " + Arrays.toString(solution.resultsArray(nums2, k2)));
        // Output: [-1, -1]

        // Test Case 3
        int[] nums3 = {3, 2, 3, 2, 3, 2};
        int k3 = 2;
        System.out.println("Test Case 3: " + Arrays.toString(solution.resultsArray(nums3, k3)));
        // Output: [-1, 3, -1, 3, -1]
    }
}
