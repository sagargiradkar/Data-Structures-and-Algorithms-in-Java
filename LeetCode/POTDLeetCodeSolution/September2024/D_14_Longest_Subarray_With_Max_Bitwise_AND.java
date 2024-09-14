public class D_14_Longest_Subarray_With_Max_Bitwise_AND {
    public int longestSubarray(int[] nums) {
        int maxVal = 0;
        int result = 0;
        int streak = 0;

        // Find the maximum value in the array
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Traverse again to calculate the longest streak of maxVal
        for (int num : nums) {
            if (num == maxVal) {
                streak++;
                result = Math.max(result, streak);
            } else {
                streak = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        D_14_Longest_Subarray_With_Max_Bitwise_AND obj = new D_14_Longest_Subarray_With_Max_Bitwise_AND();
        
        // Example test case
        int[] nums = {1, 2, 2, 3, 3, 3, 2, 2, 2, 3};
        int result = obj.longestSubarray(nums);
        
        System.out.println("The length of the longest subarray with the maximum element is: " + result);
    }
}
