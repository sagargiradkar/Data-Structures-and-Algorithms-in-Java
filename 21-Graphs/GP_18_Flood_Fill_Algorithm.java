public class GP_18_Flood_Fill_Algorithm {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple 3x3 matrix
        int[][] image1 = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int[][] result1 = solution.floodFill(image1, 1, 1, 2);
        printMatrix(result1);

        // Test Case 2: No change needed (same color)
        int[][] image2 = {
            {0, 0, 0},
            {0, 0, 0}
        };
        int[][] result2 = solution.floodFill(image2, 0, 0, 0);
        printMatrix(result2);

        // Test Case 3: Filling only a specific section
        int[][] image3 = {
            {1, 1, 1},
            {1, 2, 2},
            {1, 2, 0}
        };
        int[][] result3 = solution.floodFill(image3, 1, 1, 3);
        printMatrix(result3);

        // Test Case 4: Large matrix
        int[][] image4 = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 0, 0},
            {0, 0, 0, 0}
        };
        int[][] result4 = solution.floodFill(image4, 1, 1, 2);
        printMatrix(result4);

        // Test Case 5: Edge cell as the starting point
        int[][] image5 = {
            {1, 1, 1},
            {1, 1, 1},
            {0, 0, 1}
        };
        int[][] result5 = solution.floodFill(image5, 2, 2, 9);
        printMatrix(result5);
    }

    // Helper function to print the matrix
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}

class Solution {
    public void helper(int[][] image, int sr, int sc, int color, boolean[][] vis, int orgCol) {
        // Base case: Check bounds, visited status, and original color
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || vis[sr][sc] || image[sr][sc] != orgCol) {
            return;
        }

        // Mark the cell as visited
        vis[sr][sc] = true;

        // Update the cell with the new color
        image[sr][sc] = color;

        // Recursively call for all 4 directions
        helper(image, sr, sc - 1, color, vis, orgCol); // Left
        helper(image, sr, sc + 1, color, vis, orgCol); // Right
        helper(image, sr - 1, sc, color, vis, orgCol); // Up
        helper(image, sr + 1, sc, color, vis, orgCol); // Down
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // If the starting pixel already has the new color, no need to process
        if (image[sr][sc] == color) {
            return image;
        }

        // Initialize the visited array
        boolean[][] vis = new boolean[image.length][image[0].length];

        // Start the flood fill process
        helper(image, sr, sc, color, vis, image[sr][sc]);

        return image;
    }
}
