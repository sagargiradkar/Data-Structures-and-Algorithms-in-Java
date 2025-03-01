import java.util.*;

class NQueen {
    public static ArrayList<ArrayList<Integer>> nQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        solveNQueens(n, 0, board, result);
        return result;
    }

    private static void solveNQueens(int n, int col, ArrayList<Integer> board, ArrayList<ArrayList<Integer>> result) {
        if (col == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int row = 1; row <= n; row++) {
            if (isSafe(row, col, board)) {
                board.add(row);
                solveNQueens(n, col + 1, board, result);
                board.remove(board.size() - 1);
            }
        }
    }

    private static boolean isSafe(int row, int col, ArrayList<Integer> board) {
        for (int c = 0; c < col; c++) {
            int r = board.get(c);
            if (r == row || Math.abs(r - row) == Math.abs(c - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nQueen(3));
    }
}