import java.util.Arrays;

public class D_11_Maximum_Beauty {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 6, 1, 2, 9};
        int k = 2;
        System.out.println("Maximum Beauty: " + solution.maximumBeauty(nums, k));
    }
}

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0, j = 0;
        int maxBeauty = 0;

        // Sliding window
        while (i < n) {
            while (j < n && nums[j] - nums[i] <= 2 * k) {
                j++;
            }

            maxBeauty = Math.max(maxBeauty, j - i);
            i++;
        }

        return maxBeauty;
    }
}
