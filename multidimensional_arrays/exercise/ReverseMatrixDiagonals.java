package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = readMatrix(scan);
		matrix = reverseMatrix(matrix);
		getDiagonals(matrix);
		

	}
	
	private static void getDiagonals(int[][] matrix) {
		int row = 0;
		int column = 0;
		while (row < (matrix.length - 1)) {
			print(matrix, row, column);
			System.out.println();
			row++;
		}
		while (column < matrix[row].length) {
			print(matrix, row, column);
			System.out.println();
			column++;
		}
		
	}

	private static void print(int[][] matrix, int row, int column) {
		while (row >= 0 && column < matrix[row].length) {
			System.out.print(matrix[row--][column++]);
			System.out.print(" ");
		}
		
	}

	private static int[][] reverseMatrix(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		int[][] reverse = new int[column][row];
		for (int r = 0, k1 = (row - 1); r < reverse[0].length; r++, k1--) {
			for (int c = 0, k2 = (column - 1); c < reverse.length; c++, k2--) {
				reverse[c][r] = matrix[k1][k2];
			}
		}
		return reverse;
	}

	private static int[][] readMatrix(Scanner scan) {
		int[] dimentions = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int row = dimentions[0];
		int column = dimentions[1];

		int[][] matrix = new int[row][column];
		for (int i = 0; i < row; i++) {
			matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
							.mapToInt(Integer::parseInt)
							.toArray();
		}
		return matrix;
	}

}
