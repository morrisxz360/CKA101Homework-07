package hw6;

public class Calculator {
//	• 有個自訂方法為powerXY(int x, int y),功能是會計算x的y次方並回傳結果。 
//	CalTest.java執行後,使用者可以輸入x與y的值,請加入例外處理機制,讓程式能解決以下狀況:
//	1. x與y同時為0,(產生自訂的CalException例外物件)
//	2. y為負值,而導致x的y次方結果不為整數
//	3. x與y皆正確情況下,會顯示運算後結果
	private int x;
	private int y;
	public Calculator() {
		
	}
	public Calculator(int x,int y) throws CalException {
		setXY(x , y);
	}
	public String getXY() {
		return ("x ="+ x + "y =" + y);
	}
	
	public void setXY(int x, int y)throws CalException {
		if(y == 0 && x == 0) {
			throw new CalException("xy不得等於零");
		}
		if(y < 0) {
			throw new CalException("y不得為負值");
		}
			this.x = x;
			this.y = y;
		
			
	}
	public int powerXY(int x, int y) {
		
		return (int)Math.pow(x, y);
		
	}
	
	
}
	


