// D_03_Ways_To_Split_Array.java
public class D_03_Ways_To_Split_Array {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] nums = {10, 4, -8, 7};
        int result = solution.waysToSplitArray(nums);
        System.out.println("Number of ways to split the array: " + result);
    }
}

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long leftSum = 0;
        int ways = 0;
        for (int i = 0; i < n - 1; i++) { // We split until the second-to-last index
            leftSum += nums[i];
            if (leftSum >= (totalSum - leftSum)) {
                ways++;
            }
        }
        return ways;
    }
}
