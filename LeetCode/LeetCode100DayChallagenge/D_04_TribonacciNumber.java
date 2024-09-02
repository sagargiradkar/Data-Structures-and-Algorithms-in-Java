public class D_04_TribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int firstTerm = 0;
            int secondTerm = 1;
            int thirdTerm = 1;

            for (int i = 3; i <= n; i++) {
                int fourthTerm = firstTerm + secondTerm + thirdTerm;

                firstTerm = secondTerm;
                secondTerm = thirdTerm;
                thirdTerm = fourthTerm;
            }

            return thirdTerm; // Return the nth Tribonacci number
        }
    }

    // Main method to test the tribonacci function
    public static void main(String[] args) {
        D_04_TribonacciNumber solution = new D_04_TribonacciNumber();

        // Test with different values of n
        int[] testValues = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        for (int n : testValues) {
            int result = solution.tribonacci(n);
            System.out.println("tribonacci(" + n + ") = " + result);
        }
    }
}
