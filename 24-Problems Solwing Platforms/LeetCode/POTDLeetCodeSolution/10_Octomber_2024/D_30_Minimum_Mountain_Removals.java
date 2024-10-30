import java.util.*;

public class D_30_Minimum_Mountain_Removals {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Step 1: Longest Increasing Subsequence (LIS) from the left
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Step 2: Longest Decreasing Subsequence (LDS) from the right
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Step 3: Find the longest bitonic subsequence
        int maxMountainSize = 0;
        for (int i = 1; i < n - 1; i++) {
            if (lis[i] > 1 && lds[i] > 1) {
                maxMountainSize = Math.max(maxMountainSize, lis[i] + lds[i] - 1);
            }
        }

        // Step 4: Minimum removals to achieve the longest mountain
        return n - maxMountainSize;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        D_30_Minimum_Mountain_Removals solution = new D_30_Minimum_Mountain_Removals();

        int[] nums = {2, 1, 1, 5, 6, 2, 3, 1};
        int result = solution.minimumMountainRemovals(nums);

        System.out.println("Minimum number of removals to make mountain array: " + result);
    }
}
