class Solution {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a **palindromic number pyramid** pattern.
     * - Each row consists of numbers decreasing from 'i' to 1, followed by increasing from 2 to 'i'.
     * - Spaces align the numbers to form a pyramid structure.
     *
     * Example for n = 6:
     *           1
     *         2 1 2
     *       3 2 1 2 3
     *     4 3 2 1 2 3 4
     *   5 4 3 2 1 2 3 4 5
     * 6 5 4 3 2 1 2 3 4 5 6
     *
     * Constraints:
     * 1 ≤ n ≤ 100
     *
     * Approach:
     * - Use nested loops:
     *   - Outer loop iterates over rows (1 to n).
     *   - First inner loop prints spaces for left alignment.
     *   - Second loop prints descending numbers (i to 1).
     *   - Third loop prints ascending numbers (2 to i).
     * - Move to the next line after printing all numbers in a row.
     *
     * Time Complexity: O(n²) (Each cell is processed once)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public void pallindromicNumber(int n) {
        System.out.println("Palindromic Number Pattern");
        // Outer loop for rows
        for (int i = 1; i <= n; i++) {
            // Print spaces for left alignment
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // Print descending numbers from 'i' to 1
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            // Print ascending numbers from 2 to 'i'
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(); // Move to the next line
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (More Readable & Efficient)
     * ========================================
     * - Uses a StringBuilder to construct the row before printing (reduces I/O operations).
     * - Eliminates redundant space prints by computing them beforehand.
     */
    public void optimizedPallindromicNumber(int n) {
        System.out.println("Optimized Palindromic Number Pattern");
        for (int i = 1; i <= n; i++) {
            StringBuilder row = new StringBuilder();
            // Print spaces
            row.append("  ".repeat(n - i));

            // Print descending numbers
            for (int j = i; j >= 1; j--) {
                row.append(j).append(" ");
            }
            // Print ascending numbers
            for (int j = 2; j <= i; j++) {
                row.append(j).append(" ");
            }
            System.out.println(row);
        }
    }
}

public class Pallindromic_Pattern_Num {

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Each row prints at most 2n elements)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Same as the original, but optimized for efficiency)
     * - Space Complexity: O(n) (Uses a StringBuilder per row, reducing I/O cost)
     */

    public static void main(String[] args) {
        Solution obj = new Solution();

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nTest Case 1: n = 6");
        obj.pallindromicNumber(6);

        System.out.println("\nTest Case 2: Optimized n = 6");
        obj.optimizedPallindromicNumber(6);

        System.out.println("\nTest Case 3: n = 3");
        obj.optimizedPallindromicNumber(3);

        System.out.println("\nTest Case 4: n = 5");
        obj.optimizedPallindromicNumber(5);

        System.out.println("\nTest Case 5: n = 8");
        obj.optimizedPallindromicNumber(8);
    }
}
