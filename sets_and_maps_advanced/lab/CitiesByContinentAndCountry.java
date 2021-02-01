package sets_and_maps_advanced.lab;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CitiesByContinentAndCountry {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInputs = Integer.parseInt(scan.nextLine());
		LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continentMap = new LinkedHashMap<String, LinkedHashMap<String,ArrayList<String>>>();
		while (numberInputs-- > 0) {
			String[] command = scan.nextLine().split("\\s+");
			String continent = command[0];
			String country = command[1];
			String cities = command[2];
			if (!continentMap.containsKey(continent)) {
				LinkedHashMap<String, ArrayList<String>> countryMap = new LinkedHashMap<String, ArrayList<String>>();
				ArrayList<String> citiesList = new ArrayList<String>();
				citiesList.add(cities);
				countryMap.put(country, citiesList);
				continentMap.put(continent, countryMap);
			}else {
				LinkedHashMap<String, ArrayList<String>> countryMap = continentMap.get(continent);
				if (!countryMap.containsKey(country)) {
					ArrayList<String> citiesList = new ArrayList<String>();
					citiesList.add(cities);
					countryMap.put(country, citiesList);
				}else {
					ArrayList<String> citiesList = countryMap.get(country);
					citiesList.add(cities);
				}
			}
			
		}
		scan.close();
		printResources(continentMap);

	}

	private static void printResources(LinkedHashMap<String, LinkedHashMap<String, ArrayList<String>>> continentMap) {
		
		continentMap.forEach((key, value) -> {
			System.out.printf("%s:\n", key); 
			value.forEach((k, v) -> {
				System.out.printf("  %s -> %s\n", k, String.join(", ", v));
			});
		});
		
	}

}
