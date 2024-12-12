public class D_12_Count_Frequency {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        System.out.println("Frequency of " + target + ": " + solution.countFreq(arr, target));
    }
}

class Solution {
    int countFreq(int[] arr, int target) {
        int n = arr.length, low = 0, mid = 0, high = n - 1, firstIndex = -1, lastIndex = -1;
        
        for (int i = 0; i < 2; i++) {
            low = 0;
            high = n - 1;
            while (low <= high) {
                mid = (low + high) / 2;
                if (arr[mid] == target) {
                    if (i == 0) {
                        firstIndex = mid;
                        high = mid - 1;
                    } else {
                        lastIndex = mid;
                        low = mid + 1;
                    }
                } else if (arr[mid] > target) high = mid - 1;
                else low = mid + 1;
            }
        }
        
        if (firstIndex == -1) return 0;
        return lastIndex - firstIndex + 1;
    }
}
