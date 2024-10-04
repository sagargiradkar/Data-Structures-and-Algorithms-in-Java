import java.util.*;

public class D_08_AddTowArrayFormOfInteger {
    public static void main(String[] args) {
        // Example input
        int[] num = {1, 2, 0, 0};
        int k = 34;
        
        // Create an instance of Solution class
        Solution solution = new Solution();
        
        // Call the method and get the result
        List<Integer> result = solution.addToArrayForm(num, k);
        
        // Print the result
        System.out.println(result);
    }
}

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();

        int p = num.length - 1;
        int carry = 0;

        while (p >= 0 || k > 0) {
            int numVal = 0;

            if (p >= 0) {
                numVal = num[p];
            }

            int d = k % 10;  // Extract last digit from k
            int sum = numVal + d + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ans.add(digit);

            p--;
            k = k / 10;  // Remove the last digit from k
        }

        if (carry > 0) {
            ans.add(carry);
        }

        Collections.reverse(ans);
        return ans;
    }
}
