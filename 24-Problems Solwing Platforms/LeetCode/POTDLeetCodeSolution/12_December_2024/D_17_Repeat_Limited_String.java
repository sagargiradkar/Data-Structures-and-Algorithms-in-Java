import java.util.PriorityQueue;

public class D_17_Repeat_Limited_String {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        // Example input
        String s = "cczazcc";
        int repeatLimit = 2;

        // Call the function and display the result
        String result = solution.repeatLimitedString(s, repeatLimit);
        System.out.println("Output: " + result);
    }
}

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26]; // Frequency array to store character counts
        
        // Count the frequency of each character
        for (char ch : s.toCharArray()) { // T.C: O(n)
            count[ch - 'a']++;
        }

        // Max heap (priority queue) to store characters in descending order
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer((char) ('a' + i));
            }
        }

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll(); // Get the largest character
            int freq = Math.min(count[ch - 'a'], repeatLimit); // Append up to 'repeatLimit' times
            
            for (int i = 0; i < freq; i++) {
                result.append(ch);
            }
            count[ch - 'a'] -= freq;

            // If the current character still has remaining occurrences
            if (count[ch - 'a'] > 0 && !pq.isEmpty()) {
                char nextChar = pq.poll(); // Get the next largest character
                result.append(nextChar);
                count[nextChar - 'a']--;

                // Reinsert characters into the priority queue if they still have remaining occurrences
                if (count[nextChar - 'a'] > 0) {
                    pq.offer(nextChar);
                }
                pq.offer(ch);
            }
        }

        return result.toString();
    }
}
