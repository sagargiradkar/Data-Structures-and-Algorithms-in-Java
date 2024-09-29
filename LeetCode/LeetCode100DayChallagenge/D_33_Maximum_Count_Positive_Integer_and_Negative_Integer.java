public class D_33_Maximum_Count_Positive_Integer_and_Negative_Integer {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example test cases
        int[] nums1 = {-2, -1, -1, 1, 2, 3};
        int[] nums2 = {-3, -2, -1, 0, 0, 1, 2};
        int[] nums3 = {5, 20, 66, 1314};
        int[] nums4 = {-10, -5, -2, -1};

        System.out.println("Maximum count for nums1: " + solution.maximumCount(nums1)); // Output: 3
        System.out.println("Maximum count for nums2: " + solution.maximumCount(nums2)); // Output: 3
        System.out.println("Maximum count for nums3: " + solution.maximumCount(nums3)); // Output: 4
        System.out.println("Maximum count for nums4: " + solution.maximumCount(nums4)); // Output: 4
    }
}

class Solution {
    public int maximumCount(int[] nums) {
        int lastNegIndex = lastNegative(nums) + 1;
        int firstPostIndex = nums.length - firstPositive(nums);
        return Math.max(lastNegIndex, firstPostIndex);
    }

    public int firstPositive(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] > 0) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public int lastNegative(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] < 0) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }
}
