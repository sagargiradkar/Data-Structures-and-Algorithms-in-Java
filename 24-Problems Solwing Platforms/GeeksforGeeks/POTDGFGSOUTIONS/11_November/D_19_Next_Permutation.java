class D_19_Next_Permutation {

    static void reverse(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    static void nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int index = -1;
        for (int i = n - 1; i >= 1; i--) {
            if (arr[i - 1] < arr[i]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            reverse(arr, 0, n - 1);
            return;
        }
        for (int i = n - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }
        reverse(arr, index + 1, n - 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        nextPermutation(arr);
        System.out.println("Next permutation: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}