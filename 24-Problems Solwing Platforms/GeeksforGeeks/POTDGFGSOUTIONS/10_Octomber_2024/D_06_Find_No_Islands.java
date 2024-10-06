import java.util.*;

public class D_06_Find_No_Islands {

    private int n, m;
    private final int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
            { -1, 1 } };

    // Recursive function to mark the current island and its connected parts
    private void solve(char[][] grid, int i, int j) {
        // Base case: if out of bounds or water, return
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] == '0')
            return;

        // Mark the current land as visited by setting it to '0'
        grid[i][j] = '0';

        // Visit all 8 possible directions
        for (int[] dir : directions) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            solve(grid, newI, newJ);
        }
    }

    // Function to count the number of islands
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;

        // Traverse the grid to find the starting point of each island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    solve(grid, i, j);
                    count++; // Increment the island count
                }
            }
        }
        return count;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the grid dimensions
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();

        System.out.println("Enter the number of columns:");
        int cols = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        // Input the grid
        char[][] grid = new char[rows][cols];
        System.out.println("Enter the grid row by row (1 for land, 0 for water):");
        for (int i = 0; i < rows; i++) {
            String line = sc.nextLine();
            grid[i] = line.toCharArray();
        }

        // Create an instance of the solution class
        D_06_Find_No_Islands solution = new D_06_Find_No_Islands();

        // Find and print the number of islands
        int result = solution.numIslands(grid);
        System.out.println("Number of islands: " + result);

        sc.close();
    }
}
