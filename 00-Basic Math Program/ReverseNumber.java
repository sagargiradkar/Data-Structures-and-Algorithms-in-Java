/*
    Problem Statement:
    Write a Java program to reverse an integer number.

    Solution Explanation:
    - The given code extracts digits from the given number using modulo (`%`) and appends them in reverse order.
    - It does this by repeatedly taking the last digit, adding it to the result after shifting, and then reducing the number.
    - The process continues until the number becomes zero.

    Optimized Approach:
    - The original method is already efficient (O(log N)).
    - The optimized approach ensures handling of negative numbers and prevents integer overflow.
*/

import java.util.*;

public class ReverseNumber {

    // Original Method (Your approach)
    public static int reverseNumber(int num) {
        int ans = 0;
        while (num != 0) {
            int digit = num % 10;
            ans = ans * 10 + digit;
            num = num / 10;
        }
        return ans;
    }

    // Optimized Method with Negative Number Handling and Overflow Check
    public static int optimizedReverseNumber(int num) {
        boolean isNegative = num < 0;
        num = Math.abs(num); // Convert to positive

        int ans = 0;
        while (num != 0) {
            int digit = num % 10;

            // Prevent integer overflow
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                return 0; // Return 0 in case of overflow
            }

            ans = ans * 10 + digit;
            num = num / 10;
        }

        return isNegative ? -ans : ans;
    }

    // Test cases to verify both methods
    public static void main(String[] args) {
        int[] testNumbers = {12345, 9876, 1001, -123, 0};

        for (int num : testNumbers) {
            System.out.println("Original Reverse of " + num + ": " + reverseNumber(num));
            System.out.println("Optimized Reverse of " + num + ": " + optimizedReverseNumber(num));
        }
    }
}

/*
    Time & Space Complexity Analysis:

    - Original Method:
        * Time Complexity: O(log N) (Number of digits in N is approximately log10(N))
        * Space Complexity: O(1) (Uses constant extra space)

    - Optimized Method:
        * Time Complexity: O(log N) (Same digit extraction process)
        * Space Complexity: O(1) (Uses a few integer variables)

    Test Cases:
    1. Input: 12345 -> Output: 54321
    2. Input: 9876  -> Output: 6789
    3. Input: 1001  -> Output: 1001
    4. Input: -123  -> Output: -321
    5. Input: 0     -> Output: 0
*/
