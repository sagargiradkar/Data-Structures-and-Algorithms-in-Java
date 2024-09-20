class LC_02_Spiral_Matrix_II {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int startRow = 0;
        int endRow = n - 1;
        int startCol = 0;
        int endCol = n - 1;
        int val = 1;

        // Spiral traversal
        while (startRow <= endRow && startCol <= endCol) {
            // Traverse right across the top row
            for (int j = startCol; j <= endCol; j++) {
                matrix[startRow][j] = val;
                val++;
            }
            startRow++;

            // Traverse down the right column
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][endCol] = val;
                val++;
            }
            endCol--;

            // Traverse left across the bottom row (only if there are remaining rows)
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    matrix[endRow][j] = val;
                    val++;
                }
                endRow--;
            }

            // Traverse up the left column (only if there are remaining columns)
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    matrix[i][startCol] = val;
                    val++;
                }
                startCol++;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        LC_02_Spiral_Matrix_II spiralMatrix = new LC_02_Spiral_Matrix_II();
        
        int n = 3; // You can change the value of n to generate different sized matrices
        int[][] result = spiralMatrix.generateMatrix(n);
        
        System.out.println("Generated Spiral Matrix:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
