
public class SolidSquare {
    public static void main(String[] args) {
        int n;
        n = 5;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
