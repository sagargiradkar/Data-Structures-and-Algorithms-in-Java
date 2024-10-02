
public class ST_03_Update_On_ST {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n]; // Initialize the segment tree with size 4 * n
    }

    // Build segment tree
    public static int buildST(int arr[], int sti, int start, int end) {
        if (start == end) {
            tree[sti] = arr[start]; // Leaf node will have the value of the array element
            return arr[start];
        }

        int mid = (start + end) / 2; // Calculate mid point
        // Recursively build the left and right subtrees
        buildST(arr, 2 * sti + 1, start, mid);
        buildST(arr, 2 * sti + 2, mid + 1, end);
        // Internal node will be the sum of the left and right subtrees
        tree[sti] = tree[2 * sti + 1] + tree[2 * sti + 2];
        return tree[sti];
    }

    // Utility function for range sum query
    public static int getSumUtil(int i, int si, int sj, int qi, int qj) {
        // Completely outside the range
        if (qj < si || qi > sj) {
            return 0;
        }
        // Complete overlap
        if (qi <= si && sj <= qj) {
            return tree[i];
        }
        // Partial overlap
        int mid = (si + sj) / 2;
        int left = getSumUtil(2 * i + 1, si, mid, qi, qj);
        int right = getSumUtil(2 * i + 2, mid + 1, sj, qi, qj);
        return left + right;
    }

    // Get the sum in the range [qi, qj]
    public static int getSum(int arr[], int qi, int qj) {
        int n = arr.length;
        return getSumUtil(0, 0, n - 1, qi, qj);
    }

    // Utility function for updating the segment tree
    public static void updateUtil(int i, int si, int sj, int idx, int diff) {
        // If the index is out of range, return
        if (idx < si || idx > sj) {
            return;
        }

        // Update the value at the current node
        tree[i] += diff;
        if (si != sj) { // If not a leaf node, propagate the update to children
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, diff);  // Update left child
            updateUtil(2 * i + 2, mid + 1, sj, idx, diff);  // Update right child
        }
    }

    // Update the array and segment tree with new value at index idx
    public static void update(int arr[], int idx, int newVal) {
        int n = arr.length;
        int diff = newVal - arr[idx];  // Calculate the difference
        arr[idx] = newVal;  // Update the array with the new value
        updateUtil(0, 0, n - 1, idx, diff);  // Update the segment tree
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};  // Input array
        int n = arr.length;
        init(n);  // Initialize the segment tree
        buildST(arr, 0, 0, n - 1);  // Build the segment tree

        // Perform range sum query from index 2 to 5
        System.out.println(getSum(arr, 2, 5)); // Output: 18

        // Update index 2 to a new value 2
        update(arr, 2, 2);
        // Perform range sum query from index 2 to 4
        System.out.println(getSum(arr, 2, 5)); // Output: 10
    }
}
