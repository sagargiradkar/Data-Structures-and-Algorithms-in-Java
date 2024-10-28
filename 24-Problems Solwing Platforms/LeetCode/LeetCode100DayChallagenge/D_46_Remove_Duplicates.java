import java.util.HashMap;
import java.util.Stack;
import java.util.Scanner;

public class D_46_Remove_Duplicates {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input from user
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        Solution solution = new Solution();
        String result = solution.removeDuplicateLetters(input);
        
        System.out.println("Result after removing duplicates: " + result);
    }
}

class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Integer> lastOccurrence = new HashMap<>();
        boolean[] inStack = new boolean[26];
        
        // Fill last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence.put(s.charAt(i), i);
        }
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Skip character if it's already in the stack
            if (inStack[c - 'a']) continue;
            
            // Maintain lexicographical order by removing larger elements
            while (!stack.isEmpty() && stack.peek() > c && lastOccurrence.get(stack.peek()) > i) {
                inStack[stack.pop() - 'a'] = false;
            }
            
            // Push current character and mark it as added
            stack.push(c);
            inStack[c - 'a'] = true;
        }
        
        // Build result from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}
