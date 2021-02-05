package streams_files_and_directories.lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriteEveryThirdLine {

	public static void main(String[] args) throws IOException {
			BufferedReader reader = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt"));
			BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/05.WriteEveryThirdLineOutput.txt"));
			
			String line = reader.readLine();
			int lineNumber = 1;
			
			while (line != null) {
				lineNumber++;
				line = reader.readLine();
				if ((lineNumber % 3) == 0) {
					writer.write(line);
					writer.newLine(); 
				}
			}
			reader.close();
			writer.close();
	}

}
