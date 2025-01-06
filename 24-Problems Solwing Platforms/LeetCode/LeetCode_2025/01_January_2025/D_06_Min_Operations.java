// D_06_Min_Operations.java
import java.util.Arrays;

public class D_06_Min_Operations {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String boxes = "110";
        int[] result = solution.minOperations(boxes);
        System.out.println("Minimum operations to move balls: " + Arrays.toString(result));
    }
}

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int[] answer = new int[n];
        
        // Traverse from left to right
        int balls = 0; // Number of balls seen so far
        int operations = 0; // Total operations for moving balls
        for (int i = 0; i < n; i++) {
            answer[i] = operations; // Add operations calculated so far
            balls += boxes.charAt(i) - '0'; // Update ball count
            operations += balls; // Increment operations for next box
        }
        
        // Traverse from right to left
        balls = 0; // Reset ball count
        operations = 0; // Reset operations
        for (int i = n - 1; i >= 0; i--) {
            answer[i] += operations; // Add operations calculated so far
            balls += boxes.charAt(i) - '0'; // Update ball count
            operations += balls; // Increment operations for previous box
        }
        
        return answer;
    }
}
