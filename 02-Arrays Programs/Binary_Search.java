import java.util.Arrays;

public class Binary_Search {
    public static int binarySearch(int numbers[], int key) {
        int start = 0;
        int end = numbers.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (numbers[mid] == key) {
                return mid;
            }
            if (numbers[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;  // Key not found
    }

    public static void main(String[] args) {
        int numbers[] = {1, 3, 45, 3, 6, 54, 56, 578, 78, 67, 4};
        int key = 6;

        // Sort the array before applying binary search
        Arrays.sort(numbers);

        int index = binarySearch(numbers, key);
        System.out.println("Sorted Array: " + Arrays.toString(numbers));
        System.out.println("Index for key is: " + index);

        if (index == -1) {
            System.out.println("Key Not Found");
        } else {
            System.out.println("Key Found at index: " + index);
        }
    }
}
