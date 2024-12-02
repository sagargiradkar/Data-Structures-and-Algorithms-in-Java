
public class D_02_Check_Prefix_In_Sentence {

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].startsWith(searchWord)) {
                return i + 1; // 1-based index
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String sentence1 = "i love eating burger";
        String searchWord1 = "burg";
        System.out.println(isPrefixOfWord(sentence1, searchWord1)); // Output: 4

        String sentence2 = "this problem is an easy problem";
        String searchWord2 = "pro";
        System.out.println(isPrefixOfWord(sentence2, searchWord2)); // Output: 2

        String sentence3 = "i am tired";
        String searchWord3 = "you";
        System.out.println(isPrefixOfWord(sentence3, searchWord3)); // Output: -1
    }
}
