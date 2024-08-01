public class MaxOddBinaryString {
    public static String maxOddBinaryString(String binaryStr) {
        int count0 = 0;
        int count1 = 0;

        // Count the number of '0's and '1's
        for (char c : binaryStr.toCharArray()) {
            if (c == '0') {
                count0++;
            } else {
                count1++;
            }
        }

        // Create the largest possible binary number by placing all '1's first followed by all '0's
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count1; i++) {
            result.append('1');
        }
        for (int i = 0; i < count0; i++) {
            result.append('0');
        }

        // Ensure the resulting number is odd by having the last character as '1'
        // If the last character is '0', swap it with the last '1'
        if (result.charAt(result.length() - 1) == '0') {
            result.setCharAt(result.length() - 1, '1');
            result.setCharAt(count1 - 1, '0');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(maxOddBinaryString("010"));    // Output: "001"
        System.out.println(maxOddBinaryString("01010"));  // Output: "10001"
    }
}
