public class D_17_Maximum_Swap {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int num = 2736;  // Example input
        int result = solution.maximumSwap(num);
        System.out.println("Maximum number after swap: " + result);
    }
}

class Solution {
    public int maximumSwap(int num) {
        char numArr[] = Integer.toString(num).toCharArray();
        int n = numArr.length;
        char maxElement = numArr[n - 1];
        int maxIndex = n - 1;
        int swapIdx1 = -1;
        int swapIdx2 = -1;
        
        for (int i = n - 2; i >= 0; i--) {
            if (numArr[i] > maxElement) {
                maxElement = numArr[i];
                maxIndex = i;
            } else if (numArr[i] < maxElement) {
                swapIdx1 = i;
                swapIdx2 = maxIndex;
            }
        }

        // Perform swapping
        if (swapIdx1 != -1) {
            char temp = numArr[swapIdx1];
            numArr[swapIdx1] = numArr[swapIdx2];
            numArr[swapIdx2] = temp;
        }
        
        return Integer.parseInt(new String(numArr));
    }
}
