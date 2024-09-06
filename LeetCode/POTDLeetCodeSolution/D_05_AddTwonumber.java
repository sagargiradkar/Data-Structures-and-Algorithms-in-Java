import java.util.Scanner;

public class D_05_AddTwonumber {

    // User function template
    static class Solution {
        public int sum(int num1, int num2) {
            int l = -200, r = 200;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (mid == num1 + num2) {
                    return mid;
                }
                if (mid < num1 + num2) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter the first number: ");
        int num1 = sc.nextInt();
        
        System.out.print("Enter the second number: ");
        int num2 = sc.nextInt();

        // Create Solution object and find the sum
        Solution sol = new Solution();
        int result = sol.sum(num1, num2);

        // Output the sum
        System.out.println("The sum of the two numbers is: " + result);
        
        sc.close();
    }
}
