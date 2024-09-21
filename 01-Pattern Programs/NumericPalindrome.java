import java.util.*;

public class NumericPalindrome {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number ::");
        n = sc.nextInt();
        int k = n;
        for (int i = 0; i < n; i++) {
            int c = 1;
            for (int j = 0; j < k; j++) {
                if (j < n - i - 1) {
                    System.out.print(" ");
                } else if (j <= n - 1) {
                    System.out.print(c);
                    c++;
                } else if (j == n) {
                    c = c - 2;
                    System.out.print(c);
                    c--;
                } else {
                    System.out.print(c);
                    c--;
                }
            }
            k++;
            System.out.println();
        }
    }

}
