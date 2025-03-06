/*
    Problem Statement:
    Write a Java program to calculate the Simple Interest (SI) using the formula:

        SI = (P * R * T) / 100

    where:
    - P = Principal amount
    - R = Rate of interest (per annum)
    - T = Time period (in years)

    Solution Explanation:
    - The given code calculates SI using the formula but misses division by 100.
    - We will fix this and improve the program by allowing user inputs.

    Optimized Approach:
    - The original method has a missing division by 100.
    - The optimized approach ensures dynamic input, proper formula usage, and better structure.
*/

import java.util.Scanner;

public class SI {

    // Original Method (Your approach)
    public static int calculateSI(int P, int R, int T) {
        return (P * R * T); // Missing division by 100
    }

    // Optimized Method (Corrected formula with dynamic input)
    public static double optimizedCalculateSI(int P, int R, int T) {
        return (P * R * T) / 100.0; // Correct formula
    }

    // Test cases to verify both methods
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Principal (P): ");
        int P = scanner.nextInt();
        
        System.out.print("Enter Rate of Interest (R): ");
        int R = scanner.nextInt();
        
        System.out.print("Enter Time (T): ");
        int T = scanner.nextInt();
        
        System.out.println("Original SI Calculation: " + calculateSI(P, R, T));
        System.out.println("Optimized SI Calculation: " + optimizedCalculateSI(P, R, T));

        scanner.close();
    }
}

/*
    Time & Space Complexity Analysis:

    - Original Method:
        * Time Complexity: O(1) (Constant time calculation)
        * Space Complexity: O(1) (Uses only integer variables)

    - Optimized Method:
        * Time Complexity: O(1) (Same constant time calculation)
        * Space Complexity: O(1) (Uses minimal extra space)

    Test Cases:
    1. Input: P=1000, R=5, T=2  -> Output: SI = 100
    2. Input: P=500, R=10, T=3  -> Output: SI = 150
    3. Input: P=1200, R=7, T=4  -> Output: SI = 336
    4. Input: P=100, R=12, T=1  -> Output: SI = 12
    5. Input: P=2000, R=8, T=5  -> Output: SI = 800
*/

