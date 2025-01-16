// D_16_Max_Length_Subarray.java
import java.util.HashMap;

public class D_16_Max_Length_Subarray {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int[] arr1 = {0, 1, 0, 1, 1, 0, 0};
        System.out.println(solution.maxLen(arr1)); // Expected output: 6

        int[] arr2 = {0, 0, 1, 0, 1, 1, 1};
        System.out.println(solution.maxLen(arr2)); // Expected output: 4

        int[] arr3 = {1, 1, 1, 0, 0};
        System.out.println(solution.maxLen(arr3)); // Expected output: 4
    }
}

class Solution {
    public int maxLen(int[] arr) {
        // Map to store the first occurrence of each cumulative sum
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Replace 0 with -1
            cumulativeSum += (arr[i] == 0) ? -1 : 1;

            // Check if cumulativeSum is 0 (subarray starts from index 0)
            if (cumulativeSum == 0) {
                maxLength = i + 1;
            }

            // If cumulativeSum is seen before, calculate subarray length
            if (map.containsKey(cumulativeSum)) {
                maxLength = Math.max(maxLength, i - map.get(cumulativeSum));
            } else {
                // Otherwise, store the first occurrence of this sum
                map.put(cumulativeSum, i);
            }
        }

        return maxLength;
    }
}
