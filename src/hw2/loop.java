package hw2;

public class loop {

	public static void main (String[] args) {

//• 請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		int sum = 0;
		for ( int a = 1 ; a <= 1000 ; a++) { 
			if (a%2 == 0) {
				sum += a ;
			}
		}
		System.out.println(sum);


//• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		int sum1 = 1;
		for (int a = 1 ; a<= 10 ; a++) {
			sum1 *= a;
		}
		System.out.println(sum1);

//• 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		int sum2 = 1 ; 
		int a = 1;
		while(a <=10 ) {
			sum2 *= a ;
			a++ ;
		}
		System.out.println(sum2);



//• 請設計一隻Java程式,輸出結果為以下:
//1 4 9 16 25 36 49 64 81 100
	
		for (int b = 1 ; b < 10 ; b++) {
			System.out.print(b*b+" ");
			
		}

		System.out.println();
//• 阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。請設計一隻程式,
//輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		int sum4 = 0;
		for (int c = 1 ; c<= 49 ; c++) {
			if (c < 40 && c % 10 != 4) {
				
					System.out.print(c + " ");
					sum4 += 1 ;
			}
		}
		System.out.println();
		System.out.print("可以選的數字總共有：" + sum4);


		System.out.println();

//• 請設計一隻Java程式,輸出結果為以下:
//1 2 3 4 5 6 7 8 9 10
//1 2 3 4 5 6 7 8 9
//1 2 3 4 5 6 7 8
//1 2 3 4 5 6 7
//1 2 3 4 5 6
//1 2 3 4 5
//1 2 3 4
//1 2 3
//1 2
//1
		for (int e = 10 ; e > 0 ; e--) {
			for (int d = 1 ; d <= e ; d++) {
				System.out.print(d+ " ");
			
		}
		System.out.println();
	}


//• 請設計一隻Java程式,輸出結果為以下:
//A
//BB
//CCC
//DDDD
//EEEEE
//FFFFFF
		char A = 65  ;
		for(int h=1;h<=6;h++) {
			for (int g = 1 ; g <=h ; g++) {
				if(g<h)
				System.out.print(A);
				else
				System.out.print(A++);
			}
			System.out.println();
		}
	}
		
		
	
	}

