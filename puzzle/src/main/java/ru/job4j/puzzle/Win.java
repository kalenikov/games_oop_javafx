package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == 1) {
                return monoHorizontal(board, i) || monoVertical(board, i);
            }
        }
        return false;
    }

    private static boolean monoHorizontal(int[][] board, int row) {
        for (int el : board[row]) {
            if (el != 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean monoVertical(int[][] board, int column) {
        for (int[] row : board) {
            if (row[column] != 1) {
                return false;
            }
        }
        return true;
    }
}
