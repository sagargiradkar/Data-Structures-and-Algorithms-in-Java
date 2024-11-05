public class D_05_Min_Change {
    public static void main(String[] args) {
        // Sample input
        String s = "010101";
        
        // Creating an instance of Solution
        Solution solution = new Solution();
        
        // Getting the minimum number of changes required
        int result = solution.minChanges(s);
        
        // Displaying the result
        System.out.println("Minimum number of changes required: " + result);
    }
}

class Solution {
    public int minChanges(String s) {
        int changes = 0;
        int n = s.length();

        for (int i = 0; i < n - 1; i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }

        return changes;
    }
}
