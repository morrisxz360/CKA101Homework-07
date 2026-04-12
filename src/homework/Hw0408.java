package homework;

import java.util.Scanner;

public class Hw0408 {
	
//	1.請設計一個方法為starSquare(int width, int height),當使用者鍵盤輸入寬與高時,即會印出對應的*長方形,如
//	圖:
	 public void starSquare(int width, int height) {
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
					System.out.print("*");
				}
			System.out.println();
			}
		}
	public static void main(String [] args) {
		Hw0408 a = new Hw0408(); 
		Scanner scn  = new Scanner(System.in);
		System.out.println("請輸入寬高:");
		  int num = scn.nextInt();
		  int num1 = scn.nextInt();
		a.starSquare(num,num1);
		scn.close();
	}
	
	
	
	
//	2.請設計一個方法為randAvg(),從10個 0~100(含100)的整數亂數中取平均值並印出這10個亂數與平均值,如圖:
//
	public void randAvg() {
		int num[] = new int[10];
		int num2 = 0;
		System.out.println("幫你取10個亂數以及平均值");
	for(int i = 0; i < 10; i++) {
		num[i] = (int)(Math.random()*101);
		System.out.print(num[i] + " ");
		num2 += num[i];
	}
	System.out.println();
	num2 = num2/10;
	System.out.println(num2);
	
}
	public static void main(String [] args) {
		Hw0408 a = new Hw0408(); 
		a.randAvg();
	}

//	3.利用Overloading,設計兩個方法int maxElement(int x[][])與double maxElement(double x[][]),
//	可以找出二維陣列的最大值並回傳,如圖:
	
	public int maxElement(int x[][]) {
		int max = x[0][0];
		for(int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				 if (max < x[i][j]) {
					 max = x[i][j];
				 }
			}
		}
		return max;
	}
	public double maxElement(double x[][]) {
		double max = x[0][0];
		for(int i = 0; i < x.length; i++) {
			for (int j = 0; j < x[i].length; j++) {
				 if (max < x[i][j]) {
					 max = x[i][j];
				 }
			}
		}
		return max;
	}
	public static void main(String [] args) {
		Hw0408 a = new Hw0408(); 
		int[][] intArray = {
			    {1, 6, 3},
			    {9, 5, 2}
			};

			double[][] doubleArray = {
			    {1.2, 3.5, 2.2},
			    {7.4, 2.1, 8.2}
			};
			System.out.println(a.maxElement(intArray));
			System.out.println(a.maxElement(doubleArray));
	}
}
//	4.請設計一個類別MyRectangle:
//	(1) 有兩個double型態的屬性為width, depth
//	(2) 有三個方法:
//	void setWidth(double width): 將收到的引數指定給width屬性
//	void setDepth(double depth): 將收到的引數指定給depth屬性
//	double getArea(): 能計算該長方形的面積
//(3) 有兩個建構子:
//public MyRectangle(): 不帶參數也無內容的建構子
//public MyRectangle(double width, double depth): 傳入的兩個引數會指定給對應的屬性
	class MyRectangle{
		private double width;
		private double depth;
		
		public void setWidth(double width) {
			this.width = width;
		}
		public void setDepth(double depth) {
			this.depth = depth;
		}
		public double getArea() {
			
			return width * depth;
			
		}
		public MyRectangle() {
			
		}
		public MyRectangle(double width, double depth) {
			this.width = width;
			this.depth = depth;
		}
		
	}
	
	
	
	
	
//	5.請另外建立一個MyRectangleMain類別,此類別只有main方法
//	(1) 使用public MyRectangle()建構子建立物件,設定width, depth為10, 20,透過getArea()印出結果
//	(2) 使用public MyRectangle(double width, double depth)建構子建立物件,設定width, depth為10, 20,透過getArea()印出結果


class MyRectangleMain{
	public static void main(String[] args) {
		MyRectangle a = new MyRectangle();
		a.setDepth(20);
		a.setWidth(10);
		System.out.println(a.getArea());
		MyRectangle b = new MyRectangle(10,20);
		System.out.println(b.getArea());
	}
	
}
	



	
	
