public class D_23_Count_Servers {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 0},
            {0, 1}
        };

        Solution solution = new Solution();
        int result = solution.countServers(grid);

        System.out.println("Number of servers that can communicate: " + result);
    }
}

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Arrays to store counts of servers in each row and column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Count servers in each row and column
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Count servers that can communicate
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                    count++;
                }
            }
        }

        return count;
    }
}
