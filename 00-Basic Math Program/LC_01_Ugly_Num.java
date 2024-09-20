public class LC_01_Ugly_Num {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 30; // Example input
        boolean result = solution.isUgly(n);
        System.out.println("Is " + n + " an ugly number? " + result);
    }
}

class Solution {
    public boolean isUgly(int n) {
        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else if (n % 3 == 0) {
                n = n / 3;
            } else if (n % 5 == 0) {
                n = n / 5;
            } else {
                return false;
            }
        }
        return n == 1;
    }
}
