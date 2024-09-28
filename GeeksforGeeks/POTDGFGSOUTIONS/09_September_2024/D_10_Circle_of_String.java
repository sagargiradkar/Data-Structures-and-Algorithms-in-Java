import java.util.*;

public class D_10_Circle_of_String {
    
    // Function to check if the given strings can form a circle
    public int isCircle(String arr[]) {
        int n = arr.length;
        
        // There are 26 possible characters (a-z), so we use 26 size arrays.
        int[] inDegree = new int[26];
        int[] outDegree = new int[26];
        
        // Adjacency list for each character (0 represents 'a', 25 represents 'z')
        List<Integer>[] graph = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Build the graph based on the strings
        for (String str : arr) {
            int firstChar = str.charAt(0) - 'a'; // First character of the string
            int lastChar = str.charAt(str.length() - 1) - 'a'; // Last character of the string
            
            // Add edge from firstChar to lastChar
            graph[firstChar].add(lastChar);
            
            // Increment the in-degree and out-degree
            outDegree[firstChar]++;
            inDegree[lastChar]++;
        }
        
        // 1. Check if in-degree and out-degree of every character is equal
        for (int i = 0; i < 26; i++) {
            if (inDegree[i] != outDegree[i]) {
                return 0; // Not possible to form a circle if in-degree and out-degree are not equal
            }
        }
        
        // 2. Check if the graph is strongly connected
        // Find the first character that has any outgoing edge to start DFS
        int startChar = -1;
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0) {
                startChar = i;
                break;
            }
        }
        
        if (startChar == -1) {
            return 0; // No strings in the input
        }
        
        // Perform DFS to check if all vertices in the graph can be visited
        if (!isStronglyConnected(graph, startChar, outDegree)) {
            return 0; // Graph is not strongly connected
        }
        
        // If all conditions are satisfied, the strings can form a circle
        return 1;
    }
    
    // Helper function to check if the graph is strongly connected
    private boolean isStronglyConnected(List<Integer>[] graph, int start, int[] outDegree) {
        // Perform DFS from the start node
        boolean[] visited = new boolean[26];
        dfs(graph, start, visited);
        
        // Check if all characters that have outgoing edges are visited
        for (int i = 0; i < 26; i++) {
            if (outDegree[i] > 0 && !visited[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    // Standard DFS function
    private void dfs(List<Integer>[] graph, int node, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : graph[node]) {
            if (!visited[neighbor]) {
                dfs(graph, neighbor, visited);
            }
        }
    }
    
    // Main method for testing
    public static void main(String[] args) {
        D_10_Circle_of_String solution = new D_10_Circle_of_String();
        
        // Test Case 1: Should output 1 (circle can be formed)
        String[] arr1 = {"ab", "bc", "cd", "da"};
        System.out.println(solution.isCircle(arr1));  // Output: 1
        
        // Test Case 2: Should output 0 (circle cannot be formed)
        String[] arr2 = {"abc", "bcd", "cdf"};
        System.out.println(solution.isCircle(arr2));  // Output: 0
    }
}
