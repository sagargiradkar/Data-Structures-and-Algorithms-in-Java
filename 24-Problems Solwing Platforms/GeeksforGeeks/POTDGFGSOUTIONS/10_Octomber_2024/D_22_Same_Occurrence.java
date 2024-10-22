import java.util.HashMap;
import java.util.Scanner;

public class D_22_Same_Occurrence {
    static int sameOccurrence(int arr[], int x, int y) {
        // Create a map to store the difference between count of x and y
        HashMap<Integer, Integer> differenceMap = new HashMap<>();
        
        // Initialize the map with a difference of 0 (before starting the array)
        differenceMap.put(0, 1);
        
        int countX = 0, countY = 0, totalCount = 0;
        int currentDifference = 0;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Increment the counts of x and y based on current element
            if (arr[i] == x) {
                countX++;
            }
            if (arr[i] == y) {
                countY++;
            }
            
            // Calculate the current difference between countX and countY
            currentDifference = countX - countY;

            // If this difference has been seen before, it means we have found
            // some sub-arrays where the count of x and y is equal
            totalCount += differenceMap.getOrDefault(currentDifference, 0);

            // Update the map with the current difference
            differenceMap.put(currentDifference, differenceMap.getOrDefault(currentDifference, 0) + 1);
        }

        return totalCount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();

        // Input the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Input x and y
        System.out.print("Enter the value of x: ");
        int x = scanner.nextInt();
        System.out.print("Enter the value of y: ");
        int y = scanner.nextInt();

        // Calculate and output the result
        int result = sameOccurrence(arr, x, y);
        System.out.println("Number of sub-arrays with equal occurrences of x and y: " + result);

        scanner.close();
    }
}