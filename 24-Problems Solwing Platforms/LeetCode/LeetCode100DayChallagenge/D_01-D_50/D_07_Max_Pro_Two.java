public class D_07_Max_Pro_Two {

    public static void main(String[] args) {
      Solution solution = new Solution();
  
      // Example array
      int[] nums = {2, 3, -2, 7};
  
      // Find the maximum product
      int maxProduct = solution.maxProduct(nums);
  
      // Print the result
      System.out.println("The maximum product of two numbers in the array is: " + maxProduct);
    }
  
    public static class Solution {
      public int maxProduct(int[] nums) {
        int max = -1;
        int smax = -1;
  
        for (int i = 0; i < nums.length; i++) {
          if (max < nums[i]) {
            smax = max;
            max = nums[i];
          } else if (smax < nums[i]) {
            smax = nums[i];
          }
        }
  
        int ans = (max - 1) * (smax - 1);
        return ans;
      }
    }
  }