import java.util.Arrays;
public class D_26_Find_Target_Sum_Ways {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 1, 1, 1, 1}; // Example input array
        int target = 3; // Example target
        int result = solution.findTargetSumWays(nums, target);
        System.out.println("Number of ways to reach the target sum: " + result);
    }
}
class Solution {

    private int subsetSum(int[] nums, int s) {
        int n = nums.length;
        int[][] t = new int[n + 1][s + 1];

        // Initialize the first row to 0 and the first column to 1
        for (int col = 0; col <= s; col++) {
            t[0][col] = 0;
        }
        for (int row = 0; row <= n; row++) {
            t[row][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                if (nums[i - 1] == 0) {
                    t[i][j] = t[i - 1][j];
                } else if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][s];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        long zeros = Arrays.stream(nums).filter(x -> x == 0).count();

        if (target > sum) {
            return 0;
        }

        if ((sum - target) % 2 != 0) {
            return 0;
        }

        int s1 = (sum - target) / 2;

        return (int) Math.pow(2, zeros) * subsetSum(nums, s1);
    }
}