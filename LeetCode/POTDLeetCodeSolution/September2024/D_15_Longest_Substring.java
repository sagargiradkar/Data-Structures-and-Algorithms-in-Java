import java.util.HashMap;
import java.util.Map;

public class D_15_Longest_Substring {

    // Method to find the longest substring with vowels having even occurrences
    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each bitmask
        Map<Integer, Integer> mp = new HashMap<>();
        int mask = 0; // Initial mask with all vowels having even count
        mp.put(mask, -1); // Base case, bitmask 0 at index -1 (before the start of the string)
        int maxL = 0; // Variable to store the maximum length of valid substring

        // Iterate over the string
        for (int i = 0; i < s.length(); i++) {
            int val = 0;

            // Check for vowels and update the bitmask accordingly
            if (s.charAt(i) == 'a')      val = (1 << 0); // Toggle the 'a' bit
            else if (s.charAt(i) == 'e') val = (1 << 1); // Toggle the 'e' bit
            else if (s.charAt(i) == 'i') val = (1 << 2); // Toggle the 'i' bit
            else if (s.charAt(i) == 'o') val = (1 << 3); // Toggle the 'o' bit
            else if (s.charAt(i) == 'u') val = (1 << 4); // Toggle the 'u' bit

            // Update the mask by XOR-ing the current value
            mask ^= val;

            // If this mask hasn't been seen before, store the index
            if (!mp.containsKey(mask)) {
                mp.put(mask, i);
            }

            // Update the maximum length of valid substring
            maxL = Math.max(maxL, i - mp.get(mask));
        }

        // Return the maximum length of the valid substring
        return maxL;
    }

    public static void main(String[] args) {
        D_15_Longest_Substring obj = new D_15_Longest_Substring();
        
        // Test Case 1: Example input with vowels
        String test1 = "eleetminicoworoep";
        System.out.println("Test Case 1: " + obj.findTheLongestSubstring(test1));  // Expected output: 13

        // Test Case 2: No vowels
        String test2 = "bcdfg";
        System.out.println("Test Case 2: " + obj.findTheLongestSubstring(test2));  // Expected output: 5

        // Test Case 3: All vowels with even number
        String test3 = "aeiouaeiou";
        System.out.println("Test Case 3: " + obj.findTheLongestSubstring(test3));  // Expected output: 10

        // Test Case 4: All vowels with odd number
        String test4 = "aeioua";
        System.out.println("Test Case 4: " + obj.findTheLongestSubstring(test4));  // Expected output: 5

        // Test Case 5: Mixed characters with no repeating vowels
        String test5 = "leetcodeisgreat";
        System.out.println("Test Case 5: " + obj.findTheLongestSubstring(test5));  // Expected output: 5
    }
}
