// D_10_Word_Subsets.java
import java.util.ArrayList;
import java.util.List;

public class D_10_Word_Subsets {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String[] words1 = {"amazon", "apple", "facebook", "google", "leetcode"};
        String[] words2 = {"e", "o"};

        List<String> result = solution.wordSubsets(words1, words2);
        System.out.println("Universal strings: " + result);
    }
}

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        // Array to store the maximum frequency of each character across all words in words2
        int[] maxFreq = new int[26];
        for (String b : words2) {
            int[] freq = countFrequency(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        
        // Result list to store the universal strings
        List<String> result = new ArrayList<>();
        for (String a : words1) {
            int[] freq = countFrequency(a);
            if (isSubset(freq, maxFreq)) {
                result.add(a);
            }
        }
        
        return result;
    }
    
    // Helper method to count the frequency of each character in a string
    private int[] countFrequency(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    
    // Helper method to check if freqA satisfies freqB
    private boolean isSubset(int[] freqA, int[] freqB) {
        for (int i = 0; i < 26; i++) {
            if (freqA[i] < freqB[i]) {
                return false;
            }
        }
        return true;
    }
}
