import java.util.*;

public class HalfDiamond {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a half-diamond pattern of height (2n-1) using '*'.
     * - The pattern starts with increasing stars from 1 to n.
     * - Then, it decreases back to 1, forming a half-diamond shape.
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (to maintain efficiency)
     *
     * Approach:
     * - Iterate from 0 to (2n-2).
     * - The number of stars in each row is determined by:
     *   1. If i < n, print (i+1) stars.
     *   2. If i ≥ n, print (n - (i % n) - 1) stars.
     *
     * Time Complexity: O(n²) (Printing n rows with up to n stars)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void halfDiamondPattern(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            int cond = (i < n) ? i : n - (i % n) - 2; // Determine star count
            for (int j = 0; j <= cond; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using Absolute Value)
     * ========================================
     * - Instead of using modulo and subtraction, simplify logic using absolute values.
     */
    public static void optimizedHalfDiamondPattern(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            int stars = n - Math.abs(n - 1 - i); // Absolute function eliminates extra conditions
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Nested loops printing n rows of n elements)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same logic but slightly optimized calculations)
     * - Space Complexity: O(1) (Same as original)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number :: ");
        int n = sc.nextInt();
        sc.close();

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nHalf Diamond Pattern (n = " + n + "):");
        halfDiamondPattern(n);

        System.out.println("\nOptimized Half Diamond Pattern (n = " + n + "):");
        optimizedHalfDiamondPattern(n);
    }
}
