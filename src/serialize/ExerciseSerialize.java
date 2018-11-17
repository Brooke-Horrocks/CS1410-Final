package serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ExerciseSerialize {

	public static void main(String[] args) {
		Random r = new Random(19);
		List<Integer> list = new ArrayList<>(Arrays.asList());
		
		for (int i = 0; i < 20; i++ ) {
			int temp = r.nextInt(11);
			if (temp < 2) {
				list.add(temp + 10);
			}
			else if (temp > 1) {
				list.add(temp * 5);
			}
		}
		
		System.out.println("numbers: " + list);
		Collections.sort(list);
		serialize(list, "NumberList.ser");
		System.out.println("numbers2: " + list);
		List<Integer> numbers2 = deserialize("NumberList.ser");
		Collections.shuffle(numbers2);
		System.out.println("numbers2: " + numbers2);
	}
	
	public static void serialize(List<Integer> list, String filename) {
    	try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("NumberList.ser"))){
    		output.writeObject(list);
    	} catch (IOException e) {
			System.out.println(e);
		}
    }
    
    @SuppressWarnings("unchecked")
	public static List<Integer> deserialize(String filename) {
    	try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("NumberList.ser"))){
    		return (List<Integer>) input.readObject();
    	} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		} 
    	
    	return null;
    }
}
