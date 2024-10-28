import java.util.Scanner;

public class D_47_Reverse_Words {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input from user
        System.out.print("Enter the string: ");
        String input = scanner.nextLine();
        
        String result = reverseWords(input);
        System.out.println("Reversed words: " + result);
    }

    public static String reverseWords(String s) {
        // Trim the string to remove leading and trailing spaces
        s = s.trim();
        // Split the string by spaces
        String[] words = s.split("\\s+");
        StringBuilder reversed = new StringBuilder();
        
        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }

        // Convert to string and trim the result to remove the last space
        return reversed.toString().trim();
    }
}
