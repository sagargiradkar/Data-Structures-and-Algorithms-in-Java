import java.util.Scanner;

public class D_07_Oddly_Even {
    public static void main(String[] args) {
        int odd = 0, even = 0;
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine(); // Read input as a string
        sc.close(); // Close scanner to avoid resource leak

        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0'; // Convert char to int

            if ((i + 1) % 2 == 1) { // Odd index (1-based)
                odd += digit;
            } else { // Even index (1-based)
                even += digit;
            }
        }

        System.out.println(Math.abs(odd - even)); // Print absolute difference
    }
}
