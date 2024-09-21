public class Inverted_Pyramid_Numbers {
    public static void Inverted_Pyramid_Number(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                System.out.print(" " + j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Inverted_Pyramid_Number(10);
    }
}
