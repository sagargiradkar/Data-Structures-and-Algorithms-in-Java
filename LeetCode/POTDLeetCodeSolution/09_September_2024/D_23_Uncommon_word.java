import java.util.*;

public class D_23_Uncommon_word {

    public static void main(String[] args) {
        String s1 = "apple banana orange";
        String s2 = "banana grape orange";

        Solution solution = new Solution();
        String[] uncommonWords = solution.uncommonFromSentences(s1, s2);

        System.out.println("Uncommon words: " + Arrays.toString(uncommonWords));
    }
}

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map = new HashMap<>();
        
        // Add words from s1 to the map
        for (String word : s1.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Add words from s2 to the map
        for (String word : s2.split(" ")) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Collect words that appear exactly once
        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }

        // Convert the list to an array
        String[] res = new String[list.size()];
        list.toArray(res);
        return res;
    }
}
