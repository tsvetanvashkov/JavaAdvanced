package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[][] matrix = readMatrix(scan);
		String command = scan.nextLine();
		while (!command.equals("END")) {
			String[] coordintates = command.split("\\s+");
			if (validCoordinates(matrix, coordintates)) {
				matrix = getSwap(matrix, coordintates);
				printMatrinx(matrix);
			}else {
				System.out.println("Invalid input!");
			}
			command = scan.nextLine();
		}

	}
	
	private static void printMatrinx(String[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c]);
			}
			System.out.println();
		}
		
	}
	

	private static String[][] getSwap(String[][] matrix, String[] coordintates) {
		int firstRow = Integer.parseInt(coordintates[1]);
		int firstColumn = Integer.parseInt(coordintates[2]);
		int secondRow = Integer.parseInt(coordintates[3]);
		int secondColumn = Integer.parseInt(coordintates[4]);
		
		String swap = matrix[firstRow][firstColumn];
		matrix[firstRow][firstColumn] = matrix[secondRow][secondColumn];
		matrix[secondRow][secondColumn] = swap;
		
		return matrix;
	}



	private static boolean validCoordinates(String[][] matrix, String[] coordintates) {
		if (coordintates.length == 5) {
			if (coordintates[0].equals("swap")) {
				if (isInBound(matrix, Integer.parseInt(coordintates[1]), Integer.parseInt(coordintates[2])) 
						&& isInBound(matrix, Integer.parseInt(coordintates[3]), Integer.parseInt(coordintates[4]))) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private static boolean isInBound(String[][] matrix, int r, int c) {
		if (r < matrix.length && r >= 0 && c < matrix[r].length && c >= 0) {
			return true;
		}else {
			return false;
		}
		
	}



	private static String[][] readMatrix(Scanner scan) {
		int[] dimentions = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int row = dimentions[0];
		int column = dimentions[1];

		String[][] matrix = new String[row][column];
		for (int i = 0; i < row; i++) {
			matrix[i] = scan.nextLine().split("\\s+");
		}
		return matrix;
	}


}
