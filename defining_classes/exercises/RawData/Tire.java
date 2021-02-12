package defining_classes.exercises.RawData;

public class Tire {
	
	private double tirePressure;
	private int tireAge;
	
	public double getTirePressure() {
		return tirePressure;
	}

	public int getTireAge() {
		return tireAge;
	}

	public Tire(double tirePressure, int tireAge) {
		super();
		this.tirePressure = tirePressure;
		this.tireAge = tireAge;
	}
	

}
