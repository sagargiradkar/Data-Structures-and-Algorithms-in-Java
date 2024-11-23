public class D_23_Rotating_The_Box {
    public static void main(String[] args) {
        // Sample input
        char[][] box = {
            {'#', '.', '*', '.'},
            {'#', '#', '*', '.'}
        };

        // Create an instance of Solution
        Solution solution = new Solution();

        // Get the result and print the rotated box
        char[][] rotatedBox = solution.rotateTheBox(box);

        // Print the output
        for (char[] row : rotatedBox) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;    // Number of rows
        int n = box[0].length; // Number of columns
        
        // Simulate gravity for each row
        for (int i = 0; i < m; i++) {
            int emptyIndex = n - 1; // Start from the rightmost column
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '*') {
                    // Reset emptyIndex when hitting an obstacle
                    emptyIndex = j - 1;
                } else if (box[i][j] == '#') {
                    // Move the stone to the empty position
                    box[i][j] = '.';
                    box[i][emptyIndex] = '#';
                    emptyIndex--;
                }
            }
        }

        // Create the rotated box
        char[][] rotatedBox = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - 1 - i] = box[i][j];
            }
        }

        return rotatedBox;
    }
}
