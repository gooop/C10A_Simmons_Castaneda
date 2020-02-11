/*
 * @authors Ethan Simmons, Gavin Castaneda
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {

	private ArrayList<Student> students = new ArrayList<Student>();
	
	// Stores strings to use as filenames into loadDataFromFile
	private String[] files = {"scores.txt", "badscore.txt", "nofile.txt" };
	
	// Reads student data from file with inputed name and stores student objects in the ArrayList
	private void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			String name = in.nextLine();
			String scoreString = in.nextLine(); // Takes in entire next line, which should be the score value
			try {
				int score = Integer.parseInt(scoreString);
				students.add(new Student(name, score));
			} catch (Exception NumberFormatException) {
				System.out.println("Incorrect format for " + name + "not a valid score: " + scoreString);
			}
		}
		in.close();
	}
	
	// sorts and prints the students ArrayList
	private void printInOrder() {
		System.out.println("Student Score List");
		for (Student s : students) {
			System.out.println(s);
		}
	}
	
	// 
	private void processFiles() throws FileNotFoundException {
		for (String fileName : files) {
			loadDataFromFile(fileName);
		}
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker sc = new ScoreTrakker();
		sc.processFiles();
	}

}
