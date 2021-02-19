package iterators_and_comparators.lab.Book;

import java.util.Arrays;
import java.util.List;

public class Book {

	private String title;
	private int year;
	private List<String> authors;
	
	public Book(String title, int year, String... authors) {
		setTitle(title);
		setYear(year);
		setAuthors(authors);
		
		
	}
	
	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public List<String> getAuthors() {
		return authors;
	}
	
	private void setTitle(String title) {
		this.title = title;
	}

	private void setYear(int year) {
		this.year = year;
	}

	private void setAuthors(String... authors) {
		this.authors = Arrays.asList(authors);
	}

}
