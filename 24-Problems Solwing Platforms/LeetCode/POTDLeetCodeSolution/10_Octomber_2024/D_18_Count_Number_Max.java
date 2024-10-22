import java.util.Scanner;

public class D_18_Count_Number_Max {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input array size
        System.out.println("Enter the size of the array:");
        int n = sc.nextInt();
        
        // Take input array elements
        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Create an instance of the Solution class and call the countMaxOrSubsets method
        Solution solution = new Solution();
        int result = solution.countMaxOrSubsets(nums);

        // Print the result
        System.out.println("The number of subsets with maximum OR value is: " + result);
        
        sc.close();
    }
}

class Solution {
    public int countMaxOrSubsets(int[] nums) {
        // Target OR value
        int targetOr = 0;
        for (int num : nums) {
            targetOr |= num;
        }
        
        // DP array to store results
        Integer[][] dp = new Integer[nums.length][targetOr + 1];
        return recur(0, nums, 0, targetOr, dp);
    }

    public int recur(int index, int[] nums, int curOr, int targetOr, Integer[][] dp) {
        // Base case
        if (index == nums.length) {
            return (curOr == targetOr) ? 1 : 0;
        }
        
        // Check if already solved
        if (dp[index][curOr] != null) {
            return dp[index][curOr];
        }
        
        // Pick current number
        int pickCount = recur(index + 1, nums, curOr | nums[index], targetOr, dp);
        
        // Do not pick current number
        int noPickCount = recur(index + 1, nums, curOr, targetOr, dp);
        
        // Store the result in dp array
        return dp[index][curOr] = pickCount + noPickCount;
    }
}
