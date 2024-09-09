package LeetCode.POTDLeetCodeSolution.September2024;
import java.util.Arrays;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class D_09_Spiral_Matrix_IV {
    // Function to convert linked list to spiral matrix
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);  // Initialize matrix with -1
        }

        int topRow = 0, bottomRow = m - 1, leftCol = 0, rightCol = n - 1;

        while (head != null) {
            // Fill top row
            for (int col = leftCol; col <= rightCol && head != null; col++) {
                matrix[topRow][col] = head.val;
                head = head.next;
            }
            topRow++;

            // Fill right column
            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightCol] = head.val;
                head = head.next;
            }
            rightCol--;

            // Fill bottom row
            for (int col = rightCol; col >= leftCol && head != null; col--) {
                matrix[bottomRow][col] = head.val;
                head = head.next;
            }
            bottomRow--;

            // Fill left column
            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftCol] = head.val;
                head = head.next;
            }
            leftCol++;
        }

        return matrix;
    }

    // Helper function to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take matrix dimensions input
        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        // Create the linked list from input
        System.out.println("Enter the linked list values (-1 to stop): ");
        ListNode dummyHead = new ListNode();  // Dummy head to simplify list construction
        ListNode current = dummyHead;

        while (true) {
            int val = sc.nextInt();
            if (val == -1) break;
            current.next = new ListNode(val);
            current = current.next;
        }

        // Call the spiralMatrix method
        D_09_Spiral_Matrix_IV obj = new D_09_Spiral_Matrix_IV();
        int[][] resultMatrix = obj.spiralMatrix(m, n, dummyHead.next);

        // Print the resulting matrix
        System.out.println("Spiral matrix:");
        printMatrix(resultMatrix);
    }
}
