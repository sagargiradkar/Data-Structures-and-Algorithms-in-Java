
//find the sum of first N fibonacci Elements
import java.util.Scanner;

public class D_01_Find_Sum {

    public static int fibonacciSum(int n) {
        // if negative input is given then return 0
        // if n == 1 then also return 0
        if (n <= 0) {
            return 0;
        }
        if (n == 1)
            return 0;
        int a = 0;
        int b = 1;
        int sum = a + b;
        int temp;
        for (int i = 2; i < n; i++) {
            temp = a + b;
            sum = sum + temp;
            a = b;
            b = temp;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        System.out.print("Enter N :: ");
        int n = obj.nextInt();

        System.out.println("Sum of first fibonacci :: " + fibonacciSum(n));

    }
}