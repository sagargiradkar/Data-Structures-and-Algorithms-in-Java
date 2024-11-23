public class D_09_Minimum_Array_End {
    public long minEnd(int n, int x) {
        long num = x;

        for (int i = 1; i < n; i++) {
            // Increment num and perform bitwise OR with x
            num = (num + 1) | x;
        }

        return num;
    }

    public static void main(String[] args) {
        D_09_Minimum_Array_End solution = new D_09_Minimum_Array_End();

        int n = 3;  // Example input for n
        int x = 4;  // Example input for x

        long result = solution.minEnd(n, x);
        System.out.println("Minimum possible value of nums[n - 1]: " + result);
    }
}
