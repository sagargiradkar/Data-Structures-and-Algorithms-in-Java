// D_07_String_Matching.java
import java.util.*;

public class D_07_String_Matching {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String[] words = {"mass", "as", "hero", "superhero"};
        List<String> result = solution.stringMatching(words);
        System.out.println("Words that are substrings of others: " + result);
    }
}

// User function Template for Java
class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Iterate through each word in the array
        for (int i = 0; i < words.length; i++) {
            // Check if the current word is a substring of any other word
            for (int j = 0; j < words.length; j++) {
                if (i != j && words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;  // No need to check further if it's already added
                }
            }
        }
        
        return result;
    }
}
