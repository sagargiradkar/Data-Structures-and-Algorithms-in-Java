import java.util.*;
public class D_17_Uncommon_Word {

    public static String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }

    public static void main(String[] args) {
        // Example usage
        String sentence1 = "this apple is sweet";
        String sentence2 = "this apple is sour";
        String[] uncommonWords = uncommonFromSentences(sentence1, sentence2);

        System.out.println("Uncommon words:");
        for (String word : uncommonWords) {
            System.out.println(word);
        }
    }
}