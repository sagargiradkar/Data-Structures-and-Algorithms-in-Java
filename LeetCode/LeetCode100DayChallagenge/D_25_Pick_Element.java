class D_25_Pick_Element {

    // Function to find a peak element in the array
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        } else if (nums[0] > nums[1]) {
            return 0;
        } else if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        } else {
            int start = 1;
            int end = nums.length - 2;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid] < nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            return -1;
        }
    }

    // Main method to test the solution with 5 test cases
    public static void main(String[] args) {
        D_25_Pick_Element solution = new D_25_Pick_Element();

        // Test case 1: Peak in the middle
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Peak element index in test case 1: " + solution.findPeakElement(nums1)); // Output: 2

        // Test case 2: Peak at the start
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println("Peak element index in test case 2: " + solution.findPeakElement(nums2)); // Output: 0

        // Test case 3: Peak at the end
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Peak element index in test case 3: " + solution.findPeakElement(nums3)); // Output: 4

        // Test case 4: Multiple peaks
        int[] nums4 = {1, 3, 20, 4, 1, 0};
        System.out.println("Peak element index in test case 4: " + solution.findPeakElement(nums4)); // Output: 2

        // Test case 5: Single element array
        int[] nums5 = {10};
        System.out.println("Peak element index in test case 5: " + solution.findPeakElement(nums5)); // Output: 0
    }
}
