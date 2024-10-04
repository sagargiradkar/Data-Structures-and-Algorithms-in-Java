import java.util.ArrayList;
import java.util.Scanner;

public class D_09_Sort_0s_1s_and_2s {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int zeros = 0, ones = 0;
        
        // Count the number of 0s and 1s
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) 
                zeros++;
            else if (arr.get(i) == 1) 
                ones++;
        }
        
        // Place 0s, 1s, and 2s in the array based on the counts
        for (int i = 0; i < arr.size(); i++) {
            if (zeros > 0) {
                arr.set(i, 0); // Use arr.set() for ArrayList
                zeros--;
            } else if (ones > 0) {
                arr.set(i, 1);
                ones--;
            } else {
                arr.set(i, 2);
            }
        }
    }

    public static void main(String[] args) {
        // Create an object of the class to access the sort012 function
        D_09_Sort_0s_1s_and_2s sorter = new D_09_Sort_0s_1s_and_2s();

        // Input from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements: ");
        int n = sc.nextInt();
        
        ArrayList<Integer> arr = new ArrayList<>();
        
        System.out.println("Enter the elements (0s, 1s, 2s): ");
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        
        // Call the sort012 function
        sorter.sort012(arr);
        
        // Output the sorted array
        System.out.println("Sorted array: " + arr);
    }
}
