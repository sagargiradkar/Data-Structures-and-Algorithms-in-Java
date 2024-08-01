public class MaxOddBinaryNumber {

    private String binaryString;

    // Constructor to initialize the binary string
    public MaxOddBinaryNumber(String binaryString) {
        this.binaryString = binaryString;
    }

    // Method to rearrange the binary string to form the maximum odd binary number
    public String getMaxOddBinaryNumber() {
        int count1 = 0;
        int count0 = 0;

        // Count the number of 1's and 0's
        for (char c : binaryString.toCharArray()) {
            if (c == '1') {
                count1++;
            } else if (c == '0') {
                count0++;
            }
        }

        // If there are no 1's, it's not possible to form an odd number
        if (count1 == 0) {
            return "";
        }

        // Build the result string
        StringBuilder result = new StringBuilder();
        
        // Append all 1's except the last one
        for (int i = 0; i < count1 - 1; i++) {
            result.append('1');
        }
        
        // Append all 0's
        for (int i = 0; i < count0; i++) {
            result.append('0');
        }
        
        // Append the last 1 to ensure the number is odd
        result.append('1');

        return result.toString();
    }

    public static void main(String[] args) {
        // Example usage
        MaxOddBinaryNumber number1 = new MaxOddBinaryNumber("010");
        System.out.println(number1.getMaxOddBinaryNumber());  // Output: "001"

        MaxOddBinaryNumber number2 = new MaxOddBinaryNumber("01010");
        System.out.println(number2.getMaxOddBinaryNumber());  // Output: "10001"
    }
}
