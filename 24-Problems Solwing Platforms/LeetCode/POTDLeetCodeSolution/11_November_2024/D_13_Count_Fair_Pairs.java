import java.util.Arrays;

public class D_13_Count_Fair_Pairs {

    static class Solution {
        public long countFairPairs(int[] nums, int lower, int upper) {
            int n = nums.length;
            Arrays.sort(nums); // Sort the array, O(n log n)

            long result = 0;

            for (int i = 0; i < n; i++) { // Iterate through each element, O(n * log n)
                int leftIdx = lowerBound(nums, i + 1, n, lower - nums[i]); // Find the first element not less than (lower - nums[i])
                int rightIdx = upperBound(nums, i + 1, n, upper - nums[i]); // Find the first element greater than (upper - nums[i])

                int x = leftIdx - 1 - i;
                int y = rightIdx - 1 - i;

                result += (y - x);
            }

            return result;
        }

        // Java equivalent of lower_bound in C++
        private int lowerBound(int[] nums, int start, int end, int target) {
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] < target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return start;
        }

        // Java equivalent of upper_bound in C++
        private int upperBound(int[] nums, int start, int end, int target) {
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return start;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 3, 5, 7};
        int lower = 4;
        int upper = 8;

        long count = solution.countFairPairs(nums, lower, upper);
        System.out.println("The number of fair pairs is: " + count);
    }
}