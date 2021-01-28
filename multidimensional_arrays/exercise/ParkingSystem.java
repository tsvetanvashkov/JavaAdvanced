package multidimensional_arrays.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] parking = readMatrix(scan);
		String input = scan.nextLine();
		while (!input.equals("stop")) {
			parking = getParked(parking, input);
			input = scan.nextLine();
		}
		

	}
	
	private static int[][] getParked(int[][] parking, String input) {
		int[] cordinate = Arrays.stream(input.split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int entry = cordinate[0];
		int row = cordinate[1];
		int column = cordinate[2];
		int move = Math.abs(row - entry) + 1;
		boolean rowFull = false;
		if (freeSlot(parking, row, column)) {
			move += column;
			parking[row][column] = 1;
		}else {
			for (int i = 1; ; i++) {
				if (isInBound(parking[row].length, (column - i)) && freeSlot(parking, row, (column - i))) {
					move += (column - i);
					parking[row][column - i] = 1;
					break;
				}else if (isInBound(parking[row].length, (column + i)) && freeSlot(parking, row, (column + i))) {
					move += (column + i);
					parking[row][column + i] = 1;
					break;
				}else if(!isInBound(parking[row].length, (column - i)) && !isInBound(parking[row].length, (column + i))){
					rowFull = true;
					break;	
				}
			}
		}
		getPrint(rowFull, row, move);
		return parking;
	}
	
	private static void getPrint(boolean rowFull, int row, int move) {
		if (rowFull) {
			System.out.printf("Row %d full\n", row);
		}else {
			System.out.println(move);
		}
		
	}

	private static boolean freeSlot(int[][] parking, int r, int c) {
		if (parking[r][c] == 0) {
			return true;
		}
		return false;
	}

	private static boolean isInBound(int length, int c) {
		if (c < length && c > 0) {
			return true;
		}else {
			return false;
		}
	}

	private static int[][] readMatrix(Scanner scan) {
		int[] dimentions = Arrays.stream(scan.nextLine().split("\\s+"))
								.mapToInt(Integer::parseInt)
								.toArray();
		int row = dimentions[0];
		int column = dimentions[1];
		int[][] matrix = new int[row][column];
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix.length; c++) {
				matrix[r][c] = 0;
			}
		}
		return matrix;
	}

}
