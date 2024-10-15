import java.util.Scanner;

public class D_15_Separate_Black_and_White_Balls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string of black and white balls (as 0s and 1s):");
        String s = scanner.nextLine();
        
        Solution solution = new Solution();
        long result = solution.minimumSteps(s);
        
        System.out.println("Minimum number of steps to separate the balls: " + result);
    }
}

class Solution {
    public long minimumSteps(String s) {
        long ans = 0;
        long ones = 0;

        for (final char c : s.toCharArray()) {
            if (c == '1') {
                ++ones;
            } else {
                ans += ones;
            }
        }
        return ans;
    }
}
