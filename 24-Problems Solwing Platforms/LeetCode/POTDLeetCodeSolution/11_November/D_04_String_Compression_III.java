import java.util.Scanner;

public class D_04_String_Compression_III {

    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int i = 0;

        while (i < n) {
            int count = 0;
            char ch = word.charAt(i);

            while (i < n && count < 9 && word.charAt(i) == ch) {
                count++;
                i++;
            }

            comp.append(count).append(ch);
        }

        return comp.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input string
        System.out.print("Enter a string to compress: ");
        String word = scanner.nextLine();

        // Create an instance of the class and call the compressedString method
        D_04_String_Compression_III compressor = new D_04_String_Compression_III();
        String compressed = compressor.compressedString(word);

        // Print the compressed string
        System.out.println("Compressed string: " + compressed);

        scanner.close();
    }
}
