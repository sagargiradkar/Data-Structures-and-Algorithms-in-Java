
public class ST_04_Max_Element {

    static int tree[];

    public static void init(int n) {
        tree = new int[4 * n]; // Initialize the segment tree with size 4 * n
    }

    public static void buildST(int i, int si, int sj, int arr[]) {
        if (si == sj) {
            tree[i] = arr[si];
            return;
        }
        int mid = si + (sj - si) / 2;
        buildST(2 * i + 1, si, mid, arr);
        buildST(2 * i + 2, mid + 1, sj, arr);
        tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }

    public static void main(String[] args) {
        int arr[] = {6, 8, -1, 2, 17, 1, 3, 2, 4};  // Input array
        int n = arr.length;
        init(n);  // Initialize the segment tree
        buildST(0, 0, n - 1, arr);  // Build the segment tree

        for (int i = 0; i < tree.length; i++) {
            System.out.print(tree[i] + " ");
        }
    }

}
