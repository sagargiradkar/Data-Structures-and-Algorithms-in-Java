import java.util.*;

public class D_29_Max_Num_Of_Moves {
    
    public int maxMoves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dirs = { {-1, 1}, {0, 1}, {1, 1} };
        Deque<int[]> queue = new ArrayDeque<>();
        int[][] dist = new int[m][n];
        int maxMoves = 0;

        // Add all first-column cells to the queue
        for (int i = 0; i < m; ++i) {
            queue.offer(new int[] {i, 0});
        }

        // BFS traversal across the grid
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            
            for (int[] dir : dirs) {
                int newX = i + dir[0];
                int newY = j + dir[1];
                
                if (newX >= 0 && newX < m && newY < n && grid[newX][newY] > grid[i][j] 
                        && dist[newX][newY] < dist[i][j] + 1) {
                    dist[newX][newY] = dist[i][j] + 1;
                    maxMoves = Math.max(maxMoves, dist[newX][newY]);
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
        return maxMoves;
    }

    public static void main(String[] args) {
        D_29_Max_Num_Of_Moves solution = new D_29_Max_Num_Of_Moves();
        
        int[][] grid = {
            {2, 4, 3, 5},
            {5, 4, 9, 3},
            {3, 4, 2, 11},
            {10, 9, 13, 15}
        };

        int result = solution.maxMoves(grid);
        System.out.println("Maximum Number of Moves: " + result);
    }
}
