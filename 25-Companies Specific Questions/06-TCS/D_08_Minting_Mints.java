import java.util.Scanner;

public class D_08_Minting_Mints {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mint = sc.nextInt();
        int len = sc.nextInt();
        sc.close(); 

        int sum = mint;
        int prev;

        for (int i = 1; i < len; i++) {
            prev = sum - 1; 
            sum += prev; 
        }

        System.out.println(sum);
    }
}
