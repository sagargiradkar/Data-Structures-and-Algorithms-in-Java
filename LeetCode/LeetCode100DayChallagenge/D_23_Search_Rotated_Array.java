import java.util.Scanner;

public class D_23_Search_Rotated_Array {
    public static void main(String[] args) {
        // Input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        
        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        
        System.out.print("Enter the target element to search: ");
        int target = sc.nextInt();

        // Call the search function
        Solution sol = new Solution();
        int result = sol.search(nums, target);

        // Output the result
        if (result != -1) {
            System.out.println("Target element found at index: " + result);
        } else {
            System.out.println("Target element not found.");
        }
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // If the target is found at mid, return the index
            if (nums[mid] == target) {
                return mid;
            }

            // Check if the left half is sorted
            if (nums[start] <= nums[mid]) {
                // Check if the target lies within the left sorted portion
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;  // Search the left half
                } else {
                    start = mid + 1;  // Search the right half
                }
            } else {
                // If the right half is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;  // Search the right half
                } else {
                    end = mid - 1;  // Search the left half
                }
            }
        }

        // Return -1 if the target is not found
        return -1;
    }
}
