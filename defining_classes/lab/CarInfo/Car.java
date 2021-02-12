package defining_classes.lab.CarInfo;

public class Car {
	private String brand;
	private String model;
	private int horsePower;
	public Car(String brand, String model, int horsePower) {
		super();
		this.brand = brand;
		this.model = model;
		this.horsePower = horsePower;
	}
	@Override
	public String toString() {
		return brand + " " + model + " - " + horsePower + " HP.";
	}
	
}
