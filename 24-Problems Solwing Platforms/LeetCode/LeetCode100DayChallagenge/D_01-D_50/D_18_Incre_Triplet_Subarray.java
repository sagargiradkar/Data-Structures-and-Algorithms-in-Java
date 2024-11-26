public class D_18_Incre_Triplet_Subarray {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5}; // Example input
        boolean result = solution.increasingTriplet(nums);
        System.out.println("Contains Increasing Triplet Subarray: " + result);
    }
}

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        int third = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];

            if (first >= ele) {
                first = ele;
            } else if (second >= ele) {
                second = ele;
            } else {
                third = ele;
                return true;
            }
        }
        return false;
    }
}
