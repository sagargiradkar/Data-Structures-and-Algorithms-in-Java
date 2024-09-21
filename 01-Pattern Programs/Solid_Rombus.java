public class Solid_Rombus {
    public static void solid_rombus(int n) {
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // stars
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Solid Rhombus");
        solid_rombus(5);
    }
}
