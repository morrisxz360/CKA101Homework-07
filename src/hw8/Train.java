package hw8;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Train implements Comparable<Train> {

	protected int number;
	protected String type;
	protected String start;
	protected String dest;
	protected double price;

	public Train() {

	}

	public Train(int number, String type, String start, String dest, double price) {
		this.setNumber(number);
		this.setType(type);
		this.setStart(start);
		this.setDest(dest);
		this.setPrice(price);

	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getDest() {
		return dest;
	}

	public void setDest(String dest) {
		this.dest = dest;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String toString() {
		return ("班次" + number + ",車種" + type + ",出發地" + start + ",目的地" + dest + ",票價" + price);
	}

	
	public int compareTo(Train o) {

		return o.number - this.number;
	}

	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (!(obj instanceof Train))
			return false;
		Train other = (Train) obj;
		return this.number == other.number && this.type.equals(other.type) && this.start.equals(other.start)
				&& this.dest.equals(other.dest) && this.price == other.price;
	}
	
	public int hashCode() {
		return Objects.hash(number, type, start, dest, price);
	}

	
	public static void main(String[]args) {
		
		Train t1 = new Train(202, "普悠瑪", "樹林", "花蓮", 400);
		Train t2 = new Train(1254, "區間", "屏東", "基隆", 700);
		Train t3 = new Train(118, "自強", "高雄", "台北", 500);
		Train t4 = new Train(1288, "區間", "新竹", "基隆", 400);
		Train t5 = new Train(122, "自強", "台中", "花蓮", 600);
		Train t6 = new Train(1222, "區間", "樹林", "七堵", 300);
		Train t7 = new Train(1254, "區間", "屏東", "基隆", 700);  
		
		
		Set<Train> set = new HashSet<>() ;
			
		set.add(t1);
		set.add(t2);
		set.add(t3);
		set.add(t4);
		set.add(t5);
		set.add(t6);
		set.add(t7);
		
		for(Train t :set) {
			
			System.out.println(t);
		}
		
		System.out.println("=====================");
		
		List<Train> list = new ArrayList<>();
		list.add(t1);
		list.add(t2);
		list.add(t3);
		list.add(t4);
		list.add(t5);
		list.add(t6);
		list.add(t7);
		Collections.sort(list);
		for(int i = 0 ; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		Set<Train> set1 = new TreeSet<>();
		
		set1.add(t1);
		set1.add(t2);
		set1.add(t3);
		set1.add(t4);
		set1.add(t5);
		set1.add(t6);
		set1.add(t7);
		
		Iterator<Train> it = set1.iterator();
			
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
		

}
