package homework;

public class Hw0408AuthCode {
//	6.身為程式設計師的你,收到一個任務,要幫系統的註冊新增驗證碼的功能,請設計一個方法
//	genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,此驗證碼內容包含了英文大小寫
//	與數字的亂數組合,如圖:
	public static void main(String[]args) {
		Hw0408AuthCode code = new Hw0408AuthCode();
		System.out.println(code.genAuthCode());
	}
	
	public char[] genAuthCode() {
		int arr [] = new int[62];
		char arr1[] = new char[8];
		int x = 65; int y = 97; int z = 48;
		for(int i = 0 ; i < 26; i++) {
			arr[i] = x++;
		}
		for(int i = 26 ; i < 52; i++) {
			arr[i] = y++;
		}
		for(int i = 52; i < 62; i++) {
			arr[i] = z++;
		}
		
		for(int i = 0; i < 8; i++) {
			arr1[i] = (char)(arr[(int)(Math.random()*arr.length)]);
		}
		
		return arr1;
	}

}
