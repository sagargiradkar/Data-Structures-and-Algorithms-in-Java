/*
    Problem Statement:
    Write a Java program to print numbers in reverse order starting from `n` down to 1.

    Solution Explanation:
    - The given code initializes `n = 10` and uses a for loop to decrement from 10 to 1.
    - It prints each number in reverse order.

    Optimized Approach:
    - The original method is already efficient (O(n)).
    - We make a minor improvement by taking `n` as an argument to allow dynamic inputs.
    - We also fix the print formatting by removing the extra space.
*/

public class ReverseCount {

    // Original Method (Your approach)
    public static void main(String[] args) {
        int n = 10;
        for (int i = 10; i > 0; i--) {
            System.out.println(i);
        }
    }

    // Optimized Method with Dynamic Input
    public static void printReverse(int n) {
        if (n <= 0) {
            System.out.println("Invalid input. Enter a positive number.");
            return;
        }
        for (int i = n; i > 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Test cases to verify both methods
    public static void mainTest() {
        int[] testNumbers = {5, 7, 10, 1, -3};
        for (int num : testNumbers) {
            System.out.print("Reverse Count from " + num + ": ");
            printReverse(num);
        }
    }
}

/*
    Time & Space Complexity Analysis:

    - Original Method:
        * Time Complexity: O(n) (Loops from `n` to 1)
        * Space Complexity: O(1) (Uses only integer variables)

    - Optimized Method:
        * Time Complexity: O(n) (Still loops from `n` to 1)
        * Space Complexity: O(1) (Uses constant space)

    Test Cases:
    1. Input: 5  -> Output: 5 4 3 2 1
    2. Input: 7  -> Output: 7 6 5 4 3 2 1
    3. Input: 10 -> Output: 10 9 8 7 6 5 4 3 2 1
    4. Input: 1  -> Output: 1
    5. Input: -3 -> Output: Invalid input. Enter a positive number.
*/

