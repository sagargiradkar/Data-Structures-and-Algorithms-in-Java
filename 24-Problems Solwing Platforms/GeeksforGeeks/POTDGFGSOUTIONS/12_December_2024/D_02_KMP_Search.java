import java.util.ArrayList;

public class D_02_KMP_Search {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Simple match
        String txt1 = "ababcababc";
        String pat1 = "abc";
        System.out.println("Pattern found at indices: " + solution.search(pat1, txt1));
        // Expected output: [2, 7]

        // Test Case 2: Multiple matches
        String txt2 = "aaaaa";
        String pat2 = "aa";
        System.out.println("Pattern found at indices: " + solution.search(pat2, txt2));
        // Expected output: [0, 1, 2, 3]

        // Test Case 3: Pattern not found
        String txt3 = "abcdefgh";
        String pat3 = "xyz";
        System.out.println("Pattern found at indices: " + solution.search(pat3, txt3));
        // Expected output: []

        // Test Case 4: Pattern equals the text
        String txt4 = "pattern";
        String pat4 = "pattern";
        System.out.println("Pattern found at indices: " + solution.search(pat4, txt4));
        // Expected output: [0]

        // Test Case 5: Empty pattern
        String txt5 = "anytext";
        String pat5 = "";
        System.out.println("Pattern found at indices: " + solution.search(pat5, txt5));
        // Expected output: []

        // Test Case 6: Empty text
        String txt6 = "";
        String pat6 = "pattern";
        System.out.println("Pattern found at indices: " + solution.search(pat6, txt6));
        // Expected output: []
    }
}

class Solution {
    ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();

        if (m == 0 || n == 0 || m > n) {
            return result; // Edge case: empty pattern or text
        }

        // Step 1: Build the LPS array for the pattern
        int[] lps = new int[m];
        computeLPSArray(pat, m, lps);

        // Step 2: Perform the KMP search
        int i = 0; // index for txt
        int j = 0; // index for pat
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if (j == m) {
                result.add(i - j); // Pattern found at index (i - j)
                j = lps[j - 1];
            } else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Mismatch after j matches
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return result;
    }

    private void computeLPSArray(String pat, int m, int[] lps) {
        int length = 0; // Length of previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // LPS[0] is always 0

        // Loop to fill lps[i] for i = 1 to m-1
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                // Mismatch
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
