package com.codingchallenges.leetcode;

// https://leetcode.com/problems/game-of-life/
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int[][] newBoard = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newBoard[i][j] = evaluateLife(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = newBoard[i][j];
            }
        }

    }

    public int evaluateLife(int[][] board, int targetLine, int targetColumn) {
        int liveNeighborCount = 0;

        for (int i = targetLine - 1; i < targetLine + 2; i++) {
            for (int j = targetColumn - 1; j < targetColumn + 2; j++) {
                if (i == targetLine && j == targetColumn) continue;

                if (i < 0 || j < 0 || i > board.length - 1 || j > board[i].length - 1) continue;

                if (board[i][j] > 0) liveNeighborCount++;
            }
        }

        if (board[targetLine][targetColumn] >= 1 && (liveNeighborCount < 2 || liveNeighborCount > 3)) return 0;
        if (board[targetLine][targetColumn] <= 0 && liveNeighborCount == 3) return 1;

        return board[targetLine][targetColumn];
    }
}
