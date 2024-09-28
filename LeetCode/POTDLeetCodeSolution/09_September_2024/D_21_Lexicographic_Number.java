import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        // Start the DFS from 1 to 9 (the first digits of potential numbers)
        for (int i = 1; i <= 9; i++) {
            if (i > n) break; // Only process numbers <= n
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int curNum, int target, List<Integer> res) {
        // If the current number exceeds the target, return
        if (curNum > target) {
            return;
        }
        // Add the current number to the result list
        res.add(curNum);
        // Try appending digits 0-9 to the current number
        for (int d = 0; d < 10; d++) {
            // Calculate the next number
            int nextNum = curNum * 10 + d;
            // If the next number exceeds the target, break
            if (nextNum > target) {
                break;
            }
            // Continue the DFS with the next number
            dfs(nextNum, target, res);
        }
    }
}

public class D_21_Lexicographic_Number {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 13; // You can change this value to test with different inputs
        List<Integer> result = solution.lexicalOrder(n);
        
        // Print the result
        System.out.println("Lexicographic order up to " + n + ": " + result);
    }
}
