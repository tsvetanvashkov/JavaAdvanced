package functional_programming.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Consumer<String> consumer = name -> System.out.println("Sir " + name);
		Arrays.stream(scan.nextLine().split("\\s+")).forEach(consumer);
		scan.close();
		
	}

}
