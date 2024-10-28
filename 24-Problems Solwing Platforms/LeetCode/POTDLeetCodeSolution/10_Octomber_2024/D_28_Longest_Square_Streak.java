import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class D_28_Longest_Square_Streak {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Solution instance
        Solution solution = new Solution();
        int result = solution.longestSquareStreak(arr);
        
        System.out.println("Longest square streak length: " + result);
    }
}

class Solution {
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> dp = new HashMap<>();
        int maxStreak = -1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            int streak = 1 + dp.getOrDefault(num * num, 0);
            dp.put(num, streak);
            maxStreak = Math.max(maxStreak, streak);
        }

        return maxStreak >= 2 ? maxStreak : -1;
    }
}
