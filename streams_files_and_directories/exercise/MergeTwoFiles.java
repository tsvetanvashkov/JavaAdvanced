package streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MergeTwoFiles {

	public static void main(String[] args) throws IOException {
		BufferedReader readerFirst = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt"));
		BufferedReader readerSecond = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output7.txt"));
		
		String line = readerFirst.readLine();
		while (line != null) {
			writer.write(line);
			writer.newLine(); 
			line = readerFirst.readLine();
		}
		line = readerSecond.readLine();
		while (line != null) {
			writer.write(line);
			writer.newLine(); 
			line = readerSecond.readLine();
		}
		
		readerFirst.close();
		readerSecond.close();
		writer.close();

	}

}
