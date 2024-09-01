public class D_03_FibonacciSeries {

    // Method to print Fibonacci series up to n terms
    public static void printFibonacciSeries(int n) {
        if (n <= 0) {
            System.out.println("Number of terms must be positive.");
            return;
        }
        int a = 0, b = 1;
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int next = a + b;
            a = b;
            b = next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10; // Number of terms to display
        printFibonacciSeries(n);
    }
}
