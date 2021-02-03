package sets_and_maps_advanced.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HandsOfCards {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedHashMap<String, HashSet<String>> players = new LinkedHashMap<String, HashSet<String>>();
		HashMap<String, Integer> power = new HashMap<String, Integer>();
		HashMap<String, Integer> type = new HashMap<String, Integer>();
		power = getPower(power);
		type = getType(type);
		String input = scan.nextLine();
		while (!input.equals("JOKER")) {
			String[] info = input.split("[:,\\s+]+");
			String name = info[0];
			if (!players.containsKey(name)) {
				HashSet<String> value = new HashSet<String>();
				for (int i = 1; i < info.length; i++) {
					String card = info[i];
					value.add(card);
				}
				players.put(name, value);
			}else {
				HashSet<String> value = players.get(name);
				for (int i = 1; i < info.length; i++) {
					String card = info[i];
					value.add(card);
				}
			}
			input = scan.nextLine();
		}
		scan.close();
		printPlayersScore(players, power, type);

	}

	private static void printPlayersScore(LinkedHashMap<String, HashSet<String>> players,
			HashMap<String, Integer> power, HashMap<String, Integer> type) {
		players.forEach((k, v) -> {
			String regex = "([0-9]+|[JQKA])([SHDC]{1})";
			Pattern pattern = Pattern.compile(regex);
			int score = 0;
			for (String value : v) {
				Matcher matcher = pattern.matcher(value);
				if (matcher.find()) {
					String inputPower = matcher.group(1);
					String inputType = matcher.group(2);
					score += power.get(inputPower) * type.get(inputType);
				}
			}
			System.out.printf("%s: %d\n", k, score);
		});
		
	}

	private static HashMap<String, Integer> getType(HashMap<String, Integer> type) {
		type.put("S", 4);
		type.put("H", 3);
		type.put("D", 2);
		type.put("C", 1);
		return type;
	}

	private static HashMap<String, Integer> getPower(HashMap<String, Integer> power) {
		for (int i = 2; i <= 10; i++) {
			power.put(String.valueOf(i), i);
		}
		power.put("J", 11);
		power.put("Q", 12);
		power.put("K", 13);
		power.put("A", 14);
		return power;
	}

}
