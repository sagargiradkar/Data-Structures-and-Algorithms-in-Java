public class D_26_Find_Champion {
    public static void main(String[] args) {
        // Example input: 4 teams and edges representing matches
        int n = 4;
        int[][] edges = {
            {0, 1}, // Team 0 beats Team 1
            {0, 2}, // Team 0 beats Team 2
            {2, 3}  // Team 2 beats Team 3
        };

        // Creating an instance of the Solution class
        Solution solution = new Solution();

        // Calling the findChampion function
        int result = solution.findChampion(n, edges);

        // Printing the result
        System.out.println("Champion Team: " + result);
    }
}

class Solution {
    public int findChampion(int n, int[][] edges) {
        // Initialize in-degree array for each team
        int[] inDegree = new int[n];
        
        // Process the edges and calculate the in-degree of each team
        for (int[] edge : edges) {
            int from = edge[0]; // from team
            int to = edge[1];   // to team
            inDegree[to]++;     // Increment in-degree of the weaker team
        }
        
        // Find the team with in-degree 0 (potential champion)
        int champion = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (champion != -1) {
                    // If there's more than one team with in-degree 0, return -1
                    return -1;
                }
                champion = i;
            }
        }
        
        return champion;
    }
}
