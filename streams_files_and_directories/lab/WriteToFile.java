package streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class WriteToFile {

	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
			FileOutputStream outputStream = new FileOutputStream("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/02.WriteToFileOutput.txt");
			PrintWriter writer = new PrintWriter(outputStream);
			int oneByte = inputStream.read();
			HashSet<Character> punctuation = new HashSet<Character>();
			punctuation.add(',');
			punctuation.add('.');
			punctuation.add('!');
			punctuation.add('?');
			while (oneByte >= 0) {
				char symbol = (char) oneByte;
				if (!punctuation.contains(symbol)) {
					writer.print(symbol);
				}
				oneByte = inputStream.read();
			}
			inputStream.close();
			writer.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
