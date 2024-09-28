public class D_15_Longest_Valid_Parenthesis {

    public static void main(String[] args) {
        String S = "(()))())(";
        Solution solution = new Solution();
        int maxValidLength = solution.maxLength(S);
        System.out.println("The length of the longest valid parentheses substring is: " + maxValidLength);
    }
}

class Solution {
    static int maxLength(String S) {
        int mx = 0, op = 0, cl = 0, mx2 = 0;
        
        // Forward pass
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                op++;
            } else {
                cl++;
            }
            
            if (cl > op) {
                op = 0;
                cl = 0;
            } else if (op == cl) {
                mx = Math.max(mx, op * 2);
            }
        }
        
        // Reset the variables for the backward pass
        op = 0;
        cl = 0;
        
        // Backward pass
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '(') {
                op++;
            } else {
                cl++;
            }
            
            if (op > cl) {
                op = 0;
                cl = 0;
            } else if (op == cl) {
                mx2 = Math.max(mx2, op * 2);
            }
        }
        
        // Return the maximum value from both passes
        return Math.max(mx, mx2);
    }
}
