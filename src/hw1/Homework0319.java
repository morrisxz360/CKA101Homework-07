package hw1;

public class Homework0319 {
//	• 請設計一隻Java程式,計算12,6這兩個數值的和與積
	
	public static void main (String[] args) {
		int a = 12 , b = 6 ;
		int sum1 = (a + b) ;
		int sum2 = (a * b);
		System.out.println("12與6的和是" + sum1);
		System.out.println("12與6的積是" + sum2);
		//		利用int宣告a,b兩個變數再把他們做相加與相乘，最後列印出來。
		
		
//	• 請設計一隻Java程式,計算200顆蛋共是幾打幾顆? (一打為12顆)
		
		int c = 200 , d = 12 ;
		int sum3 = (c/d);
		int sum4 = (c%d);
		System.out.printf("200顆蛋總共是%d打，剩下%d顆\n", sum3 , sum4);
		//		利用int 宣告ｃ,ｄ兩個變數然後將它們相除後取餘數後列印出來，
		//      %d整數\n換行後填入變數。
		
		
//	• 請由程式算出256559秒為多少天、多少小時、多少分與多少秒
		
		int e = 256559 ;
		int day = (e/60/60/24);
		int hour = (e/60/60%24);
		int minute =(e/60%60);
		int second = (e%60);
		System.out.printf("256559秒為%d天%d小時%d分%d秒\n" , day,hour,minute,second);
		//		先宣告 e為總秒數,宣告day為總秒數除60秒60分24小時後得到天數
		//		宣告 hour為總秒數除以60秒60分取除以24小時的餘數為多的小時		
		//		宣告 minute為總秒數除以60秒取除以60分鐘的餘數為多的分鐘	
		//		宣告 second為總秒數除以60秒取餘數為多的秒數
		//		最後列印
		
		
//	• 請定義一個常數為3.1415(圓周率),並計算半徑為5的圓面積與圓周長
		
		final double pi = 3.1415;
		int circleHalf = 5 ;
		double area = (pi * Math.pow(circleHalf, 2));
		double cir = (2 * pi * circleHalf);
		System.out.printf("半徑為五的圓面積是%.4f，圓周長是%.4f\n",area,cir);
		
	
		
//	• 某人在銀行存入150萬,銀行利率為2%,如果每年利息都繼續存入銀行,請用程式計算10年後,本
//	金加利息共有多少錢 (用複利計算,公式請自行google)
		
		double money = 1500000 ;
		double allMoney = money* Math.pow(1.02 , 10);
		double interest = (allMoney - money);
		System.out.printf("本金是%.0f元，利息是%.0f元，存入10年後銀行複利總和是%.0f元\n" ,money,interest,allMoney);
		
		
//	• 請寫一隻程式,利用System.out.println()印出以下三個運算式結果:
//	5 + 5
//	5 + ‘5’
//	5 + “5”
		
		int x = 5 + 5;
		int y = 5 + '5';
		String z = 5 + "5";
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		
		
	
			
	}

}
