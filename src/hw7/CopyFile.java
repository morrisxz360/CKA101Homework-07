package hw7;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFile {

//	• 請從無到有試著完成一個方法名為copyFile,這個方法有兩個參數。呼叫此方法時,第一個參數所
//	代表的檔案會複製到第二個參數代表的檔案
	

	public void copyFile(String src, String dest) throws IOException {
		
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(dest);
		byte[] buffer = new byte[4096];
		int len;
			while ((len = fis.read(buffer)) != -1) {
				fos.write(buffer,0,len);
			}
			fos.close();
			fis.close();
			System.out.print("成功");
		}

	public static void main(String[]args) {
		CopyFile a = new CopyFile();
		
		try {
			a.copyFile("Data.txt", "Data_copy.txt");
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
