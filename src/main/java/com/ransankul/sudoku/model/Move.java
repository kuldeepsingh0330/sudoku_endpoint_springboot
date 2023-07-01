package com.ransankul.sudoku.model;

public class Move {
	

    private int row;
    private int col;
    private int val;
    
	public Move() {
	}    
    
	public Move(int row, int col, int val) {
		super();
		this.row = row;
		this.col = col;
		this.val = val;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	} 
}
