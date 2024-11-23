import java.util.HashMap;

public class D_20_Take_K_Each_Character {
    public boolean canTakeKOfEachCharacter(String s, int k) {
        // Edge case: If k is 0 or string is empty
        if (k == 0 || s.isEmpty()) return false;

        // Map to count frequency of each character
        HashMap<Character, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Check if each character's frequency is divisible by k
        for (int count : frequencyMap.values()) {
            if (count % k != 0) {
                return false; // Not divisible by k
            }
        }

        return true; // All characters can form k copies
    }

    // Main method
    public static void main(String[] args) {
        D_20_Take_K_Each_Character solution = new D_20_Take_K_Each_Character();

        // Test case 1
        String s1 = "aabbcc";
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.canTakeKOfEachCharacter(s1, k1)); // Output: true

        // Test case 2
        String s2 = "aabbccd";
        int k2 = 2;
        System.out.println("Test Case 2: " + solution.canTakeKOfEachCharacter(s2, k2)); // Output: false

        // Test case 3
        String s3 = "abcabcabc";
        int k3 = 3;
        System.out.println("Test Case 3: " + solution.canTakeKOfEachCharacter(s3, k3)); // Output: true
    }
}
