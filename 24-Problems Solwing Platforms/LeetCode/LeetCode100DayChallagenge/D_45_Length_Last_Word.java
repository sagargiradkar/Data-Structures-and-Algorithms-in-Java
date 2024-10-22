public class D_45_Length_Last_Word {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "Hello World";
        int length = solution.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + length);
    }
}

class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                count++;
            } else if (count != 0) {
                break;
            }
        }

        return count;
    }
}
