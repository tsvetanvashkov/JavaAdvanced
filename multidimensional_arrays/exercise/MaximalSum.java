package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = readMatrix(scan);
		int[][] submatrix = new int[3][3];
		submatrix = maximumSumOfSubmatrix(matrix, submatrix);
		printSubmatrix(submatrix);

	}
	
	private static void printSubmatrix(int[][] submatrix) {

		for (int r = 0; r < submatrix.length; r++) {
			for (int c = 0; c < submatrix[r].length; c++) {
				System.out.print(submatrix[r][c]);
				if (c < submatrix[r].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}
	
	private static int[][] maximumSumOfSubmatrix(int[][] matrix, int[][] submatrix) {
		int submatrixSum = Integer.MIN_VALUE;
		for (int r = 0; r < (matrix.length - (submatrix.length - 1)); r++) {
			for (int c = 0; c < (matrix[r].length - (submatrix.length - 1)); c++) {
				int sum = 0;
				for (int i = r; i < (r + submatrix.length); i++) {
					for (int j = c; j < (c + submatrix.length); j++) {
						sum += matrix[i][j];
					}
				}
				if (sum > submatrixSum) {
					submatrixSum = sum;
					for (int m = 0, k1 = r; m < submatrix.length; m++, k1++) {
						for (int n = 0, k2 = c; n < submatrix[m].length; n++, k2++) {
							submatrix[m][n] = matrix[k1][k2];
						}
					}
				}
			}
		}
		System.out.printf("Sum = %d\n", submatrixSum);
		return submatrix;
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
