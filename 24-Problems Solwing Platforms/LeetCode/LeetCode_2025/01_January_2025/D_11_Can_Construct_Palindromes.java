// D_11_Can_Construct_Palindromes.java
public class D_11_Can_Construct_Palindromes {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String s = "annabelle";
        int k = 2;
        boolean result = solution.canConstruct(s, k);
        System.out.println("Can construct " + k + " palindromes: " + result);
    }
}

class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than string length, impossible
        if (k > s.length()) return false;
        
        // Count frequency of each character
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Count characters with odd frequencies
        int oddCount = 0;
        for (int count : freq) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }
        
        // If k is smaller than number of odd frequencies, impossible
        // If k is between odd frequencies and string length, possible
        return oddCount <= k && k <= s.length();
    }
}
