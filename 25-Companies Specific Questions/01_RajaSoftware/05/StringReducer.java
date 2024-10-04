public class StringReducer {

    /**
     * Reduces the string by removing prefixes and suffixes with matching characters.
     * 
     * @param s The input string consisting of characters 'a', 'b', and 'c'
     * @return The minimum length of the string after applying the operation
     */
    public int minimizeLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currentChar = s.charAt(left);
            
            // Move left pointer to the right while it matches the current character
            while (left <= right && s.charAt(left) == currentChar) {
                left++;
            }
            
            // Move right pointer to the left while it matches the current character
            while (right >= left && s.charAt(right) == currentChar) {
                right--;
            }
        }

        // The remaining string is the part that cannot be reduced further
        return right - left + 1;
    }

    public static void main(String[] args) {
        StringReducer reducer = new StringReducer();
        
        String input1 = "ca";
        int result1 = reducer.minimizeLength(input1);
        System.out.println("Minimum length of string 'ca': " + result1);  // Output: 2
        
        String input2 = "aabccabba";
        int result2 = reducer.minimizeLength(input2);
        System.out.println("Minimum length of string 'aabccabba': " + result2);  // Output: 3
    }
}
