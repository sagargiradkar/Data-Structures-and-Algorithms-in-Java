public class D_09_Median_Two_Sorted_Array {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] ans = merge(nums1, nums2);

        if (ans.length % 2 == 0) {
            double ans2 = (double) (ans[ans.length / 2] + ans[ans.length / 2 - 1]) / 2;
            return ans2;
        } else {
            double ans2 = (double) (ans[ans.length / 2]);
            return ans2;
        }
    }

    public static void main(String[] args) {

        // Sample arrays
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        // Find the median
        double median = findMedianSortedArrays(nums1, nums2);

        // Print the median
        System.out.println("The median of the two sorted arrays is: " + median);
    }


    public static int[] merge(int arr1[], int arr2[]) {
        int[] ans = new int[arr1.length + arr2.length];

        int p1 = 0;
        int p2 = 0;
        int p3 = 0;

        while (p1 < arr1.length || p2 < arr2.length) {

            int val1 = p1 < arr1.length ? arr1[p1] : Integer.MAX_VALUE;
            int val2 = p2 < arr2.length ? arr2[p2] : Integer.MAX_VALUE;

            if (val1 < val2) {
                ans[p3] = val1;
                p1++;
            } else {
                ans[p3] = val2;
                p2++;
            }
            p3++;
        }
        return ans;
    }
}