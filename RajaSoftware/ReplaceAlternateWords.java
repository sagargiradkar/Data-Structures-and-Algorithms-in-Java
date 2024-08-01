public class ReplaceAlternateWords {
    public static String replaceAlternateWords(String input) {
        StringBuilder result = new StringBuilder();
        int wordIndex = 0;
        int length = input.length();
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < length; i++) {
            char ch = input.charAt(i);
            if (ch == '.') {
                // Check if the wordIndex is odd
                if (wordIndex % 2 == 1) {
                    result.append("xyz");
                } else {
                    result.append(word.toString());
                }
                result.append('.');
                word.setLength(0);  // Clear the word builder
                wordIndex++;
            } else {
                word.append(ch);
            }
        }

        // Append the last word
        if (wordIndex % 2 == 1) {
            result.append("xyz");
        } else {
            result.append(word.toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        String input1 = "i.like.this.program.very.much";
        System.out.println(replaceAlternateWords(input1));  // Output: "i.xyz.this.xyz.very.xyz"
        
        String input2 = "hello.world.how.are.you";
        System.out.println(replaceAlternateWords(input2));  // Output: "hello.xyz.how.xyz.you"
    }
}
