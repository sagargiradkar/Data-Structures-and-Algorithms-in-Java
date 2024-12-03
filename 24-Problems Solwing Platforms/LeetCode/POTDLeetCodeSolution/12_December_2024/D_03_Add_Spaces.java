public class D_03_Add_Spaces {
    public static void main(String[] args) {
        // Test the addSpaces function
        String s = "leetcodehelpsmelearn";
        int[] spaces = {8, 13, 15};
        
        String result = addSpaces(s, spaces);
        System.out.println("Resulting string: " + result);
    }

    public static String addSpaces(String s, int[] spaces) {
        int m = s.length();
        int n = spaces.length;

        StringBuilder result = new StringBuilder(); // Using StringBuilder for efficiency
        int j = 0; // Pointer to traverse the spaces array

        for (int i = 0; i < m; i++) {
            if (j < n && i == spaces[j]) {
                result.append(" ");
                j++;
            }
            result.append(s.charAt(i));
        }

        return result.toString();
    }
}