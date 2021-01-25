package multidimensional_arrays.exercise;

import java.util.Scanner;

public class FillTheMatrix {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().split(",\\s+");
		scan.close();
		String pattern = input[1];
		int dimension = Integer.parseInt(input[0]);
		int[][] matrix = new int[dimension][dimension];
		switch (pattern) {
		case "A":
			matrix = patternA(matrix);
			break;
		case "B":
			matrix = patternB(matrix);
			break;
		}
		printMatrinx(matrix);

	}

	private static void printMatrinx(int[][] matrix) {
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

	private static int[][] patternB(int[][] matrix) {
		int count = 0;
		for (int r = 0; r < matrix.length; r++) {
			if ((r % 2) == 0) {
				for (int c = 0; c < matrix[r].length; c++) {
					count++;
					matrix[c][r] = count;
				}
			}else {
				for (int c1 = (matrix[r].length - 1); c1 >= 0; c1--) {
					count++;
					matrix[c1][r] = count;
				}
			}
			
		}
		return matrix;
	}

	private static int[][] patternA(int[][] matrix) {
		int count = 0;
		for (int r = 0; r < matrix.length; r++) {
			for (int c = 0; c < matrix[r].length; c++) {
				count++;
				matrix[c][r] = count;
			}
		}
		return matrix;
	}

}
