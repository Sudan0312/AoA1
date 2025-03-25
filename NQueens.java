public class NQueens {
    static final int N = 4;
    
    // Function to check if two queens threaten each other
    static boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }
        // Check `\` diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // Check `/` diagonal
        for (int i = row, j = col; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    
    // Function to print the board
    static void printSolution(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    // Recursive function to solve the N-Queens problem
    static void solveNQueens(char[][] board, int row) {
        if (row == N) {
            printSolution(board);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (isSafe(board, row, i)) {
                board[row][i] = 'Q'; // Place the queen
                solveNQueens(board, row + 1); // Recur for next row
                board[row][i] = '-'; // Backtrack
            }
        }
    }
    
    public static void main(String[] args) {
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = '-';
            }
        }
        solveNQueens(board, 0);
    }
}