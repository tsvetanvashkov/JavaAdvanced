package streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {

	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
			int oneByte = inputStream.read();
			while (oneByte >= 0) {
				System.out.printf("%s ", Integer.toBinaryString(oneByte));
				oneByte = inputStream.read();
			}
			inputStream.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

	}

}
