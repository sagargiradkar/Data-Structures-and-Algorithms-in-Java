import java.util.ArrayList;
import java.util.Scanner;

public class D_02_Rotate_Update {

    public static int rotateDelete(ArrayList<Integer> arr) {
        int n = arr.size(), temp = n / 2;
        int i = 3 * (temp / 2);
        if (temp % 2 == 1) i++;
        return arr.get(n - i);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        int result = rotateDelete(arr);
        System.out.println("Result: " + result);
    }
}