import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {

        int i = 2;
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a nnumber :: ");
        n = sc.nextInt();

        for (i = 2; i <= n; i++) {
            if (n % i == 0) {
                System.out.println("Not a prime");
                break;
            } else {
                System.out.println("Prime number");
                break;
            }
        }
    }
}
