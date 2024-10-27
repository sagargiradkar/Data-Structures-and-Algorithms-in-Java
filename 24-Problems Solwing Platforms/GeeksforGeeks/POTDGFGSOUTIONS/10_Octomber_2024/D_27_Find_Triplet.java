import java.util.Arrays;

public class D_27_Find_Triplet {

    public boolean findTriplet(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        Arrays.sort(arr);
        for (int i = n - 1; i >= 2; i--) {
            int j = i - 1, k = 0;
            while (k < j) {
                int sum = arr[k] + arr[j];
                if (sum == arr[i]) return true;
                else if (sum < arr[i]) k++;
                else j--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        D_27_Find_Triplet obj = new D_27_Find_Triplet();
        
        int[] arr1 = {3, 1, 4, 6, 5};
        int[] arr2 = {1, 2, 3, 5};
        
        System.out.println("Test Case 1: " + obj.findTriplet(arr1));  // Expected: true (3 + 4 = 7)
        System.out.println("Test Case 2: " + obj.findTriplet(arr2));  // Expected: false (no such triplet)
    }
}