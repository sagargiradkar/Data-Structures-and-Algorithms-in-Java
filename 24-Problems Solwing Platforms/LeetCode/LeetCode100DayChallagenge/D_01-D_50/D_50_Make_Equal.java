public class D_50_Make_Equal {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] words = {"abc", "aabc", "bc"};
        System.out.println("Can make equal: " + solution.makeEqual(words));
    }
}

class Solution {
    public boolean makeEqual(String[] words) {
        int[] fre = new int[26];

        for (String w : words) {
            for (char ch : w.toCharArray()) {
                fre[ch - 'a']++;
            }
        }

        for (int count : fre) {
            if (count % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
