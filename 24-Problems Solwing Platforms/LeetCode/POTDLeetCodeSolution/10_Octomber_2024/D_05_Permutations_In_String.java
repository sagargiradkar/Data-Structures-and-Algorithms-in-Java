import java.util.Arrays;

public class D_05_Permutations_In_String {
    
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // If s1 is larger than s2, no permutation can exist
        if (n > m) return false;

        // Frequency arrays for s1 and the current window in s2
        int[] s1_freq = new int[26];
        int[] s2_freq = new int[26];

        // Fill frequency of characters in s1
        for (int i = 0; i < n; i++) {
            s1_freq[s1.charAt(i) - 'a']++;
        }

        // Slide the window over s2
        int i = 0; // left index of the sliding window
        int j = 0; // right index of the sliding window
        while (j < m) {
            // Include a new character from the right end of the window
            s2_freq[s2.charAt(j) - 'a']++;

            // Check if the current window size matches the size of s1
            if (j - i + 1 > n) {
                // If we have passed the size of s1, we need to remove the leftmost character
                s2_freq[s2.charAt(i) - 'a']--;
                i++;
            }

            // Check if the current window's frequency matches s1's frequency
            if (Arrays.equals(s1_freq, s2_freq)) {
                return true;
            }

            j++;
        }

        // No matching window found
        return false;
    }

    public static void main(String[] args) {
        D_05_Permutations_In_String solution = new D_05_Permutations_In_String();
        
        // Test case 1
        String s1 = "ab";
        String s2 = "eidbaooo";
        System.out.println("Test case 1: " + solution.checkInclusion(s1, s2)); // Expected output: true

        // Test case 2
        s1 = "ab";
        s2 = "eidboaoo";
        System.out.println("Test case 2: " + solution.checkInclusion(s1, s2)); // Expected output: false
    }
}
