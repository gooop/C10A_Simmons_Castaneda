/*
 * @authors Ethan Simmons, Gavin Castaneda
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreTrakker {

	private ArrayList<Student> students = new ArrayList<Student>();
	
	// Reads student data from file with inputed name and stores student objects in the ArrayList
	private void loadDataFromFile(String fileName) throws FileNotFoundException {
		FileReader reader = new FileReader(fileName);
		Scanner in = new Scanner(reader);
		while (in.hasNextLine()) {
			String name = in.nextLine();
			int score = in.nextInt();
			if (in.hasNextLine()) in.nextLine(); // Skips over rest of the line after the int
			students.add(new Student(name, score));
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
		loadDataFromFile("scores.txt");
		printInOrder();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		ScoreTrakker sc = new ScoreTrakker();
		sc.processFiles();
	}

}
