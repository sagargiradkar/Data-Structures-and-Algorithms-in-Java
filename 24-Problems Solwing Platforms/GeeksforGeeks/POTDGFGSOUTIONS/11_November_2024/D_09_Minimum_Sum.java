import java.util.Arrays;

public class D_09_Minimum_Sum {
    public String minSum(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                num1.append(arr[i]);
            } else {
                num2.append(arr[i]);
            }
        }

        StringBuilder ans = new StringBuilder();
        int m = num2.length();
        n = num1.length();
        String str1 = num1.toString();
        String str2 = num2.toString();
        int i = n - 1, j = m - 1, carry = 0;

        // Adding the two numbers stored in num1 and num2
        while (i > -1 || j > -1 || carry != 0) {
            int temp1 = i > -1 ? str1.charAt(i) - '0' : 0;
            int temp2 = j > -1 ? str2.charAt(j) - '0' : 0;
            int num = temp1 + temp2 + carry;
            ans.append(num % 10);
            carry = num / 10;
            i--;
            j--;
        }

        ans.reverse();
        str1 = ans.toString();

        // Removing leading zeroes
        for (i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != '0') break;
        }

        return str1.substring(i);
    }

    public static void main(String[] args) {
        D_09_Minimum_Sum solution = new D_09_Minimum_Sum();
        int[] arr = {3, 4, 2, 7, 9, 1}; // Example input
        String result = solution.minSum(arr);
        System.out.println("Minimum Sum Result: " + result);
    }
}
