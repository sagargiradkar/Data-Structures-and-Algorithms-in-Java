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
        String resultOptimized = solution.removeDuplicateLettersOptimized(input);
        
        System.out.println("Result after removing duplicates (original): " + result);
        System.out.println("Result after removing duplicates (optimized): " + resultOptimized);
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

    // New optimized method
    public String removeDuplicateLettersOptimized(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] present = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int idx = ch - 'a';

            if (!present[idx]) {
                while (!st.isEmpty() && st.peek() > ch && lastIndex[st.peek() - 'a'] > i) {
                    present[st.pop() - 'a'] = false;
                }
                st.push(ch);
                present[idx] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}
