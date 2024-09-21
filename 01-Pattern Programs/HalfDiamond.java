import java.util.*;

public class HalfDiamond {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number ::");
        n = sc.nextInt();
        for (int i = 0; i < 2 * n - 1; i++) {
            int cond = 0;
            if (i < n) {
                cond = i;
            } else {
                cond = n - (i % n) - 2;
            }
            for (int j = 0; j <= cond; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
