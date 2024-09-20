import java.util.ArrayList;
import java.util.List;

class LC_01_Spiral_Matrix_I {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int m = matrix.length;
        if (m == 0) return result;
        int n = matrix[0].length;
        
        int startRow = 0;
        int endRow = m - 1;
        int startCol = 0;
        int endCol = n - 1;

        // Spiral traversal
        while (startRow <= endRow && startCol <= endCol) {
            // Traverse right across the top row
            for (int j = startCol; j <= endCol; j++) {
                result.add(matrix[startRow][j]);
            }
            startRow++;

            // Traverse down the right column
            for (int i = startRow; i <= endRow; i++) {
                result.add(matrix[i][endCol]);
            }
            endCol--;

            // Traverse left across the bottom row (only if there are remaining rows)
            if (startRow <= endRow) {
                for (int j = endCol; j >= startCol; j--) {
                    result.add(matrix[endRow][j]);
                }
                endRow--;
            }

            // Traverse up the left column (only if there are remaining columns)
            if (startCol <= endCol) {
                for (int i = endRow; i >= startRow; i--) {
                    result.add(matrix[i][startCol]);
                }
                startCol++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC_01_Spiral_Matrix_I spiralMatrix = new LC_01_Spiral_Matrix_I();
        
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        List<Integer> result = spiralMatrix.spiralOrder(matrix);
        System.out.println("Spiral Order of the matrix is: " + result);
    }
}
