package multidimensional_arrays.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int command = getValue(scan);
		char[][] matrix = readMatrix(scan);
		switch (command) {
		case 90:
			matrix = rotate90(matrix);
			break;
		case 180:
			matrix = rotate180(matrix);
			break;
		case 270:
			matrix = rotate270(matrix);
			break;
		default:
			break;
		}
		printMatrinx(matrix);

	}

	private static void printMatrinx(char[][] matrix) {
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				System.out.print(matrix[r][c]);
			}
			System.out.println();
		}
		
	}

	private static char[][] rotate270(char[][] matrix) {
		int column = matrix.length;
		int row = matrix[0].length;
		char[][] rotateMatrix = new char[row][column];
		for (int r = 0, k1 = (matrix[r].length - 1); r < rotateMatrix.length; r++, k1--) {
			for (int c = 0; c < rotateMatrix[r].length; c++) {
				rotateMatrix[r][c] = matrix[c][k1];
			}
		}
		return rotateMatrix;
	}

	private static char[][] rotate180(char[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;
		char[][] rotateMatrix = new char[row][column];
		for (int r = 0, k1 = (matrix.length - 1); r < rotateMatrix.length; r++, k1--) {
			for (int c = 0, k2 = (matrix[r].length - 1); c < rotateMatrix[r].length; c++, k2--) {
				rotateMatrix[r][c] = matrix[k1][k2];
			}
		}
		return rotateMatrix;
	}

	private static char[][] rotate90(char[][] matrix) {
		int column = matrix.length;
		int row = matrix[0].length;
		char[][] rotateMatrix = new char[row][column];
		for (int r = 0 ; r < rotateMatrix.length; r++) {
			for (int c = 0, k1 = (matrix.length - 1); c < rotateMatrix[r].length; c++, k1--) {
				rotateMatrix[r][c] = matrix[k1][r];
			}
		}
		return rotateMatrix;
	}

	private static int getValue(Scanner scan) {
		String[] input = scan.nextLine().split("[()]");
		int deg = Integer.parseInt(input[1]);
		int command = deg % 360;
		return command;
	}

	private static char[][] readMatrix(Scanner scan) {
		List<String> input = new ArrayList<String>();
		String text = scan.nextLine();
		while (!text.equals("END")) {
			input.add(text);
			text = scan.nextLine();
		}
		int row = input.size();
		int column = 0;
		for (int i = 0; i < input.size(); i++) {
			if (column < input.get(i).length()) {
				column = input.get(i).length();
			}
		}
		char[][] matrix = new char[row][column];
		for (int r = 0; r < matrix.length; r++) {
			char[] arrayText = input.get(r).toCharArray();
			for (int c = 0; c < matrix[r].length; c++) {
				if (c < (arrayText.length)) {
					matrix[r][c] = arrayText[c];
				}else {
					matrix[r][c] = ' ';
				}
				
			}
		}
		return matrix;
	}

}
