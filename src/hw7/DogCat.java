package hw7;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DogCat {

	
//	• 請寫一支程式,利用老師提供的Dog與Cat類別分別產生兩個物件,寫到C:\data\Object.ser裡。注
//	意物件寫入需注意的事項,若C:\內沒有data資料夾,請用程式新增這個資料夾

	public static void main (String[]args) {
		Dog d = new Dog("小黑");
		Cat c = new Cat("小白");
		File dir = new File("/Users/shangyi/Documents/CKA101_Workspace/data");
		if(!dir.exists()) {
			dir.mkdirs();
		}
		File file = new File(dir, "Object.ser");
		
		try (FileOutputStream fos = new FileOutputStream(file);
			 ObjectOutputStream oos = new ObjectOutputStream(fos)){
			oos.writeObject(d);
			oos.writeObject(c);
			
			System.out.print("成功");
		}catch(IOException e) {
			
		}
	}


//	• 承上題,請寫一個程式,能讀取Object.ser這四個物件,並執行speak()方法觀察結果如何 (請利用多
//	型簡化本題的程式設計)
}
