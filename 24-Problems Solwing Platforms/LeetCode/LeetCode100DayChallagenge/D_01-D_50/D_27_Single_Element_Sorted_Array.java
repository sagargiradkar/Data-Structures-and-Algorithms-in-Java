class D_27_Single_Element_Sorted_Array {

    // Function to find the single non-duplicate element in a sorted array
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[nums.length - 1] != nums[nums.length - 2]) {
            return nums[nums.length - 1];
        }

        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (mid % 2 == 1) {
                if (nums[mid - 1] == nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // Main method to test the solution with 5 test cases
    public static void main(String[] args) {
        D_27_Single_Element_Sorted_Array solution = new D_27_Single_Element_Sorted_Array();

        // Test case 1: Single element is in the middle
        int[] nums1 = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Single non-duplicate element in test case 1: " + solution.singleNonDuplicate(nums1)); // Output: 2

        // Test case 2: Single element is at the start
        int[] nums2 = {1, 2, 2, 3, 3, 4, 4};
        System.out.println("Single non-duplicate element in test case 2: " + solution.singleNonDuplicate(nums2)); // Output: 1

        // Test case 3: Single element is at the end
        int[] nums3 = {1, 1, 2, 2, 3, 3, 4};
        System.out.println("Single non-duplicate element in test case 3: " + solution.singleNonDuplicate(nums3)); // Output: 4

        // Test case 4: Single element is in an even-length array
        int[] nums4 = {1, 1, 2, 2, 3};
        System.out.println("Single non-duplicate element in test case 4: " + solution.singleNonDuplicate(nums4)); // Output: 3

        // Test case 5: Only one element in the array
        int[] nums5 = {99};
        System.out.println("Single non-duplicate element in test case 5: " + solution.singleNonDuplicate(nums5)); // Output: 99
    }
}
