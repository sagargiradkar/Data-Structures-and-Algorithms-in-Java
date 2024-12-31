import java.util.HashSet;

public class D_31_Longest_Consecutive {
    static class Solution {
        // Function to return the length of the longest subsequence of consecutive integers.
        public int longestConsecutive(int[] arr) {
            if (arr == null || arr.length == 0) {
                return 0;
            }

            HashSet<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
            }

            int longestStreak = 0;

            for (int num : arr) {
                // Check if it is the start of a sequence
                if (!set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    // Count the streak length
                    while (set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }

                    // Update the longest streak
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }

            return longestStreak;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] arr1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive subsequence: " + solution.longestConsecutive(arr1)); // Output: 4

        int[] arr2 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println("Longest consecutive subsequence: " + solution.longestConsecutive(arr2)); // Output: 7

        int[] arr3 = {};
        System.out.println("Longest consecutive subsequence: " + solution.longestConsecutive(arr3)); // Output: 0

        int[] arr4 = {1, 2, 0, 1};
        System.out.println("Longest consecutive subsequence: " + solution.longestConsecutive(arr4)); // Output: 3
    }
}
