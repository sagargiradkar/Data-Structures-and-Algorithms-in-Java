import java.util.*;

public class PascalTriangle {

    /*
     * ========================================
     * 1. Problem Statement & Solution Explanation
     * ========================================
     * Problem Statement:
     * Given an integer 'n', print the first 'n' rows of **Pascal's Triangle**.
     * - Pascal’s Triangle is a triangular array of binomial coefficients.
     * - Each number in a row is the sum of the two numbers above it.
     * - The first and last elements of each row are always 1.
     *
     * Example for n = 5:
     *       1
     *      1 1
     *     1 2 1
     *    1 3 3 1
     *   1 4 6 4 1
     *
     * Approach:
     * - Use a nested loop:
     *   - Outer loop iterates over rows.
     *   - Inner loop calculates binomial coefficients using the formula:
     *     c = c * (i - j) / j
     *   - Print values row-wise.
     *
     * Time Complexity: O(n²) (Each row processes multiple values)
     * Space Complexity: O(1) (Only loop variables are used)
     */

    /*
     * ========================================
     * 2. Original Code (Unmodified, with your method)
     * ========================================
     */
    public static void generatePascalTriangle(int n) {
        for (int i = 0; i < n; i++) {
            int c = 1;
            // Print spaces for pyramid-like structure
            for (int space = 0; space < n - i; space++) {
                System.out.print(" ");
            }
            // Calculate binomial coefficients
            for (int j = 0; j <= i; j++) {
                System.out.print(c + " ");
                c = c * (i - j) / (j + 1);
            }
            System.out.println();
        }
    }

    /*
     * ========================================
     * 3. Optimized Code (Using ArrayList)
     * ========================================
     * - Uses **ArrayList** to store the previous row and calculate the current row.
     * - Reduces redundant calculations.
     * - Improves readability.
     */
    public static void optimizedPascalTriangle(int n) {
        List<Integer> prevRow = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> currRow = new ArrayList<>();
            // Print spaces for alignment
            for (int space = 0; space < n - i; space++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currRow.add(1);
                } else {
                    currRow.add(prevRow.get(j - 1) + prevRow.get(j));
                }
                System.out.print(currRow.get(j) + " ");
            }
            prevRow = currRow;
            System.out.println();
        }
    }

    /*
     * ========================================
     * 4. Time & Space Complexity Analysis
     * ========================================
     * Original Method:
     * - Time Complexity: O(n²) (Each element is computed once per row)
     * - Space Complexity: O(1) (No extra data structures used)
     *
     * Optimized Method:
     * - Time Complexity: O(n²) (Each row is processed iteratively)
     * - Space Complexity: O(n) (Uses an ArrayList for row storage)
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows for Pascal's Triangle: ");
        int n = sc.nextInt();
        
        /*
         * ========================================
         * 5. Test Cases
         * ========================================
         */
        System.out.println("\nTest Case 1: n = 5");
        generatePascalTriangle(5);

        System.out.println("\nTest Case 2: Optimized n = 5");
        optimizedPascalTriangle(5);

        System.out.println("\nTest Case 3: n = 3");
        optimizedPascalTriangle(3);

        System.out.println("\nTest Case 4: n = 6");
        optimizedPascalTriangle(6);

        System.out.println("\nTest Case 5: n = 8");
        optimizedPascalTriangle(8);
    }
}
