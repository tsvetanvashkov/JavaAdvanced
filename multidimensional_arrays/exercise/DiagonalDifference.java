package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = readMatrix(scan);
		int difference = Math.abs(firstDiagonal(matrix) - secondDiagonal(matrix));
		System.out.println(difference);
		
	}

	private static int secondDiagonal(int[][] matrix) {
		int row = (matrix.length - 1);
		int column = 0;
		int sum = 0;
		while ((row >= 0) && (column < matrix.length)) {
			sum += matrix[row--][column++];
		}
		return sum;
	}

	private static int firstDiagonal(int[][] matrix) {
		int row = 0;
		int column = 0;
		int sum = 0;
		while ((row < matrix.length) && (column < matrix[row].length)) {
			sum += matrix[row++][column++];
		}
		return sum;
	}

	private static int[][] readMatrix(Scanner scan) {
		int dimension = Integer.parseInt(scan.nextLine());
		int[][] matrix = new int[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
					.mapToInt(Integer::parseInt)
					.toArray();
		}
		return matrix;
	}

}
