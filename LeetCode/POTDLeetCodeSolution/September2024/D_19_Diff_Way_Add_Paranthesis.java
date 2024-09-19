import java.util.*;

public class D_19_Diff_Way_Add_Paranthesis {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String expression = "2*3-4*5";
        List<Integer> result = solution.diffWaysToCompute(expression);
        System.out.println("Possible results of the expression are: " + result);
    }
}

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] dp = new ArrayList[n][n];
        return recur(expression, 0, n - 1, dp);
    }

    public List<Integer> recur(String exp, int start, int end, List<Integer>[][] dp) {
        List<Integer> res = new ArrayList<>();
        if (dp[start][end] != null) {
            return dp[start][end];
        }
        if (start == end) {
            int num = exp.charAt(start) - '0';
            res.add(num);
            return res;
        }
        if (end - start == 1 && Character.isDigit(exp.charAt(start))) {
            int num1 = exp.charAt(start) - '0';
            int num2 = exp.charAt(end) - '0';
            res.add(num1 * 10 + num2);
            return res;
        }
        for (int i = start; i <= end; i++) {
            if (Character.isDigit(exp.charAt(i))) {
                continue;
            }
            char op = exp.charAt(i);
            List<Integer> left = recur(exp, start, i - 1, dp);
            List<Integer> right = recur(exp, i + 1, end, dp);
            for (int l : left) {
                for (int r : right) {
                    if (op == '*') {
                        res.add(l * r);
                    } else if (op == '+') {
                        res.add(l + r);
                    } else {
                        res.add(l - r);
                    }
                }
            }
        }
        dp[start][end] = res;
        return res;
    }
}
