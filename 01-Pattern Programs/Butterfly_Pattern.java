public class Butterfly_Pattern {

    public static void butterfy_Patterns(int n) {
        // 1st half
        for (int i = 1; i <= n; i++) {
            // starts -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces -> 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = n; i >= 1; i--) {
            // starts -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            // spaces -> 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {
                System.out.print("  ");
            }
            // stars -> i
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Butterfly Pattern");
        butterfy_Patterns(5);
    }
}
