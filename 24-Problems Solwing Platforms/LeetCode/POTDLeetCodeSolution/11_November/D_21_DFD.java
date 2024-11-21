import java.util.Scanner;

public class D_21_DFD {
    private void dfs(int[][] grid, int row, int col, int rows, int cols, int direction) {
        // Boundary check and skipping guarded or walled cells
        if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] == 1 || grid[row][col] == 2) {
            return;
        }

        // Mark the current cell as visited by a guard's line of sight
        grid[row][col] = 3;

        // Continue the DFS in the specified direction
        if (direction == 1) { // UP
            dfs(grid, row - 1, col, rows, cols, direction);
        } else if (direction == 2) { // DOWN
            dfs(grid, row + 1, col, rows, cols, direction);
        } else if (direction == 3) { // LEFT
            dfs(grid, row, col - 1, rows, cols, direction);
        } else { // RIGHT
            dfs(grid, row, col + 1, rows, cols, direction);
        }
    }

    public int countUnguarded(int rows, int cols, int[][] guards, int[][] walls) {
        // Initialize the grid
        int[][] grid = new int[rows][cols];

        // Mark guard positions
        for (int[] guard : guards) {
            int i = guard[0];
            int j = guard[1];
            grid[i][j] = 1; // Guard cell
        }

        // Mark wall positions
        for (int[] wall : walls) {
            int i = wall[0];
            int j = wall[1];
            grid[i][j] = 2; // Wall cell
        }

        // Perform DFS for each guard in all four directions (UP, DOWN, LEFT, RIGHT)
        for (int[] guard : guards) {
            int guardRow = guard[0];
            int guardCol = guard[1];

            dfs(grid, guardRow - 1, guardCol, rows, cols, 1); // UP
            dfs(grid, guardRow + 1, guardCol, rows, cols, 2); // DOWN
            dfs(grid, guardRow, guardCol - 1, rows, cols, 3); // LEFT
            dfs(grid, guardRow, guardCol + 1, rows, cols, 4); // RIGHT
        }

        // Count unguarded cells
        int unguardedCount = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 0) {
                    unguardedCount++;
                }
            }
        }

        return unguardedCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of rows and columns:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        System.out.println("Enter number of guards:");
        int numGuards = scanner.nextInt();
        int[][] guards = new int[numGuards][2];
        System.out.println("Enter guard positions (row and column):");
        for (int i = 0; i < numGuards; i++) {
            guards[i][0] = scanner.nextInt();
            guards[i][1] = scanner.nextInt();
        }

        System.out.println("Enter number of walls:");
        int numWalls = scanner.nextInt();
        int[][] walls = new int[numWalls][2];
        System.out.println("Enter wall positions (row and column):");
        for (int i = 0; i < numWalls; i++) {
            walls[i][0] = scanner.nextInt();
            walls[i][1] = scanner.nextInt();
        }

        D_21_DFD solution = new D_21_DFD();
        int result = solution.countUnguarded(rows, cols, guards, walls);
        System.out.println("Number of unguarded cells: " + result);
    }
}