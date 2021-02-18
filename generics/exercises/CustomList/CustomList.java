package generics.exercises.CustomList;

import java.util.ArrayList;
import java.util.List;

public class CustomList<E extends Comparable<E>> {
	private List<E> data;
	
	public CustomList() {
		this.data = new ArrayList<>();
	}
	
	public void add(E element) {
		this.data.add(element);
	}
	
	public E remove(int index) {
		return this.data.remove(index);
	}
	
	public boolean contains(E element) {
		return this.data.contains(element);
	}
	
	public void swap(int index1, int index2) {
		E firstElement = this.data.get(index1);
		this.data.set(index1, this.data.get(index2));
		this.data.set(index2, firstElement);
	}
	
	public long countGreaterThan(E element) {
		return this.data.stream()
					.filter(e -> e.compareTo(element) > 0)
					.count();
	}
	
	public E getMax() {
		E maxElement = this.data.get(0);
		for (E e : this.data) {
			if (e.compareTo(maxElement) > 0) {
				maxElement = e;
			}
		}
		return maxElement;
	}
	
	public E getMin() {
		E minElement = this.data.get(0);
		for (E e : this.data) {
			if (e.compareTo(minElement) < 0) {
				minElement = e;
			}
		}
		return minElement;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (E element : this.data) {
			sb.append(element.toString())
				.append(System.lineSeparator());
		}
		return sb.toString().trim();
	}

}
