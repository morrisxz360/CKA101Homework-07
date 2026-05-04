package hw8;

class WaitAndSee {
	private int money = 0;

	synchronized public void deposit(int money) {
		while (this.money > 3000) {
			System.out.println("老媽覺得你錢太多，不給了");
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("媽媽被熊大要求匯款");
		}
		this.money += money;
		System.out.println("媽媽存了" + money + "，帳戶共有:" + this.money);
		notify();

	}

	synchronized public void withdraw(int money) {
		while (this.money < 1000) {
			System.out.println("熊大看到帳戶裡沒錢,停止提款");
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println("熊大被告之老媽匯款了");
		}
		if (this.money <= 2000) {
			System.out.println("熊大請求支援，要求匯款");
		}
		this.money -= money;
		System.out.println("熊大領了 " + money + "帳戶還有" + this.money);
		notify();
	}

}

class Son extends Thread {
	WaitAndSee account ;
	
	public Son(WaitAndSee account) {
		this.account = account;
	}
	
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			account.withdraw(1000);
		}
	}
	
}

class Mom extends Thread {
	
	WaitAndSee account ;
	
	public Mom(WaitAndSee account) {
		this.account = account;
	
	}
	
	public void run() {
		for(int i = 0 ; i < 10 ; i++) {
			account.deposit(2000);
		}
	}
}


public class Wait {

	public static void main(String[] args) {
		
		WaitAndSee account = new WaitAndSee();
		Mom mom = new Mom(account);
	    Son son = new Son(account);
	    mom.start();
	    son.start();
	}

}
