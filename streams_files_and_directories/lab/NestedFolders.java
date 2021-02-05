package streams_files_and_directories.lab;

import java.io.File;
import java.io.IOException;

public class NestedFolders {
	
	public static int foldrsCount = 0;

	public static void main(String[] args) throws IOException {
		
		String locationIn = "/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams";
		
		File file = new File(locationIn);
		dfs(file);
		
		System.out.printf("%d folders", foldrsCount);

	}

	private static void dfs(File file) {
		foldrsCount++;
		for (File f : file.listFiles()) {
			if (f.isDirectory()) {
				dfs(f);
			}
		}
		
		System.out.println(file.getName());
	}

}
