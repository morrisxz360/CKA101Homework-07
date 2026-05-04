package hw8;

public class Multithreads implements Runnable{
//	• 開啓2個執行緒模擬饅頭人與詹姆士參加快胃王比賽所做的
//	競賽過程。
//	• 每個動作都以 Thread.sleep()暫停一下,以達到顯示效果。
//	Sleep時間由亂數產生500~3000之間的毫秒數,如圖所示
//	• 參考範例:CounterRunnable.java
//	• 需留意主執行緒執行順序
	
	private String name;
	
	
	public Multithreads() {
		
	}
	public Multithreads(String name) {
		this.name = name;
	}
	
	public void run() {
		int total = 1;
		while (total < 11) {
			System.out.println(name + "吃了第" + total + "碗飯");
			total++;
			try {
				Thread.sleep((int)(Math.random()*2501+500));
			}catch(Exception e) {
				
			}
		}
		System.out.println(name + "吃完了！");
	}
	public static void main(String[] args) {
		Multithreads m1 = new Multithreads("詹姆士");
		Thread t1 = new Thread(m1);
		Multithreads m2 = new Multithreads("                     饅頭人");
		Thread t2 = new Thread(m2);
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
			System.out.println("＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝＝");
			System.out.println("           大胃王比賽結束！");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
}
