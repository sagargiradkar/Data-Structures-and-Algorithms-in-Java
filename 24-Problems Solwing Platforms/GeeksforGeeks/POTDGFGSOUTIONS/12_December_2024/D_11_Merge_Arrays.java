import java.util.Arrays;

public class D_11_Merge_Arrays {
    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] a = {1, 3, 5, 7};
        int[] b = {2, 4, 6, 8};
        
        System.out.println("Before merging:");
        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));

        solution.mergeArrays(a, b);

        System.out.println("After merging:");
        System.out.println("Array a: " + Arrays.toString(a));
        System.out.println("Array b: " + Arrays.toString(b));
    }
}

class Solution {
    // Function to merge the arrays.
    public void mergeArrays(int a[], int b[]) {
        int n = a.length, m = b.length, i = n - 1, j = 0;
        while (i >= 0 && j < m) {
            if (a[i] <= b[j]) break;
            int temp = a[i];
            a[i--] = b[j];
            b[j++] = temp;
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
