// D_09_Is_Array_Special.java
import java.util.*;

public class D_09_Is_Array_Special {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[][] queries = {{0, 2}, {1, 4}, {0, 4}};
        
        Solution solution = new Solution();
        boolean[] result = solution.isArraySpecial(nums, queries);
        
        System.out.println("Results: ");
        for (boolean res : result) {
            System.out.println(res);
        }
    }
}

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;

        int[] cumSum = new int[n];
        // cumSum[i] = total count of violating indices till index i
        cumSum[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) { // violating index
                cumSum[i] = cumSum[i - 1] + 1;
            } else {
                cumSum[i] = cumSum[i - 1];
            }
        }

        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            if (cumSum[end] - cumSum[start] == 0) {
                result[i] = true;
            } else {
                result[i] = false;
            }
        }

        return result;
    }
}
