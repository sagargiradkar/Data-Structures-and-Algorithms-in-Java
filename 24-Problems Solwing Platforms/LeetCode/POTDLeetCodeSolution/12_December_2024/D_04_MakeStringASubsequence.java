// File: D_04_MakeStringASubsequence.java

public class D_04_MakeStringASubsequence {
    public static boolean canMakeSubsequence(String str1, String str2) {
        int i = 0, j = 0;
        while (i < str1.length() && j < str2.length()) {
            char a = str1.charAt(i);
            char b = str2.charAt(j);
            // Check if the current character or its cyclic increment matches
            if (a == b || (a + 1 - 'a') % 26 + 'a' == b) {
                j++; // Move to the next character in str2
            }
            i++; // Always move to the next character in str1
        }
        return j == str2.length(); // Check if all characters in str2 are matched
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "ad";
        System.out.println("Can make subsequence: " + canMakeSubsequence(str1, str2));
    }
}
