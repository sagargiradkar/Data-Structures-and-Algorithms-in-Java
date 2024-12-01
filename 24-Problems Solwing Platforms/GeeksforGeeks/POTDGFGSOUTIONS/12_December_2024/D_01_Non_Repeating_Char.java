public class D_01_Non_Repeating_Char {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple string with non-repeating character
        String s1 = "leetcode";
        System.out.println("First non-repeating character in \"" + s1 + "\": " + solution.nonRepeatingChar(s1));
        // Expected output: 'l'

        // Test Case 2: String with all repeating characters
        String s2 = "aabbcc";
        System.out.println("First non-repeating character in \"" + s2 + "\": " + solution.nonRepeatingChar(s2));
        // Expected output: '$'

        // Test Case 3: String with multiple non-repeating characters
        String s3 = "abcabcde";
        System.out.println("First non-repeating character in \"" + s3 + "\": " + solution.nonRepeatingChar(s3));
        // Expected output: 'd'

        // Test Case 4: String with a single character
        String s4 = "z";
        System.out.println("First non-repeating character in \"" + s4 + "\": " + solution.nonRepeatingChar(s4));
        // Expected output: 'z'

        // Test Case 5: Empty string
        String s5 = "";
        System.out.println("First non-repeating character in \"" + s5 + "\": " + solution.nonRepeatingChar(s5));
        // Expected output: '$'
    }
}

class Solution {
    // Function to find the first non-repeating character in a string.
    static char nonRepeatingChar(String s) {
        // Step 1: Create a frequency map (can be an array of size 26 for lowercase letters).
        int[] freq = new int[26];
        
        // Step 2: Count the frequency of each character in the string.
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Step 3: Find the first character whose frequency is 1.
        for (char c : s.toCharArray()) {
            if (freq[c - 'a'] == 1) {
                return c;  // First non-repeating character found.
            }
        }
        
        // Step 4: If no non-repeating character is found, return '$'.
        return '$';
    }
}
