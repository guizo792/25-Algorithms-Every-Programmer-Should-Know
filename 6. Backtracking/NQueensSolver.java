import java.util.ArrayList;
import java.util.List;

public class NQueensSolver {
  // Function to solve the N-Queens problem and return all solutions
  public List<List<String>> solveNQueens(int n) {
    List<List<String>> solutions = new ArrayList<>();
    char[][] board = new char[n][n];
    initializeBoard(board);

    solve(0, board, solutions);

    return solutions;
  }

  // Initialize the chessboard with empty cells ('.')
  private void initializeBoard(char[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        board[i][j] = '.';
      }
    }
  }

  // Backtracking function to solve the N-Queens problem
  private void solve(int row, char[][] board, List<List<String>> solutions) {
    if (row == board.length) {
      solutions.add(boardToList(board));
      return;
    }

    for (int col = 0; col < board[0].length; col++) {
      if (isSafe(board, row, col)) {
        board[row][col] = 'Q';
        solve(row + 1, board, solutions);
        board[row][col] = '.';
      }
    }
  }

  // Check if it's safe to place a queen at a given position
  private boolean isSafe(char[][] board, int row, int col) {
    // Check the column
    for (int i = 0; i < row; i++) {
      if (board[i][col] == 'Q') {
        return false;
      }
    }

    // Check the left diagonal
    for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    // Check the right diagonal
    for (int i = row, j = col; i >= 0 && j < board[0].length; i--, j++) {
      if (board[i][j] == 'Q') {
        return false;
      }
    }

    return true;
  }

  // Convert the board to a list of strings for a solution
  private List<String> boardToList(char[][] board) {
    List<String> solution = new ArrayList<>();
    for (char[] row : board) {
      solution.add(new String(row));
    }
    return solution;
  }

  public static void main(String[] args) {
    NQueensSolver solver = new NQueensSolver();
    int n = 4;
    List<List<String>> solutions = solver.solveNQueens(n);

    // Print the solutions
    for (List<String> solution : solutions) {
      for (String row : solution) {
        System.out.println(row);
      }
      System.out.println();
    }
  }
}
