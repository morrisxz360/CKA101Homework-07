package homework;

public abstract class  Pen {
	private String brand;
	private double price;
	
	public Pen() {
	}
	public Pen(String brand, double price) {
		this.brand = brand;
		this.price = price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBrand() {
		return brand;
	}
	public double getPrice() {
		return price;
	}
	public abstract void write() ;
	
	public String toString() {
		return "品牌是" + getBrand() + "\n價格是" + getPrice();
	}
	
	public static void main(String[] args) {
		Pen pencil = new Pencil("muji",20.0);
		Pen inkbrush = new Inkbrush();
		inkbrush.setBrand("萬寶龍");
		inkbrush.setPrice(10000); 
		System.out.println(pencil);
		pencil.write();
		System.out.println(inkbrush);
		inkbrush.write();
		
	}

}

	class Pencil extends Pen{
		
		public Pencil() {
			
		}
		public Pencil(String brand,double price) {
			super(brand,price);
		}
		public void write() {
			System.out.println("先削鉛筆在寫字");
		}
		public double getPrice() {
			return (super.getPrice()*0.8);
		}
	}
	
	class Inkbrush extends Pen{
		
		public Inkbrush() {
			super();
		}
		public Inkbrush(String brand,double price) {
			super(brand,price);
		}
		public void write() {
			System.out.println("先沾墨水在寫字");
			}
		public double getPrice() {
			return (super.getPrice()*0.9);
		}
	}
