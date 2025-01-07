// D_07_Count_Pairs.java
public class D_07_Count_Pairs {
    public static void main(String[] args) {
        // Example usage
        Solution solution = new Solution();
        int[] arr = {1, 1, 2, 2, 3, 3, 4, 4};
        int target = 6;
        int result = solution.countPairs(arr, target);
        System.out.println("Number of pairs with sum equal to target: " + result);
    }
}

// User function Template for Java
class Solution {
    int countPairs(int arr[], int target) {
        // Complete the function
        int i = 0, j = arr.length - 1, ans = 0;
        
        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum == target) {
                if (arr[i] == arr[j]) {
                    int temp = j - i;
                    ans += (temp * (temp + 1)) / 2;
                    break;
                } else {
                    int right = 1, left = 1;
                    while (i < j && arr[i] == arr[i + 1]) {
                        left++;
                        i++;
                    }
                    while (i < j && arr[j] == arr[j - 1]) {
                        right++;
                        j--;
                    }
                    ans += (left * right);
                    i++;
                    j--;
                }
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return ans;
    }
}
