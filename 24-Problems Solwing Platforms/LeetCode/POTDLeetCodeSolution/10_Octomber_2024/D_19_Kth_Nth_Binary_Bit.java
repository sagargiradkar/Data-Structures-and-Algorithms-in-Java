import java.util.Scanner;

public class D_19_Kth_Nth_Binary_Bit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input for 'n' and 'k'
        System.out.println("Enter the value of n:");
        int n = sc.nextInt();
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();
        
        // Create an instance of the Solution class and call the findKthBit method
        Solution solution = new Solution();
        char result = solution.findKthBit(n, k);

        // Print the result
        System.out.println("The " + k + "-th bit in the " + n + "-th binary string is: " + result);
        
        sc.close();
    }
}

class Solution {
    public char findKthBit(int n, int k) {
        int len = (int) Math.pow(2, n) - 1; // Total length of the binary string
        return recur(len, k); // Call the recursive function
    }

    public char recur(int len, int k) {
        // Base case
        if (len == 1) {
            return '0';
        }

        int half = len / 2;
        int middle = half + 1;
        
        // Debugging output to track steps
        System.out.println("len -> " + len + " , middle -> " + middle + " , k -> " + k);

        // If k is in the middle, return '1'
        if (k == middle) {
            return '1';
        }
        // If k is on the left side
        else if (k < middle) {
            return recur(half, k);
        }
        // If k is on the right side, invert the bit
        else {
            char ans = recur(half, 1 + len - k);
            return (ans == '0') ? '1' : '0';
        }
    }
}
