package com.ransankul.sudoku.uitls;

import java.util.Random;

import com.ransankul.sudoku.model.Move;

public class SudokuBoard {
    private int[][] board;
    private String level;

    public SudokuBoard(String level) {
        board = new int[9][9];
        this.level = level;
        generateBoard();
    }

    private void generateBoard() {
        // Create a valid Sudoku puzzle by randomly filling numbers
        solve();
        removeNumbers();
    }

    private boolean solve() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidMove(row, col, num)) {
                            board[row][col] = num;
                            if (solve()) {
                                return true;
                            }
                            board[row][col] = 0; // Undo the move if the solution is not valid
                        }
                    }
                    return false; // No valid number for this cell
                }
            }
        }
        return true; // Board is solved
    }

    private void removeNumbers() {
        // Remove numbers from the solved board to create a puzzle
        Random random = new Random();
        level = level.toLowerCase();
        int numToRemove;
        switch (level) {
		case "easy":
			numToRemove = 35;
			break;
		case "medium":
			numToRemove = 55;
			break;

		default:numToRemove = 65;
			break;
		}
        
        while (numToRemove > 0) {
            int row = random.nextInt(9);
            int col = random.nextInt(9);
            if (board[row][col] != 0) {
                board[row][col] = 0;
                numToRemove--;
            }
        }
    }


    public void setCell(int row, int col, int value) {
        board[row][col] = value;
    }

    public boolean isValidMove(int row, int col, int value) {
        // Check if the move violates Sudoku rules
        return isValidRow(row, value) && isValidColumn(col, value) && isValidSquare(row, col, value);
    }

    private boolean isValidRow(int row, int value) {
        for (int col = 0; col < 9; col++) {
            if (board[row][col] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidColumn(int col, int value) {
        for (int row = 0; row < 9; row++) {
            if (board[row][col] == value) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidSquare(int row, int col, int value) {
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isSolved() {
        // Check if the Sudoku board is fully filled
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    

    
    public Move getSuggestion() {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValidMove(row, col, num)) {
                            return new Move(row, col, num);
                        }
                    }
                }
            }
        }
        return null;
    }
    
    public void printSudoku() {
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("---------------------");
            }
            for (int j = 0; j < 9; j++) {
                if (j % 3 == 0 && j != 0) {
                    System.out.print("| ");
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}

