// D_15_Minimize_XOR.java
public class D_15_Minimize_XOR {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        int num1_1 = 3, num2_1 = 5;
        System.out.println(solution.minimizeXor(num1_1, num2_1)); // Expected: 3

        int num1_2 = 28, num2_2 = 7;
        System.out.println(solution.minimizeXor(num1_2, num2_2)); // Expected: 26

        int num1_3 = 1, num2_3 = 12;
        System.out.println(solution.minimizeXor(num1_3, num2_3)); // Expected: 15

        int num1_4 = 0, num2_4 = 8;
        System.out.println(solution.minimizeXor(num1_4, num2_4)); // Expected: 15
    }
}

class Solution {
    public int minimizeXor(int num1, int num2) {
        int targetBits = Integer.bitCount(num2); // Count of 1s in num2
        int result = 0;
        
        // Step 1: Use bits of num1 to construct result
        for (int i = 31; i >= 0 && targetBits > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // If bit i in num1 is set
                result |= (1 << i); // Set bit i in result
                targetBits--;
            }
        }
        
        // Step 2: If more bits need to be set, set the lowest available bits
        for (int i = 0; i <= 31 && targetBits > 0; i++) {
            if ((result & (1 << i)) == 0) { // If bit i in result is not set
                result |= (1 << i); // Set bit i in result
                targetBits--;
            }
        }
        
        return result;
    }
}
