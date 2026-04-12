package homework;
import java.util.Scanner;
public class Hw0331 {
	
//	• 有個一維陣列如下:
//	{29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//	請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
//	(提示:陣列,length屬性)
	public static void main(String[] args) {
	int[] x = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
	int[] y = new int [10];
	double sum = 0;
	double sum2 = 0;
	for(int i = 0; i < x.length ; i++) {
		sum += x[i];
		y[i]+= x[i];
	}
	sum2 = sum/x.length;
	System.out.println("陣列的平均值是：" + sum2);
	System.out.print("比平均值大的是：");
	for(int i = 0; i<10 ; i++) {
		if (y[i] > sum2) {
			System.out.print(y[i] + " ");
		}
	}
	System.out.println();
	
	
//	• 請建立一個字串,經過程式執行後,輸入結果是反過來的
//	例如String s = “Hello World”,執行結果即為dlroW olleH
//	(提示:String方法,陣列)
	String s[] = {"H","e","l","l","o"," ","W","o","r","l","d"};
	for(int i = 10;i > -1 ;i--) {
		System.out.print(s[i]);
	}
	System.out.println();
	
	
//	• 有個字串陣列如下 (八大行星):
//	{“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//	請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)
//	(提示:字元比對,String方法)
	String h [] = {"mercury", "venus", "earth", "mars", "jupiter", "saturn","uranus","neptune"};
	int count = 0 ;
	for(int i = 0; i < 8; i++) {
		for(int m = 0; m <h[i].length() ; m++) {
			switch(h[i].charAt(m)) { 
				case'a':
					count++; 
					break;
				case'e':
					count++;
					break;
				case'i':
					count++;
					break;
				case'o':
					count++;
					break;
				case'u':
					count++;
					break;
				
			}
		}
	}
	System.out.println(count);
	
//	阿文上班時忘了帶錢包,想要向同事借錢,和他交情比較好的同事共有 5 個,其員工編號與身上現金列
//	表如下:
//  請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事
//	有錢可借他;並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的
//	員工編號: 25 19 27 共 3 人!」
//	(提示:Scanner,二維陣列)
	
	Scanner scn = new Scanner(System.in);
	System.out.println("你想借多少：");
	int money = scn.nextInt();
	int num = 0;
	int[][]lend = {{2500, 800, 500, 1000, 1200},
	                { 25,  32,   8,   19,   27}};
	System.out.print("有錢可借的員工編號：");
		for(int z = 0; z < 5; z++) {
			if(money < lend[0][z]) {
			num++;
			
			System.out.print(lend[1][z] + " ");	
			}
	}
		
		System.out.println("總共" + num + "人!");

	
//	• 請設計由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,執行後會顯示是該年的第幾天
//	例:輸入 1984 9 8 三個號碼後,程式會顯示「輸入的日期為該年第252天」
//
//	(提示1:Scanner,陣列)
//	(提示2:需將閏年條件加入)
//	(提示3:擋下錯誤輸入:例如月份輸入為2,則日期不該超過29)
	while(true){
		System.out.println("請輸入年份月份以及日期:");
		int year = scn.nextInt();
		int month= scn.nextInt();
		int day = scn.nextInt();
	    int sum1=0;
	    int[]days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	    if ((year % 4 == 0 && year % 100 != 0) ||(year % 400 == 0)) {
	    	days[1] = 29; 
		 }
	    if (day <= days[month-1]) {
	    	for(int i = 0; i<(month-1); i++) {
	    		sum1 += days[i];
	    	}
	    	System.out.println("總共是：" + (sum1 + day) + "天。");
	    	break;
	     }else {
	    	System.out.println("輸入錯誤請重新輸入"); 
	    	continue;
	    }
	}
	
//	• 班上有8位同學,他們進行了6次考試結果如下:
//		請算出每位同學考最高分的次數
//		(提示:二維陣列)
	int[] count1 = new int[8];
	int q1[][]= {{ 10, 35,  40, 100, 90, 85, 75, 70},
				 { 37, 75,  77,  89, 64, 75, 70, 95},
				 {100, 70,  79,  90, 75, 70, 79, 90},
				 { 77, 95,  70,  89, 60, 75, 85, 89}, 
				 { 98, 70,  89,  90, 75 ,90, 89, 90},
				 { 90, 80, 100,  75, 50, 20, 99, 75}};
	for(int i = 0; i < 6; i++) {
		int max = q1[i][0];
		for(int j = 0; j < 8; j++) {
			if ( q1[i][j]> max ) {
				max = q1[i][j];
			}	 
		}
		for(int k = 0; k < 8; k++) {
			if(max == q1[i][k]) {
				count1[k]++;
			}
		}	
	}
	for(int i=0; i < 8;i++) {
		System.out.println((i+1) + "號同學考了最高分" + count1[i] + "次");
	}
	scn.close();
	}
	
}

