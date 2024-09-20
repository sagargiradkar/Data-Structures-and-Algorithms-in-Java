public class D_20_Shortest_Palindrome {
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();  // Reverse the string
        
        // Find the largest palindrome prefix in s
        for (int i = 0; i < s.length(); i++) {
            if (s.substring(0, s.length() - i).equals(rev.substring(i))) {
                return rev.substring(0, i) + s;  // Add the characters from rev that are needed to form the palindrome
            }
        }
        
        return rev + s;  // In case no match is found, return rev + s (this is rare for valid inputs)
    }

    public static void main(String[] args) {
        D_20_Shortest_Palindrome solution = new D_20_Shortest_Palindrome();
        String input = "aacecaaa";  // Example input
        String result = solution.shortestPalindrome(input);
        System.out.println("Shortest palindrome: " + result);  // Output the result
    }
}
