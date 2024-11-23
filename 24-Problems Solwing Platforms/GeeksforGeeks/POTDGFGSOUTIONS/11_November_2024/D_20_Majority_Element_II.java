import java.util.ArrayList;
import java.util.List;

public class D_20_Majority_Element_II {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        // Step 1: Identify potential candidates
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) count1++;
            else if (num == candidate2) count2++;
        }

        int n = nums.length;
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        // Step 3: Return result in sorted order
        result.sort(Integer::compareTo);
        return result;
    }

    // Main method
    public static void main(String[] args) {
        D_20_Majority_Element_II solution = new D_20_Majority_Element_II();

        // Test case 1
        int[] arr1 = {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6};
        System.out.println("Test Case 1: " + solution.findMajority(arr1)); // Output: [5, 6]

        // Test case 2
        int[] arr2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2: " + solution.findMajority(arr2)); // Output: []

        // Test case 3
        int[] arr3 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        System.out.println("Test Case 3: " + solution.findMajority(arr3)); // Output: [4]
    }
}
class Solution {
    public int takeCharacters(String s, int k) {
        int n = s.length();

        // Count total occurrences of 'a', 'b', and 'c'
        int countA = 0, countB = 0, countC = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a') countA++;
            else if (ch == 'b') countB++;
            else if (ch == 'c') countC++;
        }

        // If any character occurs less than k, it's impossible to remove k instances
        if (countA < k || countB < k || countC < k) {
            return -1;
        }

        // Sliding window variables
        int i = 0, j = 0;
        int notDeletedWindowSize = 0;

        while (j < n) {
            // Reduce count for the character at index j
            if (s.charAt(j) == 'a') {
                countA--;
            } else if (s.charAt(j) == 'b') {
                countB--;
            } else if (s.charAt(j) == 'c') {
                countC--;
            }

            // If any count falls below k, shrink the window from the left
            while (i <= j && (countA < k || countB < k || countC < k)) {
                if (s.charAt(i) == 'a') {
                    countA++;
                } else if (s.charAt(i) == 'b') {
                    countB++;
                } else if (s.charAt(i) == 'c') {
                    countC++;
                }
                i++;
            }

            // Update the maximum size of the window
            notDeletedWindowSize = Math.max(notDeletedWindowSize, j - i + 1);
            j++;
        }

        // Calculate the minimum minutes required (total length - max window size)
        return n - notDeletedWindowSize;
    }
}