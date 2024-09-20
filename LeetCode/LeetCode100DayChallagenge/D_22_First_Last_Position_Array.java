public class D_22_First_Last_Position_Array {
    // Method to search for the first and last occurrence of the target
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        ans[0] = firstOccurance(nums, target);
        ans[1] = lastOccurance(nums, target);
        return ans;
    }

    // Method to find the first occurrence of the target
    public int firstOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;  // Search on the left side for the first occurrence
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // Method to find the last occurrence of the target
    public int lastOccurance(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int ans = -1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                ans = mid;
                start = mid + 1;  // Search on the right side for the last occurrence
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    // Main method to run the code
    public static void main(String[] args) {
        D_22_First_Last_Position_Array solution = new D_22_First_Last_Position_Array();
        
        // Example input
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        
        // Call the searchRange method and store the result
        int[] result = solution.searchRange(nums, target);
        
        // Output the result
        System.out.println("First and Last Occurrence of target: [" + result[0] + ", " + result[1] + "]");
    }
}
