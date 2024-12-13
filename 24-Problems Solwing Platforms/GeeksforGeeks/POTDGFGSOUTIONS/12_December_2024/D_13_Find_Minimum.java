public class D_13_Find_Minimum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum element in the array: " + solution.findMin(arr));
    }
}

class Solution {
    public int findMin(int[] arr) {
        int n = arr.length, low = 0, high = n - 1, mid = 0;
        while (low < high) {
            mid = (low + high) / 2;
            if (arr[mid] <= arr[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return arr[low];
    }
}
