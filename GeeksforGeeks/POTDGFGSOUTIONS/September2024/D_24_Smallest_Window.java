import java.util.Scanner;

public class D_24_Smallest_Window {

    public static void main(String[] args) {
        // Input from the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string s: ");
        String s = sc.nextLine();
        System.out.print("Enter string p: ");
        String p = sc.nextLine();

        // Find the smallest window containing all characters of p
        String result = Solution.smallestWindow(s, p);

        // Output the result
        System.out.println("Smallest window containing all characters of p: " + result);
    }
}

class Solution {
    // Function to find the smallest window in the string s consisting of all characters of string p.
    public static String smallestWindow(String s, String p) {
        if (p.length() > s.length()) return "-1";  // If p is longer than s, return -1
        
        int[] forS = new int[26];  // Frequency array for characters in s
        int[] forP = new int[26];  // Frequency array for characters in p
        int requiredCount = 0;     // Unique characters count in p
        int formedCount = 0;       // To keep track of matched characters
        int n = s.length();
        int m = p.length();
        int j = 0;                 // Left pointer of the window
        int start = -1, end = -1;  // Start and end of the smallest window
        int minLength = Integer.MAX_VALUE;  // Length of the smallest window

        // Initialize the frequency array for string p
        for (int i = 0; i < m; i++) {
            char x = p.charAt(i);
            forP[x - 'a']++;
            if (forP[x - 'a'] == 1) requiredCount++;  // Increment the count of unique characters
        }

        // Traverse the string s to find the smallest window
        for (int i = 0; i < n; i++) {
            char x = s.charAt(i);
            forS[x - 'a']++;

            // If the frequency of the current character matches that in p, increment the formed count
            if (forS[x - 'a'] == forP[x - 'a']) formedCount++;

            // If all characters of p are found in the current window
            if (formedCount == requiredCount) {
                // Shrink the window from the left
                while (forS[s.charAt(j) - 'a'] > forP[s.charAt(j) - 'a']) {
                    forS[s.charAt(j++) - 'a']--;
                }

                // Update the minimum window length and start/end positions
                if (minLength > i - j + 1) {
                    start = j;
                    end = i;
                    minLength = i - j + 1;
                }
            }
        }

        // If no valid window is found, return "-1"
        if (start == -1) return "-1";

        // Return the substring that represents the smallest window
        return s.substring(start, end + 1);
    }
}
