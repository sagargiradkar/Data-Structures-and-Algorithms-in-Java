public class WordReplacer {
    
    private String input;
    
    // Constructor to initialize the input
    public WordReplacer(String input) {
        this.input = input;
    }

    // Method to replace alternate words with "xyz"
    public String replaceAlternateWords() {
        // Split the input string by dots
        String[] words = splitByDot(input);
        
        // Process the words and replace alternate ones with "xyz"
        for (int i = 1; i < words.length; i += 2) {
            words[i] = "xyz";
        }
        
        // Join the words back together with dots
        return joinWithDot(words);
    }
    
    // Method to split the string by dots without using built-in methods
    private String[] splitByDot(String str) {
        int count = countDots(str);
        String[] result = new String[count + 1];
        int start = 0, index = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                result[index++] = str.substring(start, i);
                start = i + 1;
            }
        }
        result[index] = str.substring(start);
        return result;
    }
    
    // Method to count the number of dots in the string
    private int countDots(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                count++;
            }
        }
        return count;
    }
    
    // Method to join the words array with dots without using built-in methods
    private String joinWithDot(String[] words) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                sb.append('.');
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // Example usage
        WordReplacer replacer = new WordReplacer("i.like.this.program.very.much");
        String result = replacer.replaceAlternateWords();
        System.out.println(result);  // Output: i.xyz.this.xyz.very.xyz
    }
}
