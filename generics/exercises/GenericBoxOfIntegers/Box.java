package generics.exercises.GenericBoxOfIntegers;

public class Box<T> {
	private T value;

	public Box(T value) {
		super();
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.format("%s: %s", this.value.getClass().getName(), value.toString());
	}
	
}
