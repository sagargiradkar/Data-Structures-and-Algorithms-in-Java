public class D_29_Add_Binary {

    public static void main(String[] args) {
        // Test cases
        String binary1 = "1010";
        String binary2 = "1011";

        Solution solution = new Solution();
        String result = solution.addBinary(binary1, binary2);

        // Output the result
        System.out.println("Sum of binary numbers: " + result);
    }
}

class Solution {
    public String addBinary(String s1, String s2) {
        StringBuilder result = new StringBuilder();
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int bit1 = (i >= 0) ? s1.charAt(i) - '0' : 0;
            int bit2 = (j >= 0) ? s2.charAt(j) - '0' : 0;

            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);  // Append the binary digit (0 or 1)
            carry = sum / 2;        // Update carry

            i--;
            j--;
        }

        // Reverse the result to get the final binary sum
        return result.reverse().toString();
    }
}
