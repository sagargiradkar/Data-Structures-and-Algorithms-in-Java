
import java.util.Scanner;

public class Creation_Of_Array {
    public static void main(String[] args) {
        int marks[] = new int[10];
        int number[] = { 1, 2, 3, 4, 5 };
        int moreNubers[] = { 2, 5, 7, 5, 8, 5 };
        String fruits[] = { "apple", "bannana", "mango", "orange" };

        int mark[] = new int[100];

        Scanner sc = new Scanner(System.in);
        // int phy;
        // phy = sc.nextInt();

        mark[0] = sc.nextInt();
        mark[1] = sc.nextInt();
        mark[2] = sc.nextInt();

        System.out.println("Phy : " + mark[0]);
        System.out.println("Math : " + mark[1]);
        System.out.println("Chem : " + mark[2]);

        mark[2] = 99;
        System.out.println("Chem : " + mark[2]);
        System.out.println("Array Length :: " + mark.length);
        int percentage = (mark[0] + mark[1] + mark[2]) / 3;
        System.out.println("Percentage = " + percentage);

    }
}
