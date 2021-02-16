package defining_classes.exercises.CarSalesman;

public class Car {
	private String model;
	private Engine engine;
	private int weight;
	private String color;
	
	public Car(String model, Engine engine, int weight, String color) {
		super();
		this.model = model;
		this.engine = engine;
		this.weight = weight;
		this.color = color;
	}
	
	public Car(String model, Engine engine, String color) {
		this(model, engine, -1, color);
	}
	
	public Car(String model, Engine engine, int weight) {
		this(model, engine, weight, "n/a");
	}
	
	public Car(String model, Engine engine) {
		this(model, engine, -1, "n/a");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(this.model);
		sb.append(":")
			.append(System.lineSeparator());
		sb.append(engine.toString());
		sb.append("Weight: ")
			.append(this.weight == -1 ? "n/a" : this.weight)
			.append(System.lineSeparator());
		sb.append("Color: ")
			.append(this.color);
		return sb.toString();
	}
	
	
	
}
