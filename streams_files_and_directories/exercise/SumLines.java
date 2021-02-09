package streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
			String line = reader.readLine();
			while (line != null) {
				long sum = 0;
				for (char c : line.toCharArray()) {
					sum += c;
				}
				System.out.println(sum);
				line = reader.readLine();
			}
			reader.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
