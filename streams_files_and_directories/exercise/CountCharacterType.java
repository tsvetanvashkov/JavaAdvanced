package streams_files_and_directories.exercise;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;

public class CountCharacterType {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));
			FileOutputStream outputStream = new FileOutputStream("/home/tsvetan/JAVA_Softuni/Java_Advanced/"
					+ "04.Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output4.txt");
			PrintWriter writer = new PrintWriter(outputStream);
			HashSet<Character> vowels = new HashSet<Character>();
			vowels.add('a');
			vowels.add('e');
			vowels.add('i');
			vowels.add('o');
			vowels.add('u');
			HashSet<Character> punctuation = new HashSet<Character>();
			punctuation.add('!');
			punctuation.add(',');
			punctuation.add('.');
			punctuation.add('?');
			int countVowels = 0;
			int countConsonants = 0;
			int countPunctuation = 0;
 			String line = reader.readLine();
			while (line != null) {
				for (char c : line.toCharArray()) {
					if (vowels.contains(c)) {
						countVowels++;
					}else if (punctuation.contains(c)) {
						countPunctuation++;
					}else if (c !=  ' ') {
						countConsonants++;
					}
				}
				line = reader.readLine();
			}
			writer.write("Vowels: " + countVowels);
			writer.write(System.lineSeparator());
			writer.write("Consonants: " + countConsonants);
			writer.write(System.lineSeparator());
			writer.write("Punctuation: " + countPunctuation);
			writer.close();
			reader.close();
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}


	}

}
