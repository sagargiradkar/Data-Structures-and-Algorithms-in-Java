import java.util.*;

public class D_31_Find_Target_Indices {
    public static void main(String[] args) {
        // Example input array and target value
        int[] nums = {1, 2, 5, 2, 3};
        int target = 2;

        // Create an instance of Solution
        Solution sol = new Solution();

        // Find the target indices
        List<Integer> result = sol.targetIndices(nums, target);

        // Print the result
        System.out.println("Target Indices: " + result);  // Expected output: [1, 2]
    }
}

class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int num = 0;
        int tcount = 0;

        // Count how many elements are less than target and how many match the target
        for (int ele : nums) {
            if (ele == target) {
                tcount++;
            } else if (ele < target) {
                num++;
            }
        }

        // Prepare the answer list
        List<Integer> ans = new ArrayList<>();

        // Fill the list with indices where the target would appear after sorting
        while (tcount > 0) {
            ans.add(num);
            num++;
            tcount--;
        }

        return ans;
    }
}
