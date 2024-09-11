public class D_14_Prod_Array_Ex_Self {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input array
        int[] nums = {1, 2, 3, 4};
        
        // Calculating the product except self
        int[] result = solution.productExceptSelf(nums);
        
        // Printing the result
        System.out.print("Product array except self: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] right = new int[n];

        int prod = 1;

        // Fill the right array with products of elements to the right
        for (int i = n - 1; i >= 0; i--) {
            prod *= nums[i];
            right[i] = prod;
        }
        
        int[] ans = new int[n];
        int left = 1;

        // Calculate the final product except self
        for (int i = 0; i < n - 1; i++) {
            int val = left * right[i + 1];
            ans[i] = val;
            left *= nums[i];
        }
        
        ans[n - 1] = left; // For the last element
        return ans;
    }
}
