package streams_files_and_directories.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {

	public static void main(String[] args) throws IOException {
		
		String locationIn = "/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
		String locationOut = "/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/06.SortLinesOutput.txt";
		
		List<String> list = Files.readAllLines(Paths.get(locationIn))
				.stream()
				.sorted(String::compareTo)
				.collect(Collectors.toList());
		
		Files.write(Paths.get(locationOut), list);

	}

}
