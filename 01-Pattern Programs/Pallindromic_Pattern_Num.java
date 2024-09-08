class Solution {
    public void pallindromicNumber(int n) {
        System.out.println("Pallindromic Numbers");
        // outer loop
        for (int i = 1; i <= n; i++) {
            // spaces
            for (int j = 1; j <= n - i; j++) {
                System.out.print("  ");
            }
            // pallindrome number
            // descending loop
            for (int j = i; j >= 1; j--) {
                System.out.print(j+" ");
            }
            // ascending
            for (int j = 2; j <= i; j++) {
                System.out.print(j+" ");
            }

            System.out.println();

        }
    }
}

public class Pallindromic_Pattern_Num {
    public static void main(String[] args) {
        Solution obj = new Solution();
        obj.pallindromicNumber(6);
    }
}