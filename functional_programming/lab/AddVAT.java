package functional_programming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AddVAT {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		UnaryOperator<Double> addVAT = val -> val * 1.2;
		String values = Arrays.stream(scan.nextLine().split(",\\s+"))
				.map(e -> String.format("%.2f", addVAT.apply(Double.parseDouble(e))))
				.collect(Collectors.joining(System.lineSeparator()));
		scan.close();
		System.out.println("Prices with VAT:");
		System.out.println(values);
	}

}
