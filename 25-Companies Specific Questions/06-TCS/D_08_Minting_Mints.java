import java.util.Scanner;

public class D_08_Minting_Mints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mint = sc.nextInt();
        int len = sc.nextInt();
        sc.close(); // Closing Scanner to prevent resource leak

        int sum = mint;
        int prev = mint; // Start with the initial value

        for (int i = 1; i < len; i++) {
            prev = prev + 1; // Increment the previous value
            sum += prev; // Add it to the sum
        }

        System.out.println(sum);
    }
}
