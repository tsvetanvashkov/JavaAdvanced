package streams_files_and_directories.lab;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {

	public static void main(String[] args) {
		try {
			FileInputStream inputStream = new FileInputStream("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt");
			FileOutputStream outputStream = new FileOutputStream("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/03.CopyBytesOutput.txt");
			PrintWriter writer = new PrintWriter(outputStream);
			int oneByte = inputStream.read();
			while (oneByte >= 0) {
				if (oneByte == 10 || oneByte == 32) {
					writer.print((char)oneByte);
				}else {
					writer.print(oneByte);
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
