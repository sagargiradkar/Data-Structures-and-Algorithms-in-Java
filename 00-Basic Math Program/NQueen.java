/*
Problem Statement:
The N-Queens problem requires placing `n` queens on an `n x n` chessboard 
such that no two queens attack each other. A queen can attack another queen 
if they are in the same row, same column, or diagonally aligned.
The task is to return all possible arrangements of `n` queens on the board.

Time Complexity Analysis:
- Since we are placing `n` queens one by one, and each queen has at most `n` choices, 
  the worst-case complexity is **O(n!)**.
- Space complexity is **O(n^2)** due to storing board configurations in a list.

Test Cases:
Test case 1: n = 1 → Expected output: [[1]]
Test case 2: n = 2 → Expected output: []
Test case 3: n = 3 → Expected output: []
Test case 4: n = 4 → Expected output: [[2, 4, 1, 3], [3, 1, 4, 2]]
Test case 5: n = 5 → Expected output: [[1, 3, 5, 2, 4], ...] (10 solutions)
*/

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

    // Optimized version using HashSet for faster conflict checks
    public static ArrayList<ArrayList<Integer>> optimizedNQueen(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> board = new ArrayList<>();
        HashSet<Integer> occupiedRows = new HashSet<>();
        HashSet<Integer> occupiedDiagonals1 = new HashSet<>();
        HashSet<Integer> occupiedDiagonals2 = new HashSet<>();
        solveNQueensOptimized(n, 0, board, result, occupiedRows, occupiedDiagonals1, occupiedDiagonals2);
        return result;
    }

    private static void solveNQueensOptimized(int n, int col, ArrayList<Integer> board, ArrayList<ArrayList<Integer>> result,
                                              HashSet<Integer> occupiedRows, HashSet<Integer> occupiedDiagonals1, HashSet<Integer> occupiedDiagonals2) {
        if (col == n) {
            result.add(new ArrayList<>(board));
            return;
        }

        for (int row = 1; row <= n; row++) {
            int diag1 = col - row;
            int diag2 = col + row;

            if (!occupiedRows.contains(row) && !occupiedDiagonals1.contains(diag1) && !occupiedDiagonals2.contains(diag2)) {
                board.add(row);
                occupiedRows.add(row);
                occupiedDiagonals1.add(diag1);
                occupiedDiagonals2.add(diag2);

                solveNQueensOptimized(n, col + 1, board, result, occupiedRows, occupiedDiagonals1, occupiedDiagonals2);

                board.remove(board.size() - 1);
                occupiedRows.remove(row);
                occupiedDiagonals1.remove(diag1);
                occupiedDiagonals2.remove(diag2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Test case 1: n = 1");
        System.out.println(nQueen(1)); // Expected output: [[1]]

        System.out.println("Test case 2: n = 2");
        System.out.println(nQueen(2)); // Expected output: []

        System.out.println("Test case 3: n = 3");
        System.out.println(nQueen(3)); // Expected output: []

        System.out.println("Test case 4: n = 4");
        System.out.println(nQueen(4)); // Expected output: [[2, 4, 1, 3], [3, 1, 4, 2]]

        System.out.println("Test case 5: n = 5");
        System.out.println(optimizedNQueen(5)); // Expected output: 10 valid solutions
    }
}

/*
Optimized Code Explanation:
- Instead of checking row and diagonal conflicts using `isSafe()`, we use HashSet for O(1) lookup.
- `occupiedRows` ensures no two queens are in the same row.
- `occupiedDiagonals1` checks `col - row` to detect major diagonal conflicts.
- `occupiedDiagonals2` checks `col + row` to detect minor diagonal conflicts.
- This reduces unnecessary computations and speeds up the backtracking approach.
*/
