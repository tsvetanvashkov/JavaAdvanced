package streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AllCapitals {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt"));
			String line = reader.readLine();
			while (line != null) {
				line = line.toUpperCase();
				writer.write(line);
				writer.newLine(); 
				line = reader.readLine();
			}
			writer.close();
			reader.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
