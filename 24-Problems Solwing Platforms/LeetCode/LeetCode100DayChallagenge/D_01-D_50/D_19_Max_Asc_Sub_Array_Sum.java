public class D_19_Max_Asc_Sub_Array_Sum {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 20, 30, 5, 10, 50}; // Example input
        int result = solution.maxAscendingSum(nums);
        System.out.println("Maximum Ascending Subarray Sum: " + result);
    }
}

class Solution {
    public int maxAscendingSum(int[] nums) {
        int max = nums[0];
        int currmax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i]) {
                currmax = currmax + nums[i];
            } else {
                max = Math.max(max, currmax);
                currmax = nums[i];
            }
        }
        max = Math.max(max, currmax);
        return max;
    }
}
