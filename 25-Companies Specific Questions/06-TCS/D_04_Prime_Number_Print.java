import java.util.Arrays;
import java.util.Scanner;
//prints all primes numbers smaller than or equal to n

public class D_04_Prime_Number_Print {

    public static void printPrime(int n) {

        for (int i = 2; i <= n; i++) {
            if (i == 2) {
                System.out.print(i + " ");
            }
            if (i % 2 == 0) {
                System.out.print(" ");
            } else {
                System.out.print(i + " ");
            }

        }
    }

    public static void printPrimeOptimized(int n) {
        boolean[] chechPrime = new boolean[n + 1];
        Arrays.fill(chechPrime, true);

        for (int i = 2; i * i <= n; i++) {
            if (chechPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    chechPrime[j] = false;
                }
            }
        }
        for (int k = 2; k <= n; k++) {
            if (chechPrime[k]) {
                System.out.print(k + "  ");
            }
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter a number :: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPrime(n);
        System.out.println();
        printPrimeOptimized(n);

    }
}
