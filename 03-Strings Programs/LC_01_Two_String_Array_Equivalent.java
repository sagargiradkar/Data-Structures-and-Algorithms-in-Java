public class LC_01_Two_String_Array_Equivalent {
    // Method to check if the concatenation of two string arrays is equal
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Concatenate all elements of word1
        StringBuilder sb1 = new StringBuilder();
        for (String w : word1) {
            sb1.append(w);
        }

        // Concatenate all elements of word2
        StringBuilder sb2 = new StringBuilder();
        for (String w : word2) {
            sb2.append(w);
        }

        // Compare the concatenated results of both arrays
        return sb1.toString().equals(sb2.toString());
    }

    // Main method to run the code
    public static void main(String[] args) {
        LC_01_Two_String_Array_Equivalent solution = new LC_01_Two_String_Array_Equivalent();

        // Example input
        String[] word1 = { "abc", "d", "ef" };
        String[] word2 = { "abcd", "ef" };

        // Call the method and print the result
        boolean result = solution.arrayStringsAreEqual(word1, word2);
        System.out.println("Are the concatenated arrays equal? " + result);
    }
}
