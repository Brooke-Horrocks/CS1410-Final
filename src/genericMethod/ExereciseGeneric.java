package genericMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExereciseGeneric {

	public static void main(String[] args) {
		List<Double> numbers = new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5, 6.6));
		List<Character> letters = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g'));
		
		System.out.println("Original Lists:\nnumbers: " + numbers + "\nletters: " + letters);
		
		removeEveryOtherElement(numbers);
		removeEveryOtherElement(letters);
		
		System.out.println("After removing:\nnumbers: " + numbers + "\nletters: " + letters);
	}
	
	public static <T> void removeEveryOtherElement(List<T> list) {
		for(int i = 1; i < list.size(); i++) {
			list.remove(i);
		}
	}

}
