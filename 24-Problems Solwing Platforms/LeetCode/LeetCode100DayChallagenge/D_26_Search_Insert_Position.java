class D_26_Search_Insert_Position {

    // Function to find the target or its insert position in the array
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

    // Main method to test the solution with 5 test cases
    public static void main(String[] args) {
        D_26_Search_Insert_Position solution = new D_26_Search_Insert_Position();

        // Test case 1: Target exists in the array
        int[] nums1 = {1, 3, 5, 6};
        int target1 = 5;
        System.out.println("Test case 1 - Insert position: " + solution.searchInsert(nums1, target1)); // Output: 2

        // Test case 2: Target does not exist, should be inserted
        int[] nums2 = {1, 3, 5, 6};
        int target2 = 2;
        System.out.println("Test case 2 - Insert position: " + solution.searchInsert(nums2, target2)); // Output: 1

        // Test case 3: Target is greater than all elements, should be inserted at the end
        int[] nums3 = {1, 3, 5, 6};
        int target3 = 7;
        System.out.println("Test case 3 - Insert position: " + solution.searchInsert(nums3, target3)); // Output: 4

        // Test case 4: Target is smaller than all elements, should be inserted at the start
        int[] nums4 = {1, 3, 5, 6};
        int target4 = 0;
        System.out.println("Test case 4 - Insert position: " + solution.searchInsert(nums4, target4)); // Output: 0

        // Test case 5: Target is equal to the first element
        int[] nums5 = {1, 3, 5, 6};
        int target5 = 1;
        System.out.println("Test case 5 - Insert position: " + solution.searchInsert(nums5, target5)); // Output: 0
    }
}
