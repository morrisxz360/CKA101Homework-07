package hw6;

import java.util.Scanner;

public class CalTest  {
	public static void main(String[] args) throws CalException {
		Scanner scn = new Scanner(System.in);
		try {
			System.out.println("請輸入x的值");
			int x = scn.nextInt();
			System.out.println("請輸入y的值");
			int y = scn.nextInt();
			Calculator z = new Calculator(x,y);
			System.out.println(z.powerXY(x,y));
		}catch (CalException c1) {
			System.out.println(c1.getMessage());
		}
		finally {
			System.out.println("請再試一次");
			scn.close();	
		}
		
		
	}
}
