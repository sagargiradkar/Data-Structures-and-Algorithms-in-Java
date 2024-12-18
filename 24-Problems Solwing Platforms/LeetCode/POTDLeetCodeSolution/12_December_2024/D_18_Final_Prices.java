import java.util.Stack;
import java.util.Arrays;

public class D_18_Final_Prices {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        int[] prices = {8, 4, 6, 2, 3};

        // Call the function and display the result
        int[] result = solution.finalPrices(prices);
        System.out.println("Final Prices after discount: " + Arrays.toString(result));
    }
}

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] result = prices.clone(); // Clone the prices array for result
        Stack<Integer> stack = new Stack<>(); // Stack to keep track of indices

        for (int i = 0; i < n; i++) {
            // Process stack while the current price is less than or equal to the price at the index stored in the stack
            while (!stack.isEmpty() && prices[i] <= prices[stack.peek()]) {
                int index = stack.pop(); // Get the top index
                result[index] -= prices[i]; // Apply the discount
            }
            stack.push(i); // Push the current index onto the stack
        }

        return result;
    }
}
