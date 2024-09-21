public class Hollow_Rhombus {
    public static void hollow_rhombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // hollow rectangle
            for (int j = 1; j <= n; j++) {
                if (j == 1 || j == n || i == 1 || i == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hollow Rhombus");
        hollow_rhombus(10);
    }
}
