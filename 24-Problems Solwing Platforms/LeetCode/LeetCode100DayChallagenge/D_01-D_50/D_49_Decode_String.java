import java.util.Stack;

public class D_49_Decode_String {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String encodedString = "3[a2[c]]";
        System.out.println("Decoded String: " + solution.decodeString(encodedString));
    }
}

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberStack = new Stack<>();
        Stack<String> mainStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) { // Identifying if it is a number
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                numberStack.push(num);
            } else if (ch != ']') {
                mainStack.push(Character.toString(ch));
            } else {
                String str = "";
                while (!mainStack.peek().equals("[")) {
                    str = mainStack.pop() + str;
                }
                mainStack.pop();
                int repetitionNumber = numberStack.pop();
                
                StringBuilder sb = new StringBuilder();
                while (repetitionNumber > 0) {
                    sb.append(str);
                    repetitionNumber--;
                }
                mainStack.push(sb.toString());
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!mainStack.isEmpty()) {
            ans.insert(0, mainStack.pop());
        }

        return ans.toString();
    }
}
