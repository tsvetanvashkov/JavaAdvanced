package multidimensional_arrays.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<List<Integer>> matrix = fillMatrix(scan);
		String input = scan.nextLine();
		while (!input.equals("Nuke it from orbit")) {
			int[] command = Arrays.stream(input.split("\\s+"))
									.mapToInt(Integer::parseInt)
									.toArray();
			matrix = destroying(matrix, command);
			input = scan.nextLine();
		}
		printMatrinx(matrix);

	}

	private static void printMatrinx(List<List<Integer>> matrix) {
		for (int i = 0; i < matrix.size(); i++) {
			List<Integer> list = matrix.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j));
				if (j < (list.size() - 1)) {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
	}

	private static List<List<Integer>> destroying(List<List<Integer>> matrix, int[] command) {
		int row = command[0];
		int column = command[1];
		int radius = command[2];
		for (int i = 0; i <= radius; i++) {
			if (i == 0) {
				if (isInBound(matrix, row, column)) {
					matrix = removeElement(matrix, row, column);
					for (int j = 0; j < radius; j++) {
						if (isInBound(matrix, row, column)) {
							matrix = removeElement(matrix, row, column);
						}
					}
				}else {
					for (int j = 1; j <= radius; j++) {		
						for (int j2 = j; j2 <= radius && isInBound(matrix, row, (column + j)); j2++) {
							matrix = removeElement(matrix, row, (column + j));
						}
					}
				}
			}else {
				if (isInBound(matrix, (row - i), column)) {
					matrix = removeElement(matrix, (row - i), column);
				}
				if (isInBound(matrix, (row + i), column)) {
					matrix = removeElement(matrix, (row + i), column);
				}
				if (isInBound(matrix, row, (column - i))) {
					matrix = removeElement(matrix, row, (column - i));
				}
				
			}
		}
		for (int i = 0; i < matrix.size(); i++) {
			List<Integer> list = matrix.get(i);
			if (list.isEmpty()) {
				matrix.remove(i);
			}
		}
		return matrix;
	}

	private static List<List<Integer>> removeElement(List<List<Integer>> matrix, int row, int column) {
		List<Integer> list = matrix.get(row);
		list.remove(column);
		return matrix;
	}

	private static boolean isInBound(List<List<Integer>> matrix, int r, int c) {
		if (r < matrix.size() && r >= 0) {
			List<Integer> list = matrix.get(r);
			if (c < list.size() && c >= 0) {
				return true;
			}
		}
		return false;
	}

	private static List<List<Integer>> fillMatrix(Scanner scan) {
		int[] dimension = Arrays.stream(scan.nextLine().split("\\s+"))
				.mapToInt(Integer::parseInt)
				.toArray();
		int row = dimension[0];
		int column = dimension[1];
		int num = 1;
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		for (int r = 0; r < row; r++) {
			List<Integer> list = new ArrayList<Integer>();
			for (int c = 0; c < column; c++) {
				list.add(num++);
			}
			matrix.add(list);
		}
		return matrix;
	}

}
