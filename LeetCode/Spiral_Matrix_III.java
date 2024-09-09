
public class Spiral_Matrix_III {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        // Directions: Right, Down, Left, Up
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Result array to store coordinates
        int[][] result = new int[rows * cols][2];
        
        // Initialize starting position and direction
        int step = 0;
        int x = rStart;
        int y = cStart;
        int directionIndex = 0; // Start with right direction
        int index = 0;
        
        // Add the starting position
        result[index++] = new int[]{x, y};
        
        // Start walking in spiral
        while (index < rows * cols) {
            if (directionIndex % 2 == 0) step++;  // Increase step size every two direction changes
            
            // Move in the current direction for 'step' times
            for (int i = 0; i < step; i++) {
                x += directions[directionIndex][0];
                y += directions[directionIndex][1];
                
                // If the new position is within the grid boundaries, add it to the result
                if (x >= 0 && x < rows && y >= 0 && y < cols) {
                    result[index++] = new int[]{x, y};
                }
            }
            
            // Change direction (right -> down -> left -> up)
            directionIndex = (directionIndex + 1) % 4;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Spiral_Matrix_III solution = new Spiral_Matrix_III();
        
        // Test Case 1
        int[][] result1 = solution.spiralMatrixIII(1, 4, 0, 0);
        printMatrix(result1);
        
        // Test Case 2
        int[][] result2 = solution.spiralMatrixIII(5, 6, 1, 4);
        printMatrix(result2);
    }
    
    // Helper function to print the matrix of coordinates
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.print("[" + row[0] + "," + row[1] + "] ");
        }
        System.out.println();
    }
}
