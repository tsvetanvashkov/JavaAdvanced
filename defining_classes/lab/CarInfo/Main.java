package defining_classes.lab.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int numberInput = Integer.parseInt(scan.nextLine());
		List<Object> cars = new ArrayList<Object>();
		while (numberInput-- > 0) {
			String[] info = scan.nextLine().split("\\s+");
			String brand = info[0];
			String model = info[1];
			int horsePower = Integer.parseInt(info[2]);
			Car car = new Car(brand, model, horsePower);
			cars.add(car);	
		}
		scan.close();
		for (Object c : cars) {
			System.out.printf("The car is: %s\n", c.toString());
		}

	}

}
