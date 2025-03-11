import java.util.Scanner;

class D_09_Wall_Painting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int interior, exterior;
        float intPrice = 18, extPrice = 12, cost = 0, temp;

        System.out.print("Enter number of Interior Walls: ");
        interior = sc.nextInt();
        System.out.print("Enter number of Exterior Walls: ");
        exterior = sc.nextInt();

        if (interior < 0 || exterior < 0) {
            System.out.println("Invalid Input");
        } else if (interior == 0 && exterior == 0) {
            System.out.println("Total Estimated Cost: 0.0 INR");
        } else {
            for (int i = 0; i < interior; i++) {
                temp = sc.nextFloat();
                cost += intPrice * temp;
            }
            for (int i = 0; i < exterior; i++) {
                temp = sc.nextFloat();
                cost += extPrice * temp;
            }
            System.out.printf("Total Estimated Cost: %.1f INR\n", cost);
        }
        
        sc.close(); // Closing Scanner to prevent resource leaks
    }
}
