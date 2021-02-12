package defining_classes.exercises.RawData;

public class Cargo {
	
	private int cargoWeight;
	private String cargoType;
	
	public Cargo(int cargoWeight, String cargoType) {
		super();
		this.cargoWeight = cargoWeight;
		this.cargoType = cargoType;
	}

	public int getCargoWeight() {
		return cargoWeight;
	}

	public String getCargoType() {
		return cargoType;
	}

	

}
