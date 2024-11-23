public class D_01_Delete_Character {
    
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            int n = result.length();
            // Check if the last two characters in result are the same as the current character
            if (n >= 2 && result.charAt(n - 1) == s.charAt(i) && result.charAt(n - 2) == s.charAt(i)) {
                continue; // Skip adding this character to avoid three consecutive characters
            }
            result.append(s.charAt(i));
        }
        
        return result.toString();
    }
    
    public static void main(String[] args) {
        D_01_Delete_Character solution = new D_01_Delete_Character();
        
        String s = "aaabaaaa"; // Test input
        String result = solution.makeFancyString(s);
        
        System.out.println("Original String: " + s);
        System.out.println("Fancy String: " + result);
    }
}
