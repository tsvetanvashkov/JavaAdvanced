package streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExtractIntegers {

	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
			FileWriter writer = new FileWriter("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/04.ExtractIntegersOutput.txt");
			Scanner scan = new Scanner(inputStream);
			while (scan.hasNext()) {
				if (scan.hasNextInt()) {
					int number = scan.nextInt();
					writer.write(String.valueOf(number));
					writer.write(System.lineSeparator());
				}
				scan.next();
			}
			scan.close();
			inputStream.close();
			writer.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
