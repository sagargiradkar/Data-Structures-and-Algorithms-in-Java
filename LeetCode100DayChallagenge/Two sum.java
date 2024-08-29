import java.util.HashMap;
import java.util.Map;

class twoSum {
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
        Solution sol = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        
        int[] result = sol.twoSum(nums, target);
        
        if(result.length > 0) {
            System.out.println("Indices: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }
}