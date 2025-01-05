// D_05_Count_Pairs.java
import java.util.Arrays;

public class D_05_Count_Pairs {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 8;
        int result = solution.countPairs(arr, target);
        System.out.println("Number of pairs with sum less than " + target + ": " + result);
    }
}

class Solution {
    int countPairs(int arr[], int target) {
        // Sort the array
        Arrays.sort(arr);

        int count = 0;
        int left = 0, right = arr.length - 1;

        // Use two pointers to find pairs
        while (left < right) {
            int sum = arr[left] + arr[right];

            // If the sum is less than the target
            if (sum < target) {
                // All pairs (left, left + 1, ..., right) are valid
                count += (right - left);
                left++; // Move left pointer to explore other possibilities
            } else {
                // Move the right pointer to decrease the sum
                right--;
            }
        }

        return count;
    }
}
