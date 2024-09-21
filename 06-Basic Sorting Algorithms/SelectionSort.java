public class SelectionSort {

    public static void selectionSore(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            // swap
            int temp = arr[i];
            arr[i] = arr[minPos];
            arr[minPos] = temp;
        }
    }

    public static void display(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void main(String[] args) {
        int arr[] = { 34, 325, 634, 452, 33 };
        selectionSore(arr);
        display(arr);
    }
}
