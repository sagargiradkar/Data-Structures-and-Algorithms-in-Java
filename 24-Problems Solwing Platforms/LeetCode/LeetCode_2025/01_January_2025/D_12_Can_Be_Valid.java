// D_12_Can_Be_Valid.java
public class D_12_Can_Be_Valid {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();

        // Test cases
        String s1 = "(()))";
        String locked1 = "11000";
        System.out.println("Can s1 be valid? " + solution.canBeValid(s1, locked1)); // Expected: true

        String s2 = "()()";
        String locked2 = "1111";
        System.out.println("Can s2 be valid? " + solution.canBeValid(s2, locked2)); // Expected: true

        String s3 = "())(";
        String locked3 = "1111";
        System.out.println("Can s3 be valid? " + solution.canBeValid(s3, locked3)); // Expected: false

        String s4 = "()";
        String locked4 = "00";
        System.out.println("Can s4 be valid? " + solution.canBeValid(s4, locked4)); // Expected: true
    }
}

class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();
        
        // If the length of the string is odd, it cannot be valid
        if (n % 2 != 0) return false;
        
        // Left-to-right scan
        int open = 0; // Tracks open '(' balance
        int flexible = 0; // Tracks flexible positions
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                flexible++; // Treat flexible positions as potentially '('
            } else if (s.charAt(i) == '(') {
                open++;
            } else { // s.charAt(i) == ')' and locked[i] == '1'
                if (open > 0) {
                    open--; // Match ')' with '('
                } else if (flexible > 0) {
                    flexible--; // Use flexible to balance ')'
                } else {
                    return false; // Unmatched ')'
                }
            }
        }
        
        // Right-to-left scan
        int close = 0; // Tracks close ')' balance
        flexible = 0; // Reset flexible counter
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                flexible++; // Treat flexible positions as potentially ')'
            } else if (s.charAt(i) == ')') {
                close++;
            } else { // s.charAt(i) == '(' and locked[i] == '1'
                if (close > 0) {
                    close--; // Match '(' with ')'
                } else if (flexible > 0) {
                    flexible--; // Use flexible to balance '('
                } else {
                    return false; // Unmatched '('
                }
            }
        }
        
        return true;
    }
}
