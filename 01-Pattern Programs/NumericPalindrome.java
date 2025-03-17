import java.util.Scanner;

public class NumericPalindrome {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print a numeric palindrome pyramid pattern.
     * - Each row contains numbers increasing from 1 up to a middle point, then decreasing.
     * - The pattern is centered with spaces aligning the pyramid.
     *
     * Example for n = 5:
     *     1
     *    121
     *   12321
     *  1234321
     * 123454321
     *
     * Constraints:
     * 1 ≤ n ≤ 100 (Ensuring efficiency)
     *
     * Approach:
     * - Use nested loops:
     *   - Outer loop iterates over rows (0 to n-1).
     *   - First inner loop prints spaces for alignment.
     *   - Second inner loop prints increasing numbers (1 to i+1).
     *   - Third inner loop prints decreasing numbers (i to 1).
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
    public static void printNumericPalindrome(int n) {
        int k = n;
        for (int i = 0; i < n; i++) {
            int c = 1;
            for (int j = 0; j < k; j++) {
                if (j < n - i - 1) {
                    System.out.print(" ");
                } else if (j <= n - 1) {
                    System.out.print(c);
                    c++;
                } else if (j == n) {
                    c = c - 2;
                    System.out.print(c);
                    c--;
                } else {
                    System.out.print(c);
                    c--;
                }
            }
            k++;
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (More Readable & Efficient)
     * ========================================
     * - Uses separate loops for clarity.
     * - Eliminates unnecessary condition checks.
     */
    public static void optimizedNumericPalindrome(int n) {
        for (int i = 1; i <= n; i++) {
            // Print leading spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            // Print increasing numbers
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // Print decreasing numbers
            for (int j = i - 1; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Each row processes up to 'n' elements)
     * - Space Complexity: O(1) (Only loop variables are used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Simplified logic, same complexity)
     * - Space Complexity: O(1) (Loop variables only, no extra storage)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = sc.nextInt();
        sc.close();

        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nNumeric Palindrome Pyramid (n = " + n + "):");
        printNumericPalindrome(n);

        System.out.println("\nOptimized Numeric Palindrome Pyramid (n = " + n + "):");
        optimizedNumericPalindrome(n);

        // Additional test cases
        System.out.println("\nNumeric Palindrome Pyramid (n = 3):");
        optimizedNumericPalindrome(3);

        System.out.println("\nNumeric Palindrome Pyramid (n = 6):");
        optimizedNumericPalindrome(6);

        System.out.println("\nNumeric Palindrome Pyramid (n = 8):");
        optimizedNumericPalindrome(8);
    }
}
