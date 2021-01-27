package multidimensional_arrays.exercise;

import java.util.Scanner;

public class TheHeiganDance {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][] field = new int[15][15];
		double playerDamage = Double.parseDouble(scan.nextLine());
		int playerRow = 7;
		int playerColumn = 7;
		int playerHealt = 18_500;
		double heiganHealt = 3_000_000;
		int claud = 3500;
		int eruption = 6000;
		boolean lastSpell = false;
		String killedBy = "";
		while (true) {
			heiganHealt -= playerDamage;
			if (lastSpell) {
				playerHealt -= claud;
			} 
			if ((heiganHealt <= 0) || (playerHealt <= 0)) {
				break;
			}
			lastSpell = false;
			String[] input = scan.nextLine().split("\\s+");
			String spell = input[0];
			int spellRow = Integer.parseInt(input[1]);
			int spellColumn = Integer.parseInt(input[2]);
			if (!inDamageArea((playerRow - 1), playerColumn, spellRow, spellColumn) 
					&& isInBound(field, (playerRow - 1), playerColumn)) {
				playerRow--;
			}else if (!inDamageArea(playerRow, (playerColumn + 1), spellRow, spellColumn)
					&& isInBound(field, playerRow, (playerColumn + 1))) {
				playerColumn++;
			}else if (!inDamageArea((playerRow + 1), playerColumn, spellRow, spellColumn)
					&& isInBound(field, (playerRow + 1), playerColumn)) {
				playerRow++;
			}else if (!inDamageArea(playerRow, (playerColumn - 1), spellRow, spellColumn)
					&& isInBound(field, playerRow, (playerColumn - 1))) {
				playerColumn--;
			}else {
				switch (spell) {
				case "Cloud":
					lastSpell = true;
					playerHealt -= claud;
					break;
				case "Eruption":
					playerHealt -= eruption;
					break;
				}
				killedBy = spell;
			}
			if (playerHealt <= 0) {
				break;
			}
			
		}
		
		scan.close();
		printOutput(heiganHealt, playerHealt, killedBy, playerRow, playerColumn);

	}
	
	private static void printOutput(double heiganHealt, int playerHealt, String killedBy, int playerRow,
			int playerColumn) {
		if (killedBy.equals("Cloud")) {
			killedBy = "Plague Cloud";
		}
		if (heiganHealt <= 0) {
			System.out.println("Heigan: Defeated!");
		}else {
			System.out.printf("Heigan: %.2f\n", heiganHealt);
		}
		if (playerHealt <= 0) {
			System.out.printf("Player: Killed by %s\n", killedBy);
		}else {
			System.out.printf("Player: %d\n", playerHealt);
		}
		System.out.printf("Final position: %d, %d\n", playerRow, playerColumn);
		
	}

	private static boolean isInBound(int[][] field, int r, int c) {
		if (r < field.length && r >= 0 && c < field[r].length && c >= 0) {
			return true;
		}else {
			return false;
		}
	}

	private static boolean inDamageArea(int playerRow, int playerColumn, int spellRow, int spellColumn) {
		for (int r = (playerRow - 1); r <= (playerRow + 1); r++) {
			for (int c = (playerColumn - 1); c <= (playerColumn + 1); c++) {
				if (r == spellRow && c == spellColumn) {
					return true;
				}
			}
		}
		return false;
	}

}
