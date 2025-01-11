// D_11_Longest_Unique_Substring.java
import java.util.HashMap;

public class D_11_Longest_Unique_Substring {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String s = "abcabcbb";
        int result = solution.longestUniqueSubstr(s);
        System.out.println("Length of the longest substring with unique characters: " + result);
    }
}

class Solution {
    public int longestUniqueSubstr(String s) {
        // HashMap to store the last index of each character
        HashMap<Character, Integer> lastSeen = new HashMap<>();
        int maxLength = 0; // Result: maximum length of substring
        int start = 0; // Start index of the sliding window

        // Traverse the string
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the window, move the start pointer
            if (lastSeen.containsKey(currentChar) && lastSeen.get(currentChar) >= start) {
                start = lastSeen.get(currentChar) + 1;
            }

            // Update the last seen index of the current character
            lastSeen.put(currentChar, end);

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}
