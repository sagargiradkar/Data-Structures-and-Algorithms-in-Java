import java.util.ArrayList;

public class SDE_01_Sort012 {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int left = 0;  // Pointer to place 0s
        int mid = 0;   // Pointer to place 1s
        int right = arr.size() - 1; // Pointer to place 2s

        // Traverse the array
        while (mid <= right) {
            if (arr.get(mid) == 0) {
                // Swap arr[left] and arr[mid] and increment left and mid
                int temp = arr.get(left);
                arr.set(left, arr.get(mid));
                arr.set(mid, temp);
                left++;
                mid++;
            } else if (arr.get(mid) == 1) {
                // Just move the mid pointer
                mid++;
            } else {
                // Swap arr[mid] and arr[right] and decrement right
                int temp = arr.get(right);
                arr.set(right, arr.get(mid));
                arr.set(mid, temp);
                right--;
            }
        }
    }
    
    public static void main(String[] args) {
        SDE_01_Sort012 solution = new SDE_01_Sort012();
        ArrayList<Integer> arr = new ArrayList<>();
        
        // Example input
        arr.add(0);
        arr.add(2);
        arr.add(1);
        arr.add(2);
        arr.add(0);

        System.out.println("Original Array: " + arr);
        
        // Sort the array
        solution.sort012(arr);
        
        // Output sorted array
        System.out.println("Sorted Array: " + arr); // Output: [0, 0, 1, 2, 2]
    }
}
