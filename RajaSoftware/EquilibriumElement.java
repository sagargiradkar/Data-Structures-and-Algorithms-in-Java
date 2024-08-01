public class EquilibriumElement {
    public static int findEquilibriumElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum -= arr[i];  // totalSum is now the right sum for index i

            if (leftSum == totalSum) {
                return arr[i];
            }

            leftSum += arr[i];
        }

        return 0;  // No equilibrium element found
    }

    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 7, 5, 2, 6};
        System.out.println(findEquilibriumElement(arr1));  // Output: 5

        int[] arr2 = {10, 1, 1, 9};
        System.out.println(findEquilibriumElement(arr2));  // Output: 1

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(findEquilibriumElement(arr3));  // Output: 0 (no equilibrium element)
    }
}
