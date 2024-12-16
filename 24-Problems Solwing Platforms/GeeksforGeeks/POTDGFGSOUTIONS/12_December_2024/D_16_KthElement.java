class D_16_KthElement {
    public int kthElement(int a[], int b[], int k) {
        int n = a.length;
        int m = b.length;

        // Ensure that 'a' is the smaller array for efficiency
        if (n > m) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k - m);  // Minimum number of elements from 'a'
        int high = Math.min(k, n);    // Maximum number of elements from 'a'

        while (low <= high) {
            int cutA = (low + high) / 2; // Number of elements taken from 'a'
            int cutB = k - cutA;         // Remaining elements taken from 'b'

            int leftA = cutA == 0 ? Integer.MIN_VALUE : a[cutA - 1];
            int leftB = cutB == 0 ? Integer.MIN_VALUE : b[cutB - 1];
            int rightA = cutA == n ? Integer.MAX_VALUE : a[cutA];
            int rightB = cutB == m ? Integer.MAX_VALUE : b[cutB];

            // Check if this partition is valid
            if (leftA <= rightB && leftB <= rightA) {
                return Math.max(leftA, leftB); // The k-th element is the larger of the two left parts
            } else if (leftA > rightB) {
                high = cutA - 1; // Move the partition in 'a' to the left
            } else {
                low = cutA + 1; // Move the partition in 'a' to the right
            }
        }

        return -1; // Should not reach here
    }

    public static void main(String[] args) {
        D_16_KthElement solution = new D_16_KthElement();

        // Example 1
        int[] a = {2, 3, 6, 7, 9};
        int[] b = {1, 4, 8, 10};
        int k = 5;
        System.out.println("The " + k + "-th element is: " + solution.kthElement(a, b, k)); // Output: 6

        // Example 2
        int[] a2 = {100, 112, 256, 349, 770};
        int[] b2 = {72, 86, 113, 119, 265, 445, 892};
        k = 7;
        System.out.println("The " + k + "-th element is: " + solution.kthElement(a2, b2, k)); // Output: 256
    }
}
