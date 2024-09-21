import java.util.*;

public class InvertedNumericalP {
    public static void main(String[] args) {

        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number :: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j == i + 1 || j == n || i == 0) {
                    System.out.print(j);
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
}
