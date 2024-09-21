import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of array :: ");
        int n = sc.nextInt();
        System.out.println("Enter the elemeny of array");
        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the elemet " + i + 1 + " ::");
            array[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (array[j] < array[j + 1]) {
                    // swap
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.println("Array after sorting the elements ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
