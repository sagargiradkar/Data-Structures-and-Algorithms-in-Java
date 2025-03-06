/*
    Problem Statement:
    Write a Java program to determine whether three given side lengths can form a valid triangle.

    Triangle Validity Condition:
    - The sum of any two sides must be greater than the third side:
      (a + b > c) && (a + c > b) && (b + c > a)

    Solution Explanation:
    - We take three integer values representing the sides of a triangle.
    - We check if they satisfy the triangle validity condition.
    - If true, we print "Valid Triangle"; otherwise, we print "Invalid Triangle".

    Optimized Approach:
    - The original method is efficient (O(1) time complexity).
    - The optimized version takes user input dynamically and includes input validation.
*/

import java.util.Scanner;

public class ValidTriangle {

    // Original Method (Your approach)
    public static boolean isValidTriangle(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    // Optimized Method (Handles user input and input validation)
    public static void checkTriangle() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter side a: ");
        int a = scanner.nextInt();

        System.out.print("Enter side b: ");
        int b = scanner.nextInt();

        System.out.print("Enter side c: ");
        int c = scanner.nextInt();

        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("Invalid input. Triangle sides must be positive integers.");
        } else if (isValidTriangle(a, b, c)) {
            System.out.println("Valid Triangle");
        } else {
            System.out.println("Invalid Triangle");
        }

        scanner.close();
    }

    // Test cases to verify both methods
    public static void main(String[] args) {
        // Test predefined values
        int a = 10, b = 34, c = 43;
        System.out.println("Test Case (10, 34, 43): " + (isValidTriangle(a, b, c) ? "Valid Triangle" : "Invalid Triangle"));

        // Call optimized method with user input
        checkTriangle();
    }
}

/*
    Time & Space Complexity Analysis:

    - Original Method:
        * Time Complexity: O(1) (Constant-time validation)
        * Space Complexity: O(1) (Uses only a few integer variables)

    - Optimized Method:
        * Time Complexity: O(1) (Same constant-time validation)
        * Space Complexity: O(1) (Uses minimal extra space for input storage)

    Test Cases:
    1. Input: a = 10, b = 34, c = 43  -> Output: Valid Triangle
    2. Input: a = 5, b = 10, c = 3    -> Output: Invalid Triangle
    3. Input: a = 7, b = 24, c = 25   -> Output: Valid Triangle (Pythagorean triple)
    4. Input: a = 0, b = 15, c = 20   -> Output: Invalid input
    5. Input: a = 12, b = 12, c = 12  -> Output: Valid Triangle (Equilateral triangle)
*/

