public class D_15_Buib_Switch {
    public static void main(String[] args) {
        // Example test case
        int n = 10;

        Solution solution = new Solution();
        int result = solution.bulbSwitch(n);

        System.out.println("Number of bulbs that remain on: " + result);  // Output: 3
    }
}

class Solution {
    public int bulbSwitch(int n) {
        int count = 0;
        int i = 1;

        // Count the perfect squares less than or equal to n
        while (i * i <= n) {
            count++;
            i++;
        }

        return count;
    }
}
