import java.util.*;

class Node {
    int data;
    Node right, down;

    Node(int data) {
        this.data = data;
        right = null;
        down = null;
    }
}

public class D_09_Linked_List_Matrix {

    // Non-static display method
    void display(Node head) {
        Node dp = head;
        while (dp != null) {
            Node rp = dp;
            while (rp != null) {
                System.out.print(rp.data + " ");
                rp = rp.right;
            }
            dp = dp.down;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        D_09_Linked_List_Matrix ll2d = new D_09_Linked_List_Matrix(); // Create an instance of the class

        try {
            int t = Integer.parseInt(scanner.nextLine().trim());

            while (t-- > 0) {
                // Read and process the first line of input
                String line = scanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue; // Skip empty lines
                }

                String[] elements = line.split("\\s+");
                int n = elements.length;

                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = Integer.parseInt(elements[i]);
                }

                int[][] mat = new int[n][n];
                mat[0] = arr;

                // Read the remaining rows of the matrix
                for (int i = 1; i < n; i++) {
                    line = scanner.nextLine().trim();
                    elements = line.split("\\s+");
                    for (int j = 0; j < n; j++) {
                        mat[i][j] = Integer.parseInt(elements[j]);
                    }
                }

                Solution obj = new Solution();
                Node head = obj.construct(mat);
                ll2d.display(head); // Call non-static method using instance
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.err.println(
                "Error reading input. Please ensure the input is in the correct format.");
        } finally {
            scanner.close();
        }
    }
}

// User function Template for Java

class Solution {
    static Node construct(int arr[][]) {
        int n = arr.length;
        Node[][] nodeMatrix = new Node[n][n];

        // Create the nodes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nodeMatrix[i][j] = new Node(arr[i][j]);
            }
        }

        // Link the nodes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j + 1 < n) {
                    nodeMatrix[i][j].right = nodeMatrix[i][j + 1];
                }
                if (i + 1 < n) {
                    nodeMatrix[i][j].down = nodeMatrix[i + 1][j];
                }
            }
        }

        // Return the head of the linked list matrix
        return nodeMatrix[0][0];
    }
}
