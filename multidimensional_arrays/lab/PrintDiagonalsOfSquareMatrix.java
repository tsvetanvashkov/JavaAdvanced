package multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = readMatrix(scan);
		int[] firstDiagonal = readDiagonalF(matrix);
		int[] secondDiagonal = readDiagonalS(matrix);
		printDiagonal(firstDiagonal);
		System.out.println();
		printDiagonal(secondDiagonal);
		
	}
	
	private static void printDiagonal(int[] firstDiagonal) {
		for (int i = 0; i < firstDiagonal.length; i++) {
			System.out.print(firstDiagonal[i]);
			if (i < (firstDiagonal.length - 1)) {
				System.out.print(" ");
			}
		}		
	}

	private static int[] readDiagonalS(int[][] matrix) {
		int[] diagonal = new int[matrix.length];
		for (int r = (matrix.length - 1), c = 0; r >= 0; r--, c++) {
			diagonal[c] = matrix[r][c];
		}
		return diagonal;
	}

	private static int[] readDiagonalF(int[][] matrix) {
		int[] diagonal = new int[matrix.length];
		for (int r = 0, c = 0; r < matrix.length; r++, c++) {
			diagonal[c] = matrix[r][c];
		}
		return diagonal;
	}

	private static int[][] readMatrix(Scanner scan) {
		
		int dimention = Integer.parseInt(scan.nextLine());

		int[][] matrix = new int[dimention][dimention];
		for (int i = 0; i < dimention; i++) {
			matrix[i] = Arrays.stream(scan.nextLine().split("\\s+"))
							.mapToInt(Integer::parseInt)
							.toArray();
		}
		return matrix;
	}

}
