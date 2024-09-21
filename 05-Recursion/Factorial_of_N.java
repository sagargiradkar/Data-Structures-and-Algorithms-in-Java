public class Factorial_of_N {
    public static int factorial(int n) {

        if (n == 0) {
            return 1;
        }
        int fnm1 = factorial(n - 1);
        int fn = n * factorial(n - 1);
        return fn;

    }

    public static void main(String[] args) {
        int n = 5;
        int fact = factorial(n);
        System.out.println("facctorial of " + n + " is :: " + fact);
    }
}
