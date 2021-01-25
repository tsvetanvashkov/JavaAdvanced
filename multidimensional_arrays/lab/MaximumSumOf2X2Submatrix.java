package multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = readMatrix(scan);
		int[][] submatrix = new int[2][2];
		submatrix = maximumSumOfSubmatrix(matrix, submatrix);
		printSubmatrix(submatrix);
	}
	
	private static void printSubmatrix(int[][] submatrix) {
		int sum = 0;
		for (int r = 0; r < submatrix.length; r++) {
			for (int c = 0; c < submatrix[r].length; c++) {
				sum += submatrix[r][c];
				System.out.print(submatrix[r][c]);
				if (c < submatrix[r].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println(sum);
		
	}

	private static int[][] maximumSumOfSubmatrix(int[][] matrix, int[][] submatrix) {
		int submatrixSum = Integer.MIN_VALUE;
		for (int r = 0; r < matrix.length - 1; r++) {
			for (int c = 0; c < matrix[r].length - 1; c++) {
				int sum = matrix[r][c] + matrix[r][c+1] + matrix[r+1][c] + matrix[r+1][c+1];
				if (sum > submatrixSum) {
					submatrixSum = sum;
					for (int i = 0, k1 = r; i < submatrix.length; i++, k1++) {
						for (int j = 0, k2 = c; j < submatrix[i].length; j++, k2++) {
							submatrix[i][j] = matrix[k1][k2];
						}
					}
				}
			}
		}
		return submatrix;
	}

	private static int[][] readMatrix(Scanner scan) {
		int[] dimentions = Arrays.stream(scan.nextLine().split(",\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int row = dimentions[0];
		int column = dimentions[1];

		int[][] matrix = new int[row][column];
		for (int i = 0; i < row; i++) {
			matrix[i] = Arrays.stream(scan.nextLine().split(",\\s+"))
							.mapToInt(Integer::parseInt)
							.toArray();
		}
		return matrix;
	}

}
