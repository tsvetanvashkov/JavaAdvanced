package sets_and_maps_advanced.lab;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeMap<String, LinkedHashMap<String, Double>> register = new TreeMap<String, LinkedHashMap<String,Double>>();
		String input = scan.nextLine();
		while (!input.equals("Revision")) {
			String[] command = input.split(",\\s+");
			String shop = command[0];
			String product = command[1];
			double price = Double.parseDouble(command[2]);
			if (!register.containsKey(shop)) {
				LinkedHashMap<String, Double> productInfo = new LinkedHashMap<String, Double>();
				productInfo.put(product, price);
				register.put(shop, productInfo);
 			}else {
				LinkedHashMap<String, Double> productInfo = register.get(shop);
				if (!productInfo.containsKey(product)) {
					productInfo.put(product, price);
				}else {
					price = productInfo.get(product);
				}
			}
			
			input = scan.nextLine();
		}
		scan.close();
		printRegister(register);

	}

	private static void printRegister(TreeMap<String, LinkedHashMap<String, Double>> register) {
		
		register.forEach((key, value) -> {
			System.out.printf("%s->\n", key); 
			value.forEach((k, v) -> {
				System.out.printf("Product: %s, Price: %.1f\n", k, v);
			});
		});
		
	}

}
