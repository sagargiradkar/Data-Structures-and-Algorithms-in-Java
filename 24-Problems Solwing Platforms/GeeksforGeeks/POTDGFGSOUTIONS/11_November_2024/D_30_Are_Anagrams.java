public class D_30_Are_Anagrams {

    public static void main(String[] args) {
        // Test cases
        Solution solution = new Solution();

        String s1 = "listen";
        String s2 = "silent";
        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? " + solution.areAnagrams(s1, s2)); // Output: true

        s1 = "triangle";
        s2 = "integral";
        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? " + solution.areAnagrams(s1, s2)); // Output: true

        s1 = "apple";
        s2 = "pale";
        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? " + solution.areAnagrams(s1, s2)); // Output: false

        s1 = "abcd";
        s2 = "dcba";
        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? " + solution.areAnagrams(s1, s2)); // Output: true

        s1 = "test";
        s2 = "best";
        System.out.println("Are '" + s1 + "' and '" + s2 + "' anagrams? " + solution.areAnagrams(s1, s2)); // Output: false
    }
}

class Solution {
    public static boolean areAnagrams(String s1, String s2) {
        // If lengths differ, they cannot be anagrams
        if (s1.length() != s2.length()) {
            return false;
        }

        // Create a frequency array for lowercase English letters
        int[] charCount = new int[26];

        // Count characters in both strings
        for (int i = 0; i < s1.length(); i++) {
            charCount[s1.charAt(i) - 'a']++; // Increment for s1
            charCount[s2.charAt(i) - 'a']--; // Decrement for s2
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true; // Strings are anagrams
    }
}
