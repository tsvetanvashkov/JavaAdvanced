package generics.lab.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator<T> {
	public static <T> T[] create(int length, T item) {
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) Array.newInstance(item.getClass(), length);
		Arrays.fill(arr, item);
		return arr;
	}
	public static <T> T[] create(Class<T> clazz, int length, T item) {
		@SuppressWarnings("unchecked")
		T[] arr = (T[]) Array.newInstance(clazz, length);
		Arrays.fill(arr, item);
		return arr;
	}
}
