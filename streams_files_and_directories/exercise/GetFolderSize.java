package streams_files_and_directories.exercise;

import java.io.File;
import java.io.IOException;

public class GetFolderSize {

	public static void main(String[] args) throws IOException {
		File folder = new File("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources");
		int size = 0;
		File[] files = folder.listFiles();
		for (File file : files) {
			size += file.length();
		}
		System.out.printf("Folder size: %d", size);
		
	}

}
