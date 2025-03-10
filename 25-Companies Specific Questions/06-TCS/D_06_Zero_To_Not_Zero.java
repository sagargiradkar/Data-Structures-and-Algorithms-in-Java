import java.util.Scanner;

public class D_06_Zero_To_Not_Zero {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of m :: ");
        int m = sc.nextInt();
        System.out.print("Enter value of n :: ");
        int n = sc.nextInt();
        for (int i = m; i <= n; i++) {
            if (n >= 100) {
                System.out.printf("%03d", i);
                System.out.print(" ");
            } else if (n >= 10) {
                System.out.printf("%02d", i);
                System.out.print(" ");
            } else {
                System.out.printf("%d0d", i);
                System.out.print(" ");
            }
        }

    }
}
