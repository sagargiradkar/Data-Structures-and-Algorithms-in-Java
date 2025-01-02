// D_02_Count_Subarrays.java
import java.util.HashMap;

public class D_02_Count_Subarrays {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {1, 1, 1};
        int k = 2;
        int result = solution.countSubarrays(arr, k);
        System.out.println("Count of subarrays with sum " + k + ": " + result);
    }
}

class Solution {
    public int countSubarrays(int[] arr, int k) {
        // HashMap to store prefix sums and their counts
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // Base case: prefix sum 0 occurs once

        int count = 0;
        int currentSum = 0;

        // Traverse the array
        for (int num : arr) {
            currentSum += num;

            // Check if (currentSum - k) exists in the map
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }

            // Update the map with the current sum
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }
}
