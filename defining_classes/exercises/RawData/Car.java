package defining_classes.exercises.RawData;

public class Car {
	
	private String model;
	private Engine engine;
	private Cargo cargo;
	private Tire[] tire;
	
	public Car(String model, Engine engine, Cargo cargo, Tire[] tire) {
		super();
		this.model = model;
		this.engine = engine;
		this.cargo = cargo;
		this.tire = tire;
	}

	public String getModel() {
		return model;
	}

	public Engine getEngine() {
		return engine;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public Tire[] getTire() {
		return tire;
	}
	
	public boolean lessPresureTire() {
		for (Tire t : tire) {
			if (t.getTirePressure() < 1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return model;
	}	

}
