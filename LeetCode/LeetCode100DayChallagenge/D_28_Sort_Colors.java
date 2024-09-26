class D_28_Sort_Colors {

    // Function to sort colors (0, 1, 2) in an array using Dutch National Flag algorithm
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, high, mid);
                high--;
            }
        }
    }

    // Helper function to swap two elements in the array
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // Main method to test the solution with 5 test cases
    public static void main(String[] args) {
        D_28_Sort_Colors solution = new D_28_Sort_Colors();

        // Test case 1: Mixed colors
        int[] nums1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums1);
        System.out.print("Sorted colors for test case 1: ");
        printArray(nums1); // Output: [0, 0, 1, 1, 2, 2]

        // Test case 2: Already sorted
        int[] nums2 = {0, 1, 2};
        solution.sortColors(nums2);
        System.out.print("Sorted colors for test case 2: ");
        printArray(nums2); // Output: [0, 1, 2]

        // Test case 3: All elements are the same
        int[] nums3 = {1, 1, 1, 1};
        solution.sortColors(nums3);
        System.out.print("Sorted colors for test case 3: ");
        printArray(nums3); // Output: [1, 1, 1, 1]

        // Test case 4: No 0's present
        int[] nums4 = {1, 2, 1, 2, 1, 2};
        solution.sortColors(nums4);
        System.out.print("Sorted colors for test case 4: ");
        printArray(nums4); // Output: [1, 1, 1, 2, 2, 2]

        // Test case 5: Single element array
        int[] nums5 = {0};
        solution.sortColors(nums5);
        System.out.print("Sorted colors for test case 5: ");
        printArray(nums5); // Output: [0]
    }

    // Helper function to print the array
    public static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
