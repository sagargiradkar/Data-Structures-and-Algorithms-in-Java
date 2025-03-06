/*
Problem Statement:
Write a program to print all even numbers from 0 to N (exclusive). 

Your Code:
- Uses a loop from 0 to N and checks each number if it's even using (i % 2 == 0).
- If even, it prints the number.

Optimized Code:
- Instead of checking every number, iterate with a step of 2, directly printing only even numbers.

Time Complexity Analysis:
- Your Code: O(N) (Iterates through all numbers and checks condition)
- Optimized Code: O(N/2) = O(N) (Iterates only over even numbers, reducing iterations by half)

Space Complexity:
- Both approaches use O(1) space.
*/

public class EvenNumber {
    public static void main(String[] args) {
        int n = 10;

        // Original Method
        System.out.println("Original Method Output:");
        printEvenNumbers(n);

        // Optimized Method
        System.out.println("\nOptimized Method Output:");
        printEvenNumbersOptimized(n);

        // Test Cases
        System.out.println("\nTest Cases:");
        testEvenNumberMethod();
    }

    // Original Method
    public static void printEvenNumbers(int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    // Optimized Method
    public static void printEvenNumbersOptimized(int n) {
        for (int i = 0; i < n; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Test Cases
    public static void testEvenNumberMethod() {
        int[] testCases = {10, 15, 8, 1, 20};

        for (int test : testCases) {
            System.out.print("N = " + test + " → ");
            printEvenNumbersOptimized(test);
        }
    }
}
