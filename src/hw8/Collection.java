package hw8;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection {

//	• 請建立一個Collection物件並將以下資料加入:
//		Integer(100)、Double(3.14)、Long(21L)、Short(“100”)、Double(5.1)、“Kitty”、Integer(100)、
//		Object物件、“Snoopy”、BigInteger(“1000”)
//
//		• 印出這個物件裡的所有元素(使用Iterator, 傳統for與foreach)
//		• 移除不是java.lang.Number相關的物件
//		• 再次印出這個集合物件的所有元素,觀察是否已將非Number相關的物件移除成功
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(new Integer(100));
		list.add(new Double(3.14));
		list.add(new Long(21L));
		list.add(new Short("100"));
		list.add(new Double(5.1));
		list.add(new String("Kitty"));
		list.add(new Integer(100));
		list.add(new Object());
		list.add(new String("Snoopy"));
		list.add(new BigInteger("1000"));

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		for(Object o :list) {
			System.out.println(o);
			}

		Iterator<Object> objs = list.iterator();
		while (objs.hasNext()) {

			System.out.println(objs.next());
		}

		Iterator<Object> a = list.iterator();
		while(a.hasNext()) {
			Object o = a.next();
			if(!(o instanceof Number)) {
				a.remove();
			}
		}
	
		Iterator<Object> I =list.iterator();
		while(I.hasNext()) {
			System.out.println(I.next());
		}
	}



}
