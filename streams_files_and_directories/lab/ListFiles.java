package streams_files_and_directories.lab;

import java.io.File;
import java.io.IOException;

public class ListFiles {

	public static void main(String[] args) throws IOException {
		
		String locationIn = "/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
		
		File file = new File(locationIn);
		File[] innerFiles =  file.listFiles();
		
		for (File innerFile : innerFiles) {
			if (!innerFile.isDirectory()) {
				System.out.printf("%s: [%d]\n", innerFile.getName(), innerFile.length());
			}
		}

	}

}
