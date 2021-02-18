package generics.lab.GenericArrayCreator;

public class Main {

	public static void main(String[] args) {
		//ArrayCreator<Integer> creator = new ArrayCreator<Integer>();
		
		Integer[] array = ArrayCreator.create(13, 13);
		String[] strings = ArrayCreator.create(String.class, 13, "Java");
		
		for (Integer integer : array) {
			System.out.println(integer);
		}
		for (String string : strings) {
			System.out.println(string);
		}

	}

}
