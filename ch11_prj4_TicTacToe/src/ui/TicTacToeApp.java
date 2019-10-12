package ui;

import util.Console;

public class TicTacToeApp {
	private static String [][] grid = new String[3][3];

	public static void main(String[] args) {
		// Reset the grid
		resetGrid();
		// Display the grid
		displayGrid();
		
		String winner = " ";
		int turn = 1;
		
		while (winner.equals(" ")) {
			boolean isValid = false;
			int row = 0;
			int col = 0;
			// play until all spaces filled
			boolean gridFilled = false;
			// see alternateplayerapp - alternate between 1 and 2
			String token = "";
//			while (!gridFilled) {
				if (turn % 2==0) { // even turn - O's
					token = "O";
				}
				else {
					token = "X";
				}
				// Player 1 (X) Turn
				while (!isValid) {
					System.out.println(token+"'s Turn:");
					row = Console.getInt("Pick a row (1,2,3): ",0,4);
					col = Console.getInt("Pick a column (1,2,3): ",0,4);
					row--;
					col--;
					if (grid[row][col] != " ") {
						// position taken
						System.out.println("Position taken.  Try again");
					}
					else {
						grid[row][col] = token;
						isValid = true;
					}
				}
				displayGrid();
				// is grid full?
				//gridFilled = isGridFull();
				isValid = false;
				//System.out.println("gridFilled="+gridFilled);
				turn++;
				winner = checkForWinner();
				System.out.println("winner = '"+winner+"'.");
//			}
			
		}
		System.out.println(winner+" wins!!!");
		System.out.println("Thanks for playing!");

	}

	private static boolean isGridFull() {
		// grid is full when count == 9
		int count = 0;
		for (int row=0; row < grid.length; row++) {
			for (int col=0; col < grid[row].length; col++) {
				if (!grid[row][col].equalsIgnoreCase(" ")) {
					//position occupied
					count++;
				}
			}
		}
		System.out.println("grid count = "+count);
		return (count == 9);
	}
	
	private static String checkForWinner() {
		String winner = " ";
		// 4 ways to win:
		// 1 - 3 in a row
		for (int row = 0; row < grid.length; row++) {
			if ((grid[row][0]).equals(grid[row][1])&&
				(grid[row][1]).equals(grid[row][2])) {
				// row winner
				winner = grid[row][0];
				return winner;
			}
		}
		// 2 - 3 in a column
		for (int col = 0; col < grid.length; col++) {
			if ((grid[0][col]).equals(grid[1][col])&&
				(grid[1][col]).equals(grid[2][col])) {
				// column winner
				winner = grid[0][col];
				return winner;
			}
		}
		// 3 - diagonal (backslash pattern)
		if ((grid[0][0]).equals(grid[1][1])&&
			(grid[1][1]).equals(grid[2][2])) {
			// row winner
			winner = grid[0][0];
			return winner;
		}

		// 4 - diagonal (forward slash pattern)
		if ((grid[0][2]).equals(grid[1][1])&&
			(grid[1][1]).equals(grid[2][0])) {
			// row winner
			winner = grid[0][2];
			return winner;
		}
		return winner;
	}

	private static void displayGrid() {
		// Display the grid
		String gridStr = "";
		// header
		String hdr = "   1   2   3  ";
		gridStr+=hdr+"\n";
		// 1st separator row
		String rowStr = " +";
		rowStr += getGridSeparator();
		gridStr+=rowStr;
		rowStr = "";
		// print each row (row + separator)
		for (int row=0; row < grid.length; row++) {
			int gridRowNbr = row + 1;
			rowStr += gridRowNbr+"|";
			rowStr += getGridRow(row);
			gridStr+=rowStr;
			rowStr = "";
		}
		System.out.println(gridStr);
	}
	
	private static String getGridSeparator() {
		String rowStr = "";
		for (int columns = 0; columns<grid[1].length; columns++) {
			rowStr+="---+";
		}
		rowStr+="\n";
		return rowStr;
	}

	private static String getGridRow(int rowNbr) {
		String rowStr = "";
		// row data
		for (int colNbr = 0; colNbr < grid[rowNbr].length; colNbr++) {
			rowStr+=" "+grid[rowNbr][colNbr]+" |";
		}
		// row separator
		rowStr+="\n +";
		for (int columns = 0; columns<grid[1].length; columns++) {
			rowStr+="---+";
		}
		rowStr+="\n";
		return rowStr;
	}
	
	private static void resetGrid() {
		for (int rows = 0; rows<grid.length; rows++) {
			for (int cols = 0; cols<grid[rows].length; cols++) {
				grid[rows][cols] = " ";
			}
		}
	}
}
