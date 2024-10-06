import java.util.Scanner;

public class D_06_Sentence_Similarity_III {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for sentence1 and sentence2
        System.out.println("Enter first sentence:");
        String sentence1 = sc.nextLine();

        System.out.println("Enter second sentence:");
        String sentence2 = sc.nextLine();

        // Create an instance of Solution class
        Solution solution = new Solution();

        // Check if sentences are similar
        boolean result = solution.areSentencesSimilar(sentence1, sentence2);

        // Output result
        System.out.println("Are the sentences similar? " + result);

        sc.close();
    }
}

class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        if (sentence1.length() > sentence2.length()) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        String smallerWords[] = sentence1.split(" ");
        String largestWords[] = sentence2.split(" ");
        int start = 0;
        int end1 = smallerWords.length - 1;
        int end2 = largestWords.length - 1;

        while (start <= end1 && smallerWords[start].equals(largestWords[start])) {
            start++;
        }

        while (start <= end1 && smallerWords[end1].equals(largestWords[end2])) {
            end1--;
            end2--;
        }
        return (start > end1);
    }
}
