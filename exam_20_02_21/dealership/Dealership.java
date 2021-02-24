package exam_20_02_21.dealership;

import java.util.ArrayList;
import java.util.List;


public class Dealership {

	private String name;
	private int capacity;
	private List<Car> data;
	
	public Dealership(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.data = new ArrayList<Car>();
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void add(Car car) {
		this.data.add(car);
	}
	
	public boolean buy(String manufacturer, String model) {
		for (Car car : this.data) {
			if (car.getManufacturer() == manufacturer && car.getModel() == model) {
				this.data.remove(car);
				return true;
			}
		}
		return false;
	}
	
	public Car getLatestCar() {
		if (!this.data.isEmpty()) {
			int latestYear = Integer.MIN_VALUE;
			Car latestCar = null;
			for (Car car : this.data) {
				if (car.getYear() > latestYear) {
					latestCar = car;
					latestYear = car.getYear();
				}
			}
			return latestCar;
		}else {
			return null;
		}
		
	}
	
	public Car getCar(String manufacturer, String model) {
		
		for (Car car : this.data) {
			if (car.getManufacturer() == manufacturer && car.getModel() == model) {
				return car;
			}
		}
		return null;
	}
	
	public int getCount() {
		return this.data.size();
	}
	
	public String getStatistics() {
		StringBuilder sb = new StringBuilder("The cars are in a car dealership ");
		sb.append(this.name)
			.append(":")
			.append(System.lineSeparator());
		for (Car car : data) {
			sb.append(car)
				.append(System.lineSeparator());
		}
		return sb.toString();
	}
	
	
}
