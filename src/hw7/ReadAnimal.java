package hw7;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadAnimal {
	
	public static void main(String[] args)  {
		
		File file = new File("/Users/shangyi/Documents/CKA101_Workspace/data/Object.ser");
		try {
			FileInputStream fis = new FileInputStream(file); 
			ObjectInputStream ois = new ObjectInputStream(fis);
			ois.close();
			fis.close();
			for(int i = 0 ; i < 2 ; i++) {
				Object obj = ois.readObject();
				Animal a = (Animal)obj;
				a.speak();
				}
		}catch (IOException | ClassNotFoundException e) {
		    e.printStackTrace();
		}
		
	}
	
}
