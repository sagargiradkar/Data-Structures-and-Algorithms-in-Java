import java.util.Stack;

public class D_10_Max_Width_Ramp {
    public static void main(String[] args) {
        // Example input for testing
        int[] nums = {6, 0, 8, 2, 1, 5};
        
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Call the maxWidthRamp method and print the result
        int result = solution.maxWidthRamp(nums);
        System.out.println("Maximum Width Ramp: " + result);
    }
}

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        
        // Build the stack with indexes
        for(int i = 0; i < n; i++) {
            if(stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        int ans = Integer.MIN_VALUE;
        
        // Iterate from the end and calculate the ramp width
        for(int i = n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                ans = Math.max(ans, i - stack.pop());
            }
            if(stack.isEmpty()) {
                break;
            }
        }
        
        return ans;
    }
}
