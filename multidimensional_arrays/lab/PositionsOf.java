package multidimensional_arrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] matrix = readMatrix(scan);
		int num = scan.nextInt();
		boolean notFound = searchingNumberInMatrix(matrix, num);
		if (notFound) {
			System.out.println("not found");
		}

	}

	private static boolean searchingNumberInMatrix(int[][] matrix, int num) {
		boolean notFound = true;
		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				if (matrix[row][column] == num) {
					notFound = false;
					System.out.printf("%d %d\n", row, column);
				}
			}
		}
		return notFound;
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
