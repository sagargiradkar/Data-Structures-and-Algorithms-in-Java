/*
    Problem Statement:
    Given an array of integers `nums` and an integer `target`, return the indices of the two numbers such that they add up to the target.
    
    Constraints:
    - Each input has exactly one solution.
    - You may not use the same element twice.
    - Return the answer in any order.

    Solution Explanation:
    - We iterate through the array while storing elements in a HashMap.
    - For each element, we calculate the remaining value required to reach the target.
    - If this remaining value already exists in the HashMap, we return the indices.
    - Otherwise, we store the current element in the HashMap for future reference.

    Optimized Approach:
    - The original approach is already optimized using a HashMap (O(n) time complexity).
    - No further improvements are needed, but we will add additional checks for robustness.
*/

import java.util.HashMap;
import java.util.Map;

class TwoSumSolution {

    // Original Method (Your approach)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining)) {
                return new int[] { map.get(remaining), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }

    // Optimized Method (Added input validation)
    public int[] optimizedTwoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {}; // Return empty array for invalid input
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining)) {
                return new int[] { map.get(remaining), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {}; // No solution found
    }

    // Test cases to verify both methods
    public static void main(String[] args) {
        TwoSumSolution sol = new TwoSumSolution();

        int[][] testCases = {
            {2, 7, 11, 15},  // Expected output: [0, 1] (2 + 7 = 9)
            {3, 2, 4},       // Expected output: [1, 2] (2 + 4 = 6)
            {1, 5, 3, 8},    // Expected output: [0, 2] (1 + 3 = 4)
            {-1, -2, -3, -4},// Expected output: [0, 2] (-1 + -3 = -4)
            {6, 3, 7, 2}     // Expected output: [1, 3] (3 + 2 = 5)
        };

        int[] targets = {9, 6, 4, -4, 5};

        for (int i = 0; i < testCases.length; i++) {
            int[] result = sol.optimizedTwoSum(testCases[i], targets[i]);

            if (result.length > 0) {
                System.out.println("Test Case " + (i + 1) + " -> Indices: " + result[0] + ", " + result[1]);
            } else {
                System.out.println("Test Case " + (i + 1) + " -> No two sum solution found.");
            }
        }
    }
}

/*
    Time & Space Complexity Analysis:

    - Original Method:
        * Time Complexity: O(n) (Single pass through the array)
        * Space Complexity: O(n) (Uses HashMap to store elements)

    - Optimized Method:
        * Time Complexity: O(n) (Same single-pass HashMap approach)
        * Space Complexity: O(n) (Same HashMap usage)

    Test Cases:
    1. Input: nums = [2, 7, 11, 15], target = 9  -> Output: [0, 1]
    2. Input: nums = [3, 2, 4], target = 6       -> Output: [1, 2]
    3. Input: nums = [1, 5, 3, 8], target = 4    -> Output: [0, 2]
    4. Input: nums = [-1, -2, -3, -4], target = -4 -> Output: [0, 2]
    5. Input: nums = [6, 3, 7, 2], target = 5    -> Output: [1, 3]
*/

