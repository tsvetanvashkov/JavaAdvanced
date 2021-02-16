package defining_classes.exercises.CarSalesman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberEngine = Integer.parseInt(scan.nextLine());
		Map<String, Engine> carEngines = new HashMap<String, Engine>();
		while (numberEngine-- > 0) {
			String[] input = scan.nextLine().split("\\s+");
			String model = input[0];
			int power = Integer.parseInt(input[1]);
			Engine engine = null;
			if (input.length == 4) {
				int displacement = Integer.parseInt(input[2]);
				String efficiency = input[3];
				engine = new Engine(model, power, displacement, efficiency);
			}else if (input.length == 3) {
				if (input[2].matches("[\\d$]+")) {
					int displacement = Integer.parseInt(input[2]);
					engine = new Engine(model, power, displacement);
				}else {
					String efficiency = input[2];
					engine = new Engine(model, power, efficiency);
				}
			}else if (input.length == 2) {
					engine = new Engine(model, power);
			}
			carEngines.putIfAbsent(model, engine);

		}
		int numberCar = Integer.parseInt(scan.nextLine());
		List<Car> carList = new ArrayList<Car>();
		while (numberCar-- > 0) {
			String[] input = scan.nextLine().split("\\s+");
			String model = input[0];
			Engine engine = carEngines.get(input[1]);
			Car car = null;
			if (input.length == 4) {
				int weight = Integer.parseInt(input[2]);
				String color = input[3];
				car = new Car(model, engine, weight, color);
			}else if (input.length == 3) {
				if (input[2].matches("[\\d$]+")) {
					int weight = Integer.parseInt(input[2]);
					car = new Car(model, engine, weight);
				} else {
					String color = input[2];
					car = new Car(model, engine, color);
				}
			}else if (input.length == 2) {
				car = new Car(model, engine);
			}
			carList.add(car);
		}
		scan.close();
		
		carList.forEach(c -> System.out.println(c));

	}

}
