public class D_01_1DTo2DArray {
    
    // Method to convert 1D array to 2D array
    public int[][] construct2DArray(int[] original, int m, int n) {
        // Check if the total number of elements matches m * n
        if (original.length != m * n) {
            return new int[0][0]; // return an empty 2D array
        }
        
        // Initialize the 2D array
        int[][] result = new int[m][n];
        
        // Populate the 2D array
        for (int i = 0; i < original.length; i++) {
            int row = i / n;       // Determine the current row
            int col = i % n;       // Determine the current column
            result[row][col] = original[i];
        }
        
        return result;
    }
    
    // Main method to test the construct2DArray method
    public static void main(String[] args) {
        D_01_1DTo2DArray solution = new D_01_1DTo2DArray();
        
        // Test Case 1
        int[] original1 = {1, 2, 3, 4};
        int m1 = 2, n1 = 2;
        int[][] result1 = solution.construct2DArray(original1, m1, n1);
        System.out.println("Test Case 1:");
        print2DArray(result1);
        
        // Test Case 2
        int[] original2 = {1, 2, 3};
        int m2 = 1, n2 = 3;
        int[][] result2 = solution.construct2DArray(original2, m2, n2);
        System.out.println("Test Case 2:");
        print2DArray(result2);
        
        // Test Case 3
        int[] original3 = {1, 2};
        int m3 = 1, n3 = 1;
        int[][] result3 = solution.construct2DArray(original3, m3, n3);
        System.out.println("Test Case 3:");
        print2DArray(result3);
        
        // Test Case 4 (Edge Case)
        int[] original4 = {1, 2, 3, 4, 5};
        int m4 = 2, n4 = 3;
        int[][] result4 = solution.construct2DArray(original4, m4, n4);
        System.out.println("Test Case 4:");
        print2DArray(result4);
    }
    
    // Helper method to print 2D array
    public static void print2DArray(int[][] array) {
        if (array.length == 0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print("[");
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
                if (j < array[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
