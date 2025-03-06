import java.util.Scanner;

public class D_05_Sum_Cube_In_Range {

    public static int sumofCube(int lower, int upper) {
        int sum = 0;
        for (int i = lower; i <= upper; i++) {
            sum += i * i * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.print("Enter the lower limit :: ");
        Scanner sc = new Scanner(System.in);
        int lower = sc.nextInt();

        System.out.print("Enter Upper Limit :: ");
        int upper = sc.nextInt();
        System.out.println("Sum of cube :: " + sumofCube(lower, upper));

    }
}
