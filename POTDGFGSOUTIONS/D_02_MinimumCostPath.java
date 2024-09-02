import java.util.*;

public class D_02_MinimumCostPath {
    
    // Direction vectors for moving in the grid
    private static final int[] dRow = { -1, 0, 1, 0 };
    private static final int[] dCol = { 0, 1, 0, -1 };

    // Function to return the minimum cost to reach the bottom-right cell from top-left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;

        // PriorityQueue to implement the min-heap, storing {cost, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // To store the minimum cost to reach each cell
        int[][] minCost = new int[n][n];

        // Initializing the minCost array with a large value (infinity)
        for (int[] row : minCost)
            Arrays.fill(row, Integer.MAX_VALUE);

        // Start from the top-left corner
        pq.offer(new int[]{grid[0][0], 0, 0});
        minCost[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentCost = current[0];
            int row = current[1];
            int col = current[2];

            // If we reached the bottom-right corner, return the cost
            if (row == n - 1 && col == n - 1) {
                return currentCost;
            }

            // Explore the four neighboring cells
            for (int i = 0; i < 4; i++) {
                int newRow = row + dRow[i];
                int newCol = col + dCol[i];

                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                    int newCost = currentCost + grid[newRow][newCol];

                    // If the new cost is cheaper, update and push to the priority queue
                    if (newCost < minCost[newRow][newCol]) {
                        minCost[newRow][newCol] = newCost;
                        pq.offer(new int[]{newCost, newRow, newCol});
                    }
                }
            }
        }

        // If no path found, return -1 (though in this problem, there's always a path)
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < n; j++) {
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            D_02_MinimumCostPath obj = new D_02_MinimumCostPath();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}