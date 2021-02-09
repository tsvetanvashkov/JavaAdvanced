package streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LineNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output5.txt"));
		int num = 0;
		String line = reader.readLine();
		while (line != null) {
			num++;
			writer.write(String.format("%d. %s", num, line));
			writer.newLine(); 
			line = reader.readLine();
		}
		writer.close();
		reader.close();

	}

}
