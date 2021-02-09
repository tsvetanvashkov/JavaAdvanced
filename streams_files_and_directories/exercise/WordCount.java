package streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

public class WordCount {

	public static void main(String[] args) throws IOException {
		BufferedReader readerWord = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt"));
		BufferedReader readerText = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt"));
		BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
				+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output6.txt"));
		
		String[] words = readerWord.readLine().split("\\s+");
		HashMap<String, Integer> wordOccurrences = new HashMap<String, Integer>();
		for (String w : words) {
			wordOccurrences.put(w, 0);
		}
		
		String[] text = readerText.readLine().split("\\s+");
		for (String word : text) {
			if (wordOccurrences.containsKey(word)) {
				wordOccurrences.put(word, (wordOccurrences.get(word) + 1));
			}
		}
		
//		wordOccurrences.entrySet()
//						.stream()
//						.sorted((w1, w2) -> w2.getValue().compareTo(w1.getValue()));
		
		for (Entry<String, Integer> entry : wordOccurrences.entrySet()) {
			writer.write(String.format("%s - %d\n", entry.getKey(), entry.getValue()));
		}
		
		readerWord.close();
		readerText.close();
		writer.close();

	}

}
