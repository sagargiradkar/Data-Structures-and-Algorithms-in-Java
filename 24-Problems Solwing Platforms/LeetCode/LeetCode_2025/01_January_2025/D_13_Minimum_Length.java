// D_13_Minimum_Length.java
public class D_13_Minimum_Length {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        String s1 = "abcba";
        System.out.println("Minimum length for s1: " + solution.minimumLength(s1)); // Expected: 3

        String s2 = "abccccdd";
        System.out.println("Minimum length for s2: " + solution.minimumLength(s2)); // Expected: 7

        String s3 = "aaabbbccc";
        System.out.println("Minimum length for s3: " + solution.minimumLength(s3)); // Expected: 7
    }
}

class Solution {
    public int minimumLength(String s) {
        int n = s.length();

        // Frequency array for characters 'a' to 'z'
        int[] freq = new int[26];

        // Count the frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freq[ch - 'a'] += 1;
        }

        int result = 0;

        // Calculate the minimum length of the string
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                continue;
            }

            // Add 2 for even frequencies, 1 for odd frequencies
            if (freq[i] % 2 == 0) {
                result += 2;
            } else {
                result += 1;
            }
        }

        return result;
    }
}
