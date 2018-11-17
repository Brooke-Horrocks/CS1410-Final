package fileIo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseFile {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String userCharacter = "";
		File file = new File("Diamond2.txt");
		ArrayList<String> list = new ArrayList<String>();
		
		System.out.println("Enter a single character: ");
		userCharacter = input.next();		
		
		try(Scanner reader = new Scanner(ExerciseFile.class.getResourceAsStream("Diamond.txt"))) {
			while(reader.hasNext()) {
				list.add(reader.nextLine().replaceAll("x", userCharacter));			
			}
		}

		try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file))){
    		output.writeObject(list);
    	} catch (IOException e) {
			System.out.println(e);
		}
		
		System.out.println("Modified Text:");
		for(String el : list) {
			System.out.println(el);
		}
		
		input.close();
	}
}
