import java.util.Scanner;

public class LC_05_Largest_Local_Value {

    // Solution class as given
    static class Solution {
        public int findMax(int[][] grid , int startRow, int startCol){
            int maxVal = Integer.MIN_VALUE;
            for(int i = startRow; i < startRow + 3; i++){
                for(int j = startCol; j < startCol + 3; j++){
                    maxVal = Math.max(maxVal, grid[i][j]);
                }
            }
            return maxVal;
        }

        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;
            int res[][] = new int[n - 2][n - 2];

            for(int i = 0; i < n - 2; i++){
                for(int j = 0; j < n - 2; j++){
                    res[i][j] = findMax(grid, i, j);
                }
            }
            return res;
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the grid (n x n): ");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        
        System.out.println("Enter the grid elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        Solution sol = new Solution();
        int[][] result = sol.largestLocal(grid);

        System.out.println("Largest local values in 3x3 grid:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
