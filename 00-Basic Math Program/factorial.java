
public class factorial {
    public static void main(String[] args) {
        int n = 5;
        int f = 1;

        while (n >= 1) {
            f = f * n;
            n = n - 1;
        }
        System.out.println(f);
    }
}
