public class Bit_Count_Number {
    public static void main(String[] args) {
        // Example test case
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};

        Solution solution = new Solution();
        int result = solution.countConsistentStrings(allowed, words);

        System.out.println("Number of consistent strings: " + result);  // Output: 2
    }
}

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int mask = 0;

        // Create a bitmask for allowed characters
        for (char ch : allowed.toCharArray()) {
            mask |= 1 << (ch - 'a');  // Set the bit for the character
        }

        int count = 0;

        // Iterate over each word
        for (String word : words) {
            boolean allCharAllowed = true;

            // Check each character in the word
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                // Check if the bit corresponding to this character is set in the mask
                if (((mask >> (ch - 'a')) & 1) == 0) {
                    allCharAllowed = false;
                    break;
                }
            }

            // If all characters are allowed, increment the count
            if (allCharAllowed) {
                count++;
            }
        }

        return count;
    }
}
