public class Find_Subset_StringBuilder {
    public static void findSubset(String str, StringBuilder ans, int i) {
        // base case
        if (i == str.length()) {
            if (ans.length() == 0) {
                System.out.println("null");
            } else {
                System.out.println(ans.toString());
            }
            return;
        }

        // Yes choice: include the current character
        ans.append(str.charAt(i));
        findSubset(str, ans, i + 1);

        // Backtrack: remove the last character (undo choice)
        ans.deleteCharAt(ans.length() - 1);

        // No choice: skip the current character
        findSubset(str, ans, i + 1);
    }

    public static void main(String[] args) {
        String str = "abc";
        findSubset(str, new StringBuilder(), 0);
    }
}
