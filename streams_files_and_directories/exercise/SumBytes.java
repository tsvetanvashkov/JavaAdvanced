package streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
			String line = reader.readLine();
			long sum = 0;
			while (line != null) {
				for (char c : line.toCharArray()) {
					sum += c;
				}
				line = reader.readLine();
			}
			System.out.println(sum);
			reader.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
