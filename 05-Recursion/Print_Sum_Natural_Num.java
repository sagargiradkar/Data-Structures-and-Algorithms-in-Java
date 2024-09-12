public class Print_Sum_Natural_Num {
    public static int sumofNaturalNum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sumofNaturalNum(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(sumofNaturalNum(5));
    }
}
