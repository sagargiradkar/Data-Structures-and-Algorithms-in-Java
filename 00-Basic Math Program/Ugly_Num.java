/*
Problem Statement:
Write a program to determine whether a given number N is an "ugly number."
A number is considered ugly if it is a positive number whose prime factors are limited to 2, 3, and 5.

Your Code:
- Uses a loop to continuously divide N by 2, 3, or 5 if divisible.
- Returns false if N has any prime factor other than 2, 3, or 5.

Optimized Code:
- The same logic but ensures early termination for invalid cases (negative or zero input).
- Uses a cleaner and more structured approach.

Time Complexity Analysis:
- Both methods run in O(log N) time, as we repeatedly divide N by 2, 3, or 5.
- Space Complexity: O(1), as only a few variables are used.
*/

public class Ugly_Num {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example input
        int n = 30;
        System.out.println("Is " + n + " an ugly number? " + solution.isUgly(n));

        // Running test cases
        System.out.println("\nTest Cases:");
        testUglyNumberMethod();
    }

    // Original Method
    static class Solution {
        public boolean isUgly(int n) {
            if (n <= 0) return false; // Ugly numbers must be positive
            
            while (n % 2 == 0) n /= 2;
            while (n % 3 == 0) n /= 3;
            while (n % 5 == 0) n /= 5;

            return n == 1;
        }
    }

    // Optimized Method
    static class OptimizedSolution {
        public boolean isUglyOptimized(int n) {
            if (n <= 0) return false;

            for (int factor : new int[]{2, 3, 5}) {
                while (n % factor == 0) {
                    n /= factor;
                }
            }

            return n == 1;
        }
    }

    // Test Cases
    public static void testUglyNumberMethod() {
        OptimizedSolution solution = new OptimizedSolution();
        int[] testCases = {6, 8, 14, 1, 30}; // Expected: true, true, false, true, true

        for (int test : testCases) {
            System.out.println("Is " + test + " an ugly number? " + solution.isUglyOptimized(test));
        }
    }
}
