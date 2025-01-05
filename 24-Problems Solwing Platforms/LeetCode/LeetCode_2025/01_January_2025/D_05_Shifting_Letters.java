// D_05_Shifting_Letters.java
public class D_05_Shifting_Letters {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        String s = "abc";
        int[][] shifts = {
            {0, 1, 1},
            {1, 2, 0}
        };
        String result = solution.shiftingLetters(s, shifts);
        System.out.println("Resulting string after shifts: " + result);
    }
}

class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n + 1]; // Create a difference array

        // Apply shifts to the difference array
        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            // Increment or decrement based on direction
            diff[start] += direction == 1 ? 1 : -1;
            diff[end + 1] += direction == 1 ? -1 : 1;
        }

        // Compute the prefix sum to apply all shifts
        int[] shiftsApplied = new int[n];
        int currentShift = 0;
        for (int i = 0; i < n; i++) {
            currentShift += diff[i];
            shiftsApplied[i] = currentShift;
        }

        // Build the resulting string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // Calculate new character after applying shifts
            int originalChar = s.charAt(i) - 'a';
            int shiftedChar = (originalChar + shiftsApplied[i]) % 26;

            // Handle negative modulo
            if (shiftedChar < 0) {
                shiftedChar += 26;
            }

            result.append((char) (shiftedChar + 'a'));
        }

        return result.toString();
    }
}
