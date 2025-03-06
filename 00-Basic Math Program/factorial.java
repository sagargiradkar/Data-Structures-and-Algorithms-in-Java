/*
Problem Statement:
Write a program to compute the factorial of a given number N.

Your Code:
- Uses a while loop to multiply numbers from N down to 1.
- Iteratively reduces N and updates the factorial value.

Optimized Code:
- Uses recursion to calculate the factorial.
- Reduces the number of variable updates and maintains cleaner logic.

Time Complexity Analysis:
- Iterative Method: O(N) (Loop runs N times)
- Recursive Method: O(N) (Recursion depth is N)

Space Complexity:
- Iterative Method: O(1) (Uses only a few variables)
- Recursive Method: O(N) (Recursive call stack depth is N)
*/

public class Factorial {
    public static void main(String[] args) {
        int n = 5;

        // Original Method
        System.out.println("Original Method Output:");
        System.out.println(factorialIterative(n));

        // Optimized Method (Recursive)
        System.out.println("\nOptimized Method Output:");
        System.out.println(factorialRecursive(n));

        // Test Cases
        System.out.println("\nTest Cases:");
        testFactorialMethod();
    }

    // Original Iterative Method
    public static int factorialIterative(int n) {
        int f = 1;
        while (n >= 1) {
            f = f * n;
            n = n - 1;
        }
        return f;
    }

    // Optimized Recursive Method
    public static int factorialRecursive(int n) {
        if (n == 0 || n == 1) return 1;
        return n * factorialRecursive(n - 1);
    }

    // Test Cases
    public static void testFactorialMethod() {
        int[] testCases = {5, 7, 0, 1, 10};

        for (int test : testCases) {
            System.out.println("Factorial of " + test + " → " + factorialRecursive(test));
        }
    }
}
