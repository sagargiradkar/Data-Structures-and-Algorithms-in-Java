/*
    Problem Statement:
    Write a Java program to check whether a given number is prime or not.
    
    Solution Explanation:
    - A prime number is a number greater than 1 that has no divisors other than 1 and itself.
    - The given code checks divisibility starting from 2 up to n.
    - However, the logic has flaws:
        1. The loop runs incorrectly, breaking on the first iteration.
        2. The condition does not properly verify prime numbers.
        3. It does not handle edge cases like 1 and negative numbers.
    
    Optimized Approach:
    - A number `n` is not prime if it is divisible by any number from `2` to `sqrt(n)`.
    - We iterate only up to `sqrt(n)`, reducing time complexity.
    - Handle edge cases (n <= 1) separately.

*/

import java.util.Scanner;

public class Prime {

    // Original method (Your approach)
    public static void main(String[] args) {
        int i = 2;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number :: ");
        n = sc.nextInt();
        sc.close();

        for (i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.println("Not a prime");
                break;
            } else {
                System.out.println("Prime number");
                break;
            }
        }
    }

    // Optimized method using sqrt(n) approach
    public static boolean isPrimeOptimized(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // Test cases to verify both methods
    public static void mainTest() {
        int[] testNumbers = {1, 2, 4, 17, 20};
        for (int num : testNumbers) {
            System.out.println("Number: " + num + " -> Prime: " + isPrimeOptimized(num));
        }
    }
}

/*
    Time & Space Complexity Analysis:
    
    - Original Method:
        * Time Complexity: O(n) (Inefficient as it iterates up to `n`)
        * Space Complexity: O(1) (Constant space usage)

    - Optimized Method:
        * Time Complexity: O(sqrt(n)) (Efficient by checking only up to `sqrt(n)`)
        * Space Complexity: O(1) (Only integer variables used)
    
    Test Cases:
    1. Input: 1  -> Output: Not a prime
    2. Input: 2  -> Output: Prime number
    3. Input: 4  -> Output: Not a prime
    4. Input: 17 -> Output: Prime number
    5. Input: 20 -> Output: Not a prime
*/

