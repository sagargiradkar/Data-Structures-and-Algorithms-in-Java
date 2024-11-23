public class D_02_Circular_Sentence {
    
    public static void main(String[] args) {
        D_02_Circular_Sentence solution = new D_02_Circular_Sentence();
        
        // Test cases
        System.out.println(solution.isCircularSentence("hello olleh hello")); // Expected output: true
        System.out.println(solution.isCircularSentence("hi igloo"));         // Expected output: false
    }
    
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        
        // Check circular condition between each pair of words
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        
        // Check the circular condition between last and first word
        return words[words.length - 1].charAt(words[words.length - 1].length() - 1) == words[0].charAt(0);
    }
}