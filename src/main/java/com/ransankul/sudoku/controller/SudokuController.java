package com.ransankul.sudoku.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ransankul.sudoku.model.Move;
import com.ransankul.sudoku.model.MoveRequest;
import com.ransankul.sudoku.uitls.SudokuBoard;


@RestController
@RequestMapping("/sudoku")
public class SudokuController {
    private SudokuBoard sudokuBoard;
    private int consecutiveInvalidMoves;


    @PostMapping("/start")
    public String startGame(@RequestParam(name = "leval", required = false) String level) {
    	if(level == null) level = "easy";
        sudokuBoard = new SudokuBoard(level);

        sudokuBoard.printSudoku();
        consecutiveInvalidMoves = 0;
        return "READY";
    }

    @PostMapping("/move")
    public String makeMove(@RequestBody MoveRequest move) {
        int row = move.getRow();
        int col = move.getCol();
        int value = move.getValue();
        
     
        if (sudokuBoard.isValidMove(row, col, value)) {
            sudokuBoard.setCell(row, col, value);
            consecutiveInvalidMoves = 0;
            sudokuBoard.printSudoku();
            return "Valid";
        } else {
            consecutiveInvalidMoves++;
            if (consecutiveInvalidMoves >= 3) {
                Move suggestion = sudokuBoard.getSuggestion();
                return "Invalid. "
                		+ "Suggestion " +"ROW "+suggestion.getRow() + ", " +"COLUM "+suggestion.getCol() + ", " +"VALUE "+suggestion.getVal();
            } else {
                return "Invalid";
            }
        }
    }
}
