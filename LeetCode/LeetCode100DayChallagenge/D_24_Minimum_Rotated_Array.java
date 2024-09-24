import java.util.Scanner;

public class D_24_Minimum_Rotated_Array {
    public static void main(String[] args) {
        // Input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the rotated sorted array: ");
        int n = sc.nextInt();
        int[] nums = new int[n];

        System.out.println("Enter the elements of the rotated sorted array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call the findMin function
        Solution sol = new Solution();
        int result = sol.findMin(nums);

        // Output the result
        System.out.println("The minimum element in the rotated sorted array is: " + result);
    }
}

class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums[0] < nums[nums.length - 1]) {
            return nums[0];
        }
        
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            // Check if the mid element is the minimum
            if (mid != 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            } 
            // Check if the element after mid is the minimum
            else if (mid != nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } 
            // If the left half is sorted, the minimum must be in the right half
            else if (nums[start] <= nums[mid]) {
                start = mid + 1;
            } 
            // Otherwise, search in the left half
            else {
                end = mid - 1;
            }
        }

        return -1; // In case no minimum is found (this shouldn't happen with valid input)
    }
}
