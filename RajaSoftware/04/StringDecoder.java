import java.util.Stack;

public class StringDecoder {
    
    /**
     * Decodes the encoded string following the pattern k[encoded_string].
     *
     * @param s The encoded string
     * @return The decoded string
     */
    public String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int index = 0;
        
        while (index < s.length()) {
            char currentChar = s.charAt(index);
            
            if (Character.isDigit(currentChar)) {
                // If the current character is a digit, calculate the full number
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {
                    count = count * 10 + (s.charAt(index) - '0');
                    index++;
                }
                countStack.push(count);
            } else if (currentChar == '[') {
                // Push the current string onto the result stack and reset it
                resultStack.push(currentString);
                currentString = new StringBuilder();
                index++;
            } else if (currentChar == ']') {
                // Pop from the stack and repeat the current string accordingly
                StringBuilder decodedString = resultStack.pop();
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    decodedString.append(currentString);
                }
                currentString = decodedString;
                index++;
            } else {
                // Append regular characters to the current string
                currentString.append(currentChar);
                index++;
            }
        }
        
        return currentString.toString();
    }
    
    public static void main(String[] args) {
        StringDecoder decoder = new StringDecoder();
        
        String input1 = "3[a]2[bc]";
        String output1 = decoder.decodeString(input1);
        System.out.println("Decoded string: " + output1);  // Output: "aaabcbc"
        
        String input2 = "3[a2[c]]";
        String output2 = decoder.decodeString(input2);
        System.out.println("Decoded string: " + output2);  // Output: "accaccacc"
    }
}
