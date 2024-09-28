import java.util.HashSet;

public class D_12_Count_Number_Consistent_Strings {
    public static void main(String[] args) {
        // Test the solution
        Solution solution = new Solution();
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        
        int result = solution.countConsistentStrings(allowed, words);
        System.out.println("Number of consistent strings: " + result); // Output: 2
    }
}

class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int counter = 0;
        HashSet<Character> set = new HashSet<>();
        
        // Add allowed characters to the set
        for (int i = 0; i < allowed.length(); i++) {
            set.add(allowed.charAt(i));
        }

        // Check each word
        for (String str : words) {
            boolean flag = true;

            // Check each character in the word
            for (int i = 0; i < str.length(); i++) {
                if (!set.contains(str.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                counter++;
            }
        }
        return counter;
    }
}
