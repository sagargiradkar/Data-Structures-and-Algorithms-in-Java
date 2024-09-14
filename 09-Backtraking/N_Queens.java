public class N_Queens {

    public static boolean isSafe(char[][] board, int row, int col) {
        // Check vertical column
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static void nQueen(char[][] board, int row) {
        // Base case: if all queens are placed
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // Iterate over columns
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                // Place queen
                board[row][col] = 'Q';

                // Recur to place rest of the queens
                nQueen(board, row + 1);

                // Backtrack and remove queen
                board[row][col] = 'X';
            }
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    public static void main(String[] args) {
        int n = 4; // Set n as 4 for this example, but you can change it to any valid size
        char[][] board = new char[n][n];

        // Initialize board with 'X' representing empty spaces
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        // Solve the N-Queens problem
        nQueen(board, 0);
    }
}
