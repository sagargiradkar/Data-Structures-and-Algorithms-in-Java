public class D_03_SumOfDigitString {

    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test case 1
        String s1 = "iiii";
        int k1 = 1;
        System.out.println("Result for s = \"" + s1 + "\", k = " + k1 + ": " + solution.getLucky(s1, k1));
        // Expected Output: 36
        
        // Test case 2
        String s2 = "leetcode";
        int k2 = 2;
        System.out.println("Result for s = \"" + s2 + "\", k = " + k2 + ": " + solution.getLucky(s2, k2));
        // Expected Output: 6
        
        // Test case 3
        String s3 = "zbax";
        int k3 = 2;
        System.out.println("Result for s = \"" + s3 + "\", k = " + k3 + ": " + solution.getLucky(s3, k3));
        // Expected Output: 8
        
        // Additional Test case
        String s4 = "abc";
        int k4 = 1;
        System.out.println("Result for s = \"" + s4 + "\", k = " + k4 + ": " + solution.getLucky(s4, k4));
        // Expected Output: 6 (1 + 2 + 3 = 6)
    }

    static class Solution {
        public int getLucky(String s, int k) {
            // Initialize an empty string to store the numeric representation of the characters
            StringBuilder num = new StringBuilder();
            
            // Convert each character in the string to its corresponding number (a: 1, b: 2, ..., z: 26)
            for (char ch : s.toCharArray()) {
                int charInt = ch - 'a' + 1;
                num.append(charInt);
            }

            // Initialize sum
            int sum = 0;

            // Repeat the process k times
            while (k-- > 0) {
                sum = 0;
                // Calculate the sum of digits
                for (char ch : num.toString().toCharArray()) {
                    sum += ch - '0';
                }

                // Convert the sum back to a string
                num = new StringBuilder(Integer.toString(sum));
            }

            // Return the final result as an integer
            return Integer.parseInt(num.toString());
        }
    }
}
