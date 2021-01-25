package multidimensional_arrays.lab;

import java.util.Scanner;

public class FindTheRealQueen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[][] matrix = readMatrix(scan);
		findQueen(matrix);

	}
	
	private static void findQueen(char[][] matrix) {
		boolean isReal = false;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				if (matrix[r][c] == 'q') {
					isReal = realQueen(matrix, r, c);
					if (isReal) {
						System.out.printf("%d %d\n", r, c);
						isReal = false;
					}
				}
			}
		}
		
	}

	private static boolean realQueen(char[][] matrix, int row, int column) {
		if (checkRow(matrix, row, column) || checkColumn(matrix, row, column) ||
				chackFirstDiagonals(matrix, row, column) || chackSecondDiagonals(matrix, row, column)) {
			return false;
		}else {
			return true;
		}

	}

	private static boolean chackSecondDiagonals(char[][] matrix, int row, int column) {
		int secondDiagonalStartRow = matrix.length - 1;
		int secondDiagonalStartColumn = matrix.length - 1;
		if ((row + column) <= (matrix.length - 1)) {
			secondDiagonalStartRow = row + column;
			for (int i = secondDiagonalStartRow, k1 = secondDiagonalStartColumn; i <= 0; i--, k1++) {
				if (i == row && k1 == column) {
					continue;
				}else {
					if (matrix[i][k1] == 'q') {
						return true;
					}
				}
			}
		}else {
			secondDiagonalStartColumn = (row + column) - (matrix.length - 1);
			for (int j = secondDiagonalStartRow, k2 = secondDiagonalStartColumn; k2 < matrix[row].length; j--, k2++) {
				if (j == row && k2 == column) {
					continue;
				}else {
					if (matrix[j][k2] == 'q') {
						return true;
					}
				}
			}
		}
		return false;
	}

	private static boolean chackFirstDiagonals(char[][] matrix, int row, int column) {
		int firstDiagonalStartRow = 0;
		int firstDiagonalStartColumn = 0;
		if ((row - column) >= 0) {
			firstDiagonalStartRow = row - column;
			for (int i = firstDiagonalStartRow, k1 = firstDiagonalStartColumn; i < matrix.length; i++, k1++) {
				if (i == row && k1 == column) {
					continue;
				}else {
					if (matrix[i][k1] == 'q') {
						return true;
					}
				}
			}
		}else {
			firstDiagonalStartColumn = column - row;
			for (int j = firstDiagonalStartRow, k2 = firstDiagonalStartColumn; k2 < matrix[row].length; j++, k2++) {
				if (j == row && k2 == column) {
					continue;
				}else {
					if (matrix[j][k2] == 'q') {
						return true;
					}
				}
			}
		}

		return false;
	}

	private static boolean checkColumn(char[][] matrix, int row, int column) {
		for (int i = 0; i < matrix[row].length; i++) {
			if (i == column) {
				continue;
			}else {
				if (matrix[row][i] == 'q') {
					return true;
				}
			}
		}
		return false;
		
	}

	private static boolean checkRow(char[][] matrix, int row, int column) {
		for (int i = 0; i < matrix.length; i++) {
			if (i == row) {
				continue;
			}else {
				if (matrix[i][column] == 'q') {
					return true;
				}
			}
		}
		return false;
		
	}

	private static char[][] readMatrix(Scanner scan) {
		char[][] matrix = new char[8][8];
		for (int i = 0; i < 8; i++) {
			matrix[i] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
		}
		return matrix;
	}

}
