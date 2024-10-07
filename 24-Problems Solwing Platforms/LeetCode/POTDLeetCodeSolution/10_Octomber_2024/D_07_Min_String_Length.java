import java.util.Stack;

public class D_07_Min_String_Length {
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Test the minLength method
        String testString = "ABCD";
        int result = solution.minLength(testString);
        System.out.println("The minimum length of the string after removal is: " + result);
    }
}

class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(stack.isEmpty()) {
                stack.push(ch);
                continue;
            }
            if(ch == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if(ch == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
