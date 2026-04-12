package hw3;

import java.util.Scanner;

public class Hw0329 {
	
	
             //老師我想練習一下物件所以我把他們建立在上面
	public void triangle(int a,int b,int c) {
		if((a>b&&a>c && (a*a)==(b*b)+(c*c))||(b>c&&b>a && (b*b)==(a*a)+(c*c))||(c>b&&c>a && (c*c)==(a*a)+(b*b))) {
			System.out.println("這是直角三角形");
		}
		else if (a == b && b==c){
			System.out.println("這是正三角形。");
		}
		else if ((a==b && b!=c)||(b==c && c!=a)||(c==a && b!=a)){
			System.out.println("這是等腰三角形");
	    }
		else 
			System.out.println("這是其他三角形。");
	}
	
	
	public static void main(String[] args) {
		
		
		
// 請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、等腰	三角形、其它三角形或不是三角形

		
	Scanner scn = new Scanner(System.in);
	Hw0329 x = new Hw0329();
	System.out.println("請輸入三個整數：");
	int a = scn.nextInt();
	int b = scn.nextInt();
	int c = scn.nextInt();
	
	if(a+b>c && b+c>a && a+c>b) {
		x.triangle(a, b, c);
	}else
	System.out.println("這不是三角形。");
	
	
	
//請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜對則顯示正確訊息
	
	
	
	int num = (int)(Math.random()*100)+1;
	System.out.println("請從1-100選擇一個數字：\t");
	int type = scn.nextInt();
	
	while(type != num) {
		System.out.print("請再試一次，");
		if(type>num) {
			System.out.println("請往" + type + "以下猜\t");
		}else {
			System.out.println("請往" + type + "以上猜\t");
		}
		type=scn.nextInt();
	}
	System.out.println("恭喜答對!!!");

	
	
	
	
	
	
//	阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討
//	厭哪個數字,請您設計一隻程式,讓阿文可以輸入他不想要的數字(1~9),畫面會顯示他可以選擇
//	的號碼與總數(進階挑戰:輸入不要的數字後,直接亂數印出6個號碼且不得重複)
	

		System.out.println("請輸入你今天不想要的數字:");  
		int un = scn.nextInt();
		int count = 0;
		int index = 0;
		int[]lot = new int[50];                             //創建兩個陣列一個用於列印出過濾的數字，另一個儲存這些數字。
		int[]lot2 = new int[50];
			for(int i = 1; i <= 49;i++) { 				    //迴圈從１開始因為只需要１－４９。
				lot[i]=i; 								    //利用除以10過濾掉不要的十位數，以及除以10後的餘數過濾個位數只要符合其中一個就過濾掉。
				if(lot[i] / 10 == un || lot[i] % 10 == un) {
				}else {   
					System.out.printf("%2d\t",lot[i]);	    //使用％2d\t將整數對齊。
					lot2[index] = lot[i];				    //將每一次lot[i]的數值結果存入空的lot2[index]。
					count++;  							    //計數器從零開始每經過一次加一。
					index++;  							    //每經過一次將空格換成新的一個新的。
				if( count % 8 == 0) { 					    //每印出8個換行讓表格整齊。
						System.out.println();
				}
				}
		}
		System.out.println("總共有" + count + "個數字。" ); 
		
		System.out.println();
		System.out.println("幫您隨機選六個數字：");
		
		int[]lot3 = new int[6];                      //建立只有六個數字的第三個陣列。
		for(int i = 0 ; i < 6 ; i++) {
			int g =lot2[(int)(Math.random()*count)]; //由於lot2有count個，所以利用隨機方法將lot2的索引值隨機取出後取得lot2的值
			for(int j = 0; j < i; j++) {		     //在利用一個迴圈確認重複，由於j要小於i所以lot3[0]直接寫入。
				if(g == lot3[j]){					 //如果第二個g等於第一個lot3[0]會直接再用一次隨機方法抓一個出來以此類推。
					g = lot2[(int)(Math.random()*count)];
					j = -1;							 //並且將j設為-1隨後j++從lot3[0]開始檢查確保每個數字不重複。
				}
			}
			lot3[i] = g;
			System.out.print(lot3[i] + " ");
			
		}
		scn.close(); 
	}
	
}

	


