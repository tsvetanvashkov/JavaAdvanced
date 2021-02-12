package defining_classes.exercises.RawData;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInput = Integer.parseInt(scan.nextLine());
		Map<String, Car> cars = new LinkedHashMap<String, Car>();
		while (numberInput-- > 0) {
			String[] input = scan.nextLine().split("\\s+");
			String model = input[0];
			int engineSpeed = Integer.parseInt(input[1]);
			int enginePower = Integer.parseInt(input[2]);
			Engine engine = new Engine(engineSpeed, enginePower);
			int cargoWeight = Integer.parseInt(input[3]);
			String cargoType = input[4];
			Cargo cargo = new Cargo(cargoWeight, cargoType);
			Tire[] tire = new Tire[4];
			for (int i = 0, j = 5; i < tire.length; i++, j += 2) {
				double tirePressure = Double.parseDouble(input[j]);
				int tireAge = Integer.parseInt(input[j+1]);
				tire[i] = new Tire(tirePressure, tireAge);
			}
			Car car = new Car(model, engine, cargo, tire);
			cars.putIfAbsent(model, car);
			
		}
		
		String inputCargoType = scan.nextLine();
		for (Car car : cars.values()) {
			if (inputCargoType.equals("fragile")
					&& car.getCargo().getCargoType().equals("fragile")
					&& car.lessPresureTire()) {
				System.out.println(car.toString());
			}else if (inputCargoType.equals("flamable") 
					&& car.getCargo().getCargoType().equals("flamable") 
					&& car.getEngine().getEnginePower() > 250) {
				System.out.println(car.toString());
			}
		}
		scan.close();

	}

}
