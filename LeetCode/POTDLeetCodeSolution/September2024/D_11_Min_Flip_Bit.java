public class D_11_Min_Flip_Bit {
    public static void main(String[] args) {
        Solution solution = new Solution();
        
        int start = 10;  // Example value
        int goal = 7;    // Example value
        
        int result = solution.minBitFlips(start, goal);
        System.out.println("Minimum bit flips required: " + result);
    }
}

class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int count = 0;
        while (xor > 0) {
            xor = xor & (xor - 1);
            count++;
        }
        return count;
    }
}
