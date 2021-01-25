package multidimensional_arrays.lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurments {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = readMatrix(scan);
		int wrongValue = getWrongValue(scan, matrix);
		ArrayList<int[]> fixedValues = new ArrayList<>();
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == wrongValue) {
					int realValue = calculateRealValue(matrix, row, column, wrongValue);
					fixedValues.add(new int[] {row, column, realValue});
				}
			}
		}
		for (int[] is : fixedValues) {
			matrix[is[0]][is[1]] = is[2];
		}
		printMatrix(matrix);

	}
	
	private static void printMatrix(int[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c]);
				if (c < matrix[r].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}

	private static int calculateRealValue(int[][] matrix, int row, int column, int wrongValue) {
		int realValue = 0;
		if (isInBound(matrix, row + 1, column) && (matrix[row+1][column] != wrongValue)) {
			realValue += matrix[row+1][column];
		}
		if (isInBound(matrix, row - 1, column) && (matrix[row-1][column] != wrongValue)) {
			realValue += matrix[row-1][column];
		}
		if (isInBound(matrix, row, column + 1) && (matrix[row][column+1] != wrongValue)) {
			realValue += matrix[row][column+1];
		}
		if (isInBound(matrix, row, column - 1) && (matrix[row][column-1] != wrongValue)) {
			realValue += matrix[row][column-1];
		}
		return realValue;
	}

	private static boolean isInBound(int[][] matrix, int r, int c) {
		if (r < matrix.length && r >= 0 && c < matrix[r].length && c >= 0) {
			return true;
		}else {
			return false;
		}
		
	}

	private static int getWrongValue(Scanner scan, int[][] matrix) {
		int[] dimentions = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int row = dimentions[0];
		int column = dimentions[1];
		int output = matrix[row][column];
		return output;
	}

	private static int[][] readMatrix(Scanner scan) {
		
		int row = Integer.parseInt(scan.nextLine());

		int[][] matrix = new int[row][];
		for (int i = 0; i < row; i++) {
			matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
							.mapToInt(Integer::parseInt)
							.toArray();
		}
		return matrix;
	}

}
