import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class D_28_Remove_Duplicates {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Example input
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Solution solution = new Solution();
        ArrayList<Integer> result = solution.removeDuplicate(arr);
        
        System.out.println("Array after removing duplicates:");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}

class Solution {
    ArrayList<Integer> removeDuplicate(int arr[]) {
        // Use a LinkedHashSet to remove duplicates and maintain insertion order
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        
        // Add all elements of the array to the set
        for (int num : arr) {
            set.add(num);
        }
        
        // Convert the set back to an ArrayList
        return new ArrayList<>(set);
    }
}
