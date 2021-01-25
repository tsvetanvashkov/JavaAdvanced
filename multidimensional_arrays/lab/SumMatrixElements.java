package multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] dimentions = Arrays.stream(scan.nextLine().split(",\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int row = dimentions[0];
		int column = dimentions[1];
		int[][] matrix = readMatrix(scan, row, column);
		int sum = sumMatrixElements(matrix);
		System.out.println(row);
		System.out.println(column);
		System.out.println(sum);
		
	}
	
	private static int sumMatrixElements(int[][] matrix) {
		int sum = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				sum += matrix[r][c];
			}
		}
		
		return sum;
	}

	private static int[][] readMatrix(Scanner scan, int row, int colum) {

		int[][] matrix = new int[row][colum];
		for (int i = 0; i < row; i++) {
			matrix[i] = Arrays.stream(scan.nextLine().split(",\\s+"))
							.mapToInt(Integer::parseInt)
							.toArray();
		}
		return matrix;
	}

}
