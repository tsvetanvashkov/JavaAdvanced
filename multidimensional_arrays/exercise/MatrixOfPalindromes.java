package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[][] matrix = readMatrix(scan);
		matrix = fillMatrix(matrix);
		printMatrinx(matrix);

	}
	
	private static String[][] fillMatrix(String[][] matrix) {
		char first = 'a';
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				matrix[r][c] += (char)(first + r);
				matrix[r][c] += (char)(first + (r + c));
				matrix[r][c] += (char)(first + r);
			}
		}
		return matrix;
	}

	private static String[][] readMatrix(Scanner scan) {
		int[] dimension = Arrays.stream(scan.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
		int row = dimension[0];
		int column = dimension[1];
		String[][] matrix = new String[row][column];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				matrix[r][c] = "";
			}
		}
		
		return matrix;
	}

	private static void printMatrinx(String[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c]);
				if (c < (matrix[r].length - 1)) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}

}
