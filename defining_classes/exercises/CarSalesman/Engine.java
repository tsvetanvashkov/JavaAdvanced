package defining_classes.exercises.CarSalesman;

public class Engine {
	private String model;
	private int power;
	private int displacement;
	private String efficiency;
	
	public Engine(String model, int power, int displacement, String efficiency) {
		super();
		this.model = model;
		this.power = power;
		this.displacement = displacement;
		this.efficiency = efficiency;
	}
	
	public Engine(String model, int power, String efficiency) {
		this(model, power, -1, efficiency);
	}
	
	public Engine(String model, int power, int displacement) {
		this(model, power, displacement, "n/a");
	}
	
	public Engine(String model, int power) {
		this(model, power, -1,"n/a");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.model);
		sb.append(":")
			.append(System.lineSeparator());
		sb.append("Power: ")
			.append(this.power)
			.append(System.lineSeparator());
		sb.append("Displacement: ")
			.append(this.displacement == -1 ? "n/a" : this.displacement)
			.append(System.lineSeparator());
		sb.append("Efficiency: ")
			.append(this.efficiency)
			.append(System.lineSeparator());
		return sb.toString();
	}
	
	
	
}
