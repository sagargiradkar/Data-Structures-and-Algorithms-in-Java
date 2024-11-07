import java.util.ArrayList;
import java.util.List;

public class D_07_Find_Partition_Index {

    public static List<Integer> findPartitionIndex(int[] arr) {
        int n = arr.length, sum = 0;
        List<Integer> ans = new ArrayList<>();
        for (int x : arr) sum += x;
        
        if (sum % 3 != 0) {
            ans.add(-1);
            ans.add(-1);
            return ans;
        }
        
        int requiredSum = sum / 3;
        sum = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == requiredSum) {
                ans.add(i);
                if (ans.size() == 2) break;
                sum = 0;
            }
        }
        
        if (ans.size() == 2) return ans;
        
        ans.clear();
        ans.add(-1);
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 3}; // example array
        List<Integer> result = findPartitionIndex(arr);
        System.out.println("Partition indexes: " + result);
    }
}