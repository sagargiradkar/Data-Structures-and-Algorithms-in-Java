import java.util.ArrayList;
import java.util.Arrays;

public class D_25_Alternate_Sort {
    
    public static ArrayList<Integer> alternateSort(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        
        for (int k = 0; k < n; k++) {
            if (k % 2 == 1) ans.add(arr[i++]);
            else ans.add(arr[j--]);
        }
        
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 7, 1, 6};
        ArrayList<Integer> sortedList = alternateSort(arr);
        
        System.out.println("Alternate Sorted List: " + sortedList);
    }
}