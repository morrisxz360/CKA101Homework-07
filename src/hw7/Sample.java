package hw7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Sample {
	
//	• 請自行建立一個文字檔Sample.txt,內容如下:

//		請寫一個程式讀取這個Sample.txt檔案,並輸出以下訊息:
//		Sample.txt檔案共有xxx個位元組,yyy個字元,zzz列資料
	
	public static void main(String[] args) {
		int i; int count = 0; int linecount = 0;
		File file = new File("/Users/shangyi/Downloads/Sample.txt");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			while((i = br.read()) != -1) {
				count++;
				System.out.print((char)i);
				if(i == '\n') {
					linecount++;
				}
				}
			System.out.println("字元總共有：" + count);
			System.out.println("總共有" + linecount + "列");
			System.out.println(file.length());
				br.close();
				fr.close();
			} catch (IOException e) {
			}
		
	}
	
	
	
	
}
