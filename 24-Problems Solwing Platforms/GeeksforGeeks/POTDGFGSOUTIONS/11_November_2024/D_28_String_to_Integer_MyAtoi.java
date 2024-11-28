
public class D_28_String_to_Integer_MyAtoi {

    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();

        // Test cases
        String test1 = "42";
        String test2 = "   -42";
        String test3 = "4193 with words";
        String test4 = "words and 987";
        String test5 = "-91283472332"; // Should return Integer.MIN_VALUE
        String test6 = "91283472332";  // Should return Integer.MAX_VALUE
        String test7 = "+123";

        // Print results
        System.out.println("Input: \"" + test1 + "\" -> Output: " + solution.myAtoi(test1));
        System.out.println("Input: \"" + test2 + "\" -> Output: " + solution.myAtoi(test2));
        System.out.println("Input: \"" + test3 + "\" -> Output: " + solution.myAtoi(test3));
        System.out.println("Input: \"" + test4 + "\" -> Output: " + solution.myAtoi(test4));
        System.out.println("Input: \"" + test5 + "\" -> Output: " + solution.myAtoi(test5));
        System.out.println("Input: \"" + test6 + "\" -> Output: " + solution.myAtoi(test6));
        System.out.println("Input: \"" + test7 + "\" -> Output: " + solution.myAtoi(test7));
    }
}

class Solution {

    public int myAtoi(String s) {
        // Initialize variables
        int index = 0, n = s.length();
        int sign = 1; // Default sign is positive
        int result = 0;

        // Skip leading whitespaces
        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        // Check for sign
        if (index < n && (s.charAt(index) == '+' || s.charAt(index) == '-')) {
            sign = (s.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Process digits and ignore non-digit characters
        while (index < n && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }
}
