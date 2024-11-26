import java.util.Scanner;

public class D_48_String_Compression {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input from user
        System.out.print("Enter the string (without spaces): ");
        String input = scanner.nextLine();
        
        // Convert string to character array
        char[] chars = input.toCharArray();
        
        // Create a Solution instance and compress the character array
        Solution solution = new Solution();
        int newLength = solution.compress(chars);
        
        // Output the compressed characters
        System.out.print("Compressed string: ");
        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i]);
        }
        System.out.println(); // For newline
    }
}

class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int index = 0;
        int i = 0;

        while (i < n) {
            char curr_char = chars[i];
            int count = 0;

            // Find count of duplicates
            while (i < n && chars[i] == curr_char) {
                count++;
                i++;
            }

            // Assign current character
            chars[index] = curr_char;
            index++;

            // If count is more than 1, append the count
            if (count > 1) {
                String count_str = String.valueOf(count);
                for (char ch : count_str.toCharArray()) {
                    chars[index] = ch;
                    index++;
                }
            }
        }
        return index;
    }
}
