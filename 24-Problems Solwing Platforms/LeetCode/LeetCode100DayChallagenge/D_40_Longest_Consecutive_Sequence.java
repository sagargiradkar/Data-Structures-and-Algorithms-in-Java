import java.util.HashSet;
import java.util.Scanner;

public class D_40_Longest_Consecutive_Sequence {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int t = Integer.parseInt(scanner.nextLine().trim());

        while (t-- > 0) {
            // Read input array size
            int n = Integer.parseInt(scanner.nextLine().trim());

            // Read the array elements
            int[] nums = new int[n];
            String[] elements = scanner.nextLine().split("\\s+");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(elements[i]);
            }

            // Create an instance of the Solution class
            Solution obj = new Solution();
            // Call the longestConsecutive method and print the result
            int result = obj.longestConsecutive(nums);
            System.out.println(result);
        }

        scanner.close();
    }
}

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                // Count the length of the sequence
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }
}
