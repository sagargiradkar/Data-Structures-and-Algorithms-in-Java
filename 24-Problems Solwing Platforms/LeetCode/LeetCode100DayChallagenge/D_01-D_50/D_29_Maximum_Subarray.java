class D_29_Maximum_Subarray {

    // Function to find the maximum sum of a subarray using Kadane's Algorithm
    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            max = Math.max(max, currSum);
        }
        return max;
    }

    // Main method to test the solution with 5 test cases
    public static void main(String[] args) {
        D_29_Maximum_Subarray solution = new D_29_Maximum_Subarray();

        // Test case 1: Mixed positive and negative numbers
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum for test case 1: " + solution.maxSubArray(nums1)); // Output: 6

        // Test case 2: All positive numbers
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Maximum subarray sum for test case 2: " + solution.maxSubArray(nums2)); // Output: 15

        // Test case 3: All negative numbers
        int[] nums3 = {-1, -2, -3, -4, -5};
        System.out.println("Maximum subarray sum for test case 3: " + solution.maxSubArray(nums3)); // Output: -1

        // Test case 4: Single element
        int[] nums4 = {10};
        System.out.println("Maximum subarray sum for test case 4: " + solution.maxSubArray(nums4)); // Output: 10

        // Test case 5: Mix of large numbers
        int[] nums5 = {-10, 100, -300, 400, -200, 500, -100};
        System.out.println("Maximum subarray sum for test case 5: " + solution.maxSubArray(nums5)); // Output: 700
    }
}
