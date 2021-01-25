package multidimensional_arrays.lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int row = Integer.parseInt(scan.nextLine());
		int column = Integer.parseInt(scan.nextLine());
		char[][] firstMatrix = readMatrix(scan, row, column);
		char[][] secondMatrix = readMatrix(scan, row, column);
		char[][] thirdMatrix = writeMatrix(firstMatrix, secondMatrix, row, column);
		printMatrix(thirdMatrix);

	}
	
	private static void printMatrix(char[][] thirdMatrix) {
		
		for (int r = 0; r < thirdMatrix.length; r++) {
			for (int c = 0; c < thirdMatrix[r].length; c++) {
				System.out.print(thirdMatrix[r][c]);
				if (c < thirdMatrix[r].length - 1) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}

	private static char[][] writeMatrix(char[][] firstMatrix, char[][] secondMatrix, int row, int colum) {
		char[][] outputMatrix = new char[row][colum];
		for (int r = 0; r < firstMatrix.length; r++) {
			for (int c = 0; c < firstMatrix[r].length; c++) {
				if (firstMatrix[r][c] == secondMatrix[r][c]) {
					outputMatrix[r][c] = firstMatrix[r][c];
				}else {
					outputMatrix[r][c] = '*';
				}
			}
		}
		return outputMatrix;
	}

	private static char[][] readMatrix(Scanner scan, int row, int colum) {

		char[][] matrix = new char[row][colum];
		for (int i = 0; i < row; i++) {
			matrix[i] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
		}
		return matrix;
	}

}
