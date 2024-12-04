// D_04_Are_Rotations.java
public class D_04_Are_Rotations {

    // Function to check if two strings are rotations of each other or not.
    public static boolean areRotations(String s1, String s2) {
        // If lengths are not equal, they cannot be rotations.
        if (s1.length() != s2.length()) {
            return false;
        }

        // Concatenate s1 with itself.
        String concatenated = s1 + s1;

        // Use KMP to check if s2 is a substring of concatenated.
        return isSubstringKMP(concatenated, s2);
    }

    // Function to implement KMP algorithm for substring matching.
    private static boolean isSubstringKMP(String text, String pattern) {
        int[] lps = computeLPSArray(pattern);
        int i = 0, j = 0;
        int n = text.length(), m = pattern.length();

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                return true; // Pattern found in text.
            } else if (i < n && text.charAt(i) != pattern.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false; // Pattern not found.
    }

    // Function to compute the LPS (Longest Prefix Suffix) array for KMP.
    private static int[] computeLPSArray(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0, i = 1;

        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Main method for testing.
    public static void main(String[] args) {
        System.out.println(areRotations("abcd", "cdab")); // true
        System.out.println(areRotations("aab", "aba"));   // true
        System.out.println(areRotations("abcd", "acbd")); // false
    }
}
