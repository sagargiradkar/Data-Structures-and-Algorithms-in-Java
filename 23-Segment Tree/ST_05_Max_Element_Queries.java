
public class ST_05_Max_Element_Queries {

    static int tree[];

    // Initialize the segment tree with size 4 * n
    public static void init(int n) {
        tree = new int[4 * n];
    }

    // Build the segment tree
    public static void buildST(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si]; // If it's a leaf node, store the array value
            return;
        }
        int mid = si + (sj - si) / 2;
        // Recursively build the left and right subtrees
        buildST(2 * i + 1, si, mid, arr);
        buildST(2 * i + 2, mid + 1, sj, arr);
        // Internal node will store the maximum of the two children
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    // Utility function to get the maximum in the range [qi, qj]
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        // If the range [qi, qj] is completely outside the segment [si, sj]
        if (qi > sj || qj < si) {
            return Integer.MIN_VALUE; // Return the smallest possible value for non-overlapping ranges
        }
        // If the segment [si, sj] is completely inside the range [qi, qj]
        if (qi <= si && sj <= qj) {
            return tree[i];
        }
        // Partial overlap: Check the left and right subtrees
        int mid = si + (sj - si) / 2;
        int leftMax = getMaxUtil(2 * i + 1, si, mid, qi, qj);
        int rightMax = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
        return Math.max(leftMax, rightMax); // Return the maximum of the left and right subtree queries
    }

    // Function to get the maximum element in the range [qi, qj]
    public static int getMax(int arr[], int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};  // Input array
        int n = arr.length;
        init(n);  // Initialize the segment tree
        buildST(0, 0, n - 1, arr);  // Build the segment tree

        // Perform a range maximum query from index 2 to 5
        System.out.println("Max in range [2, 5]: " + getMax(arr, 2, 5)); // Output: 17
        System.out.println("Max in range [0, 3]: " + getMax(arr, 0, 3)); // Output: 8
        System.out.println("Max in range [4, 8]: " + getMax(arr, 4, 8)); // Output: 17
    }
}
