import java.util.*;

public class D_19_Reverse_Words {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "i.like.this.program.very.much";
        String reversed = solution.reverseWords(input);
        System.out.println("Reversed words: " + reversed);
    }
}

class Solution {
    public String reverseWords(String str) {
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        
        // Split the string into words
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '.') {
                word.append(str.charAt(i));
            } else {
                words.add(word.toString());
                word.setLength(0); // Clear the current word
            }
        }
        words.add(word.toString()); // Add the last word

        // Reverse the words and form the result
        StringBuilder result = new StringBuilder();
        for (int i = words.size() - 1; i >= 0; i--) {
            result.append(words.get(i));
            if (i != 0) {
                result.append(".");
            }
        }

        return result.toString();
    }
}
