import java.util.HashMap;
import java.util.Map;

public class D_06_TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap to store the numbers and their indices
        Map<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the remaining value to find
            int remaining = target - nums[i];
            
            // Check if the remaining value is already in the hashmap
            if (map.containsKey(remaining)) {
                // Return the indices of the two numbers that add up to the target
                return new int[] { map.get(remaining), i };
            }
            
            // Add the current number and its index to the hashmap
            map.put(nums[i], i);
        }
        
        // Return an empty array if no solution is found
        return new int[] {};
    }

    public static void main(String[] args) {
        // Example 1: Using D_06_TwoSumSolution
        D_06_TwoSumSolution sol1 = new D_06_TwoSumSolution();
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        
        int[] result1 = sol1.twoSum(nums1, target1);
        
        if (result1.length > 0) {
            System.out.println("D_06_TwoSumSolution Indices: " + result1[0] + ", " + result1[1]);
        } else {
            System.out.println("No two sum solution found in D_06_TwoSumSolution.");
        }

        // Example 2: Using Solution
        Solution sol2 = new Solution();
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        
        int[] result2 = sol2.twoSum(nums2, target2);
        
        if (result2[0] != 0 || result2[1] != 0) {
            System.out.println("Solution Indices: " + result2[0] + ", " + result2[1]);
        } else {
            System.out.println("No two sum solution found in Solution.");
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
}
