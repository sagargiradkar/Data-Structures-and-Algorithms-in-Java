// D_15_Longest_Subarray_With_Sum_K.java
import java.util.HashMap;

public class D_15_Longest_Subarray_With_Sum_K {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {1, -1, 5, -2, 3};
        int k1 = 3;
        System.out.println(solution.longestSubarray(arr1, k1)); // Expected: 4

        int[] arr2 = {-2, -1, 2, 1};
        int k2 = 1;
        System.out.println(solution.longestSubarray(arr2, k2)); // Expected: 2

        int[] arr3 = {1, 2, 3};
        int k3 = 3;
        System.out.println(solution.longestSubarray(arr3, k3)); // Expected: 2

        int[] arr4 = {1, 2, 3, -3, -2, 1};
        int k4 = 3;
        System.out.println(solution.longestSubarray(arr4, k4)); // Expected: 4
    }
}

class Solution {
    public int longestSubarray(int[] arr, int k) {
        // Map to store the first occurrence of each prefix sum
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int currSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            
            // Case 1: If the current sum equals k
            if (currSum == k) {
                maxLength = i + 1;
            }
            
            // Case 2: If currSum - k exists in the map
            if (prefixSumMap.containsKey(currSum - k)) {
                int length = i - prefixSumMap.get(currSum - k);
                maxLength = Math.max(maxLength, length);
            }
            
            // Case 3: Store the first occurrence of currSum in the map
            if (!prefixSumMap.containsKey(currSum)) {
                prefixSumMap.put(currSum, i);
            }
        }
        
        return maxLength;
    }
}
