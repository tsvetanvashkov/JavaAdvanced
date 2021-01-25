package multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[][] firstMatrix = readMatrix(scan);
		int[][] secondMatrix = readMatrix(scan);
		boolean equal = matricesAreEqual(firstMatrix, secondMatrix);
		
		if (equal) {
			System.out.println("equal");
		}else {
			System.out.println("not equal");
		}

	}

	private static boolean matricesAreEqual(int[][] firstMatrix, int[][] secondMatrix) {
		if (firstMatrix.length != secondMatrix.length) {
			return false;
		}
		for (int row = 0; row < firstMatrix.length; row++) {
			if (firstMatrix[row].length != secondMatrix[row].length) {
				return false;
			}
			for (int column = 0; column < firstMatrix[row].length; column++) {
				if (firstMatrix[row][column] != secondMatrix[row][column]) {
					return false;
				}
			}
		}
		return true;
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
