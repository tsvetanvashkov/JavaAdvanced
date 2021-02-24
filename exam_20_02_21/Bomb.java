package exam_20_02_21;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bomb {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dimention = Integer.parseInt(scan.nextLine());
		ArrayDeque<String> commands = getValues(scan);
		List<List<String>> matrix = fillMatrix(scan, dimention);
		int startRow = 0;
		int startColum = 0;
		int bombCount = 0;
		for (int i = 0; i < matrix.size(); i++) {
			List<String> list = matrix.get(i);
			if (list.contains("s") || list.contains("B")) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).equals("s")) {
						startRow = i;
						startColum = j;
					}
					if (list.get(j).equals("B")) {
						bombCount++;
					}
				}
			}
		}
		boolean bombFound = false;
		boolean endFound = false;
		
		while (!commands.isEmpty()) {
			String move = commands.poll();
			switch (move) {
			case "left":
				startColum--;
				if (isInBound(matrix, startRow, startColum)) {
					List<String> list = matrix.get(startRow);
					String field = list.get(startColum);
					if (field.equals("B")) {
						System.out.println("You found a bomb!");
						list.set(startColum, "+");
						bombCount--;
					}
					
				}else {
					startColum++;
				}
				break;
			case "right":
				startColum++;
				if (isInBound(matrix, startRow, startColum)) {
					List<String> list = matrix.get(startRow);
					String field = list.get(startColum);
					if (field.equals("B")) {
						System.out.println("You found a bomb!");
						list.set(startColum, "+");
						bombCount--;
					}
				}else {
					startColum--;
				}
				break;
			case "up":
				startRow--;
				if (isInBound(matrix, startRow, startColum)) {
					List<String> list = matrix.get(startRow);
					String field = list.get(startColum);
					if (field.equals("B")) {
						System.out.println("You found a bomb!");
						list.set(startColum, "+");
						bombCount--;
					}
				}else {
					startRow++;
				}
				break;
			case "down":
				startRow++;
				if (isInBound(matrix, startRow, startColum)) {
					List<String> list = matrix.get(startRow);
					String field = list.get(startColum);
					if (field.equals("B")) {
						System.out.println("You found a bomb!");
						list.set(startColum, "+");
						bombCount--;
					}
				}else {
					startRow--;
				}
				break;
			}
			if (bombCount == 0) {
				bombFound = true;
				break;
			}
			List<String> list = matrix.get(startRow);
			if (list.get(startColum).equals("e")) {
				endFound = true;
				break;
			}
			
		}
		
		if (bombFound) {
			System.out.print("Congratulations! You found all bombs!");
		}else if (endFound) {
			System.out.printf("END! %d bombs left on the field", bombCount);
		}else {
			System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCount, startRow, startColum);
		}

	}
	
	private static boolean isInBound(List<List<String>> matrix, int r, int c) {
		if (r < matrix.size() && r >= 0) {
			List<String> list = matrix.get(r);
			if (c < list.size() && c >= 0) {
				return true;
			}
		}
		return false;
	}
	
	private static List<List<String>> fillMatrix(Scanner scan, int dimention) {
		List<List<String>> matrix = new ArrayList<List<String>>();
		for (int r = 0; r < dimention; r++) {
			List<String> list = new ArrayList<String>();
			list = Arrays.stream(scan.nextLine().split("\\s+")).collect(Collectors.toList());
			matrix.add(list);
		}
		return matrix;
	}

	
	private static ArrayDeque<String> getValues(Scanner scan) {
		ArrayDeque<String> queue = new ArrayDeque<String>();
		String[] sequence = scan.nextLine().split(",");
		for (String value : sequence) {
			queue.offer(value);
		}
		return queue;
	}

}
