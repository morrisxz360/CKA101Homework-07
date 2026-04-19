package hw7;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Interger1000 {
//	• 請寫一隻程式,能夠亂數產生10個1~1000的整數,並寫入一個名為Data.txt的檔案裡 (請使用
//	append功能讓每次執行結果都能被保存起來)
	
	public static void main(String[]args) {
		Set set = new HashSet();
		while(set.size() < 10 ) {
			set.add((int)(Math.random()*1000) + 1);
		}
			
			
			try {
				FileWriter fw = new FileWriter("Data.txt",true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				Iterator objs = set.iterator();
				while(objs.hasNext()) {
					bw.write(objs.next() + " "); 
				}
				bw.newLine();
				bw.close();
				fw.close();
				
				
				System.out.println("成功寫入");
				
			}catch(IOException e){
				
			}
			
		}
}
	


