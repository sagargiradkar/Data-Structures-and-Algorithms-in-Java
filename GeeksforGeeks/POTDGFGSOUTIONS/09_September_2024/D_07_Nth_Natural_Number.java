public class D_07_Nth_Natural_Number {

    static class Solution {
        public long findNth(long n) {
            long ans = 0;
            long p = 1;

            while (n > 0) {
                ans += p * (n % 9);  // Adding the remainder when dividing n by 9
                n /= 9;  // Reducing n by dividing it by 9
                p *= 10; // Increasing the positional multiplier
            }
            return ans;
        }
    }

    // Main method for testing the findNth function
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        long n = 10;
        System.out.println("The 10th natural number without any digit as 9 is: " + solution.findNth(n));

        n = 15;
        System.out.println("The 15th natural number without any digit as 9 is: " + solution.findNth(n));

        n = 50;
        System.out.println("The 50th natural number without any digit as 9 is: " + solution.findNth(n));
    }
}
