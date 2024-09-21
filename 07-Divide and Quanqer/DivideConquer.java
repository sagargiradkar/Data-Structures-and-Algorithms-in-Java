public class DivideConquer {
    public static int search(int arr[], int tar, int si, int ei) {
        if (si > ei) {
            return -1;
        }

        // kaam
        int mid = si + (ei - si) / 2;

        // case Found
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case a
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                // case b: right
                return search(arr, tar, mid + 1, ei);
            }
        }

        // mid on L2
        else {
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                return search(arr, tar, si, mid - 1);
            }
        }

    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 7, 6, 0, 1, 2 };
        int target = 2;// output
        int targetIndx = search(arr, target, 0, arr.length - 1);
        System.out.println(targetIndx);
    }
}
