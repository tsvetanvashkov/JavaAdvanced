package defining_classes.lab.CarConsructors;

public class Car {
	private String brand;
	private String model;
	private int horsePower;
	
	public Car(String brand, String model, int horsePower) {
		this.brand = brand;
		this.model = model;
		this.horsePower = horsePower;
	}
	
	public Car(String brand) {
		this(brand, "unknown", -1);
	}

	@Override
	public String toString() {
		return brand + " " + model + " - " + horsePower + " HP.";
	}

}
