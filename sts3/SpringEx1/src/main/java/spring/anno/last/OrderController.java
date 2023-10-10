package spring.anno.last;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("oc")
public class OrderController {
	
	@Autowired
	ShopInter shopInter;
	
	int cnt=10;
	String name="홍성경";
	
	public void insertOrder(String sang,int price,String color) {
		shopInter.insertSangpum(sang, price, color);
		System.out.println(name+"님이"+cnt+"개를 주문 했습니다."); // insert를 제외한 나머지 로직들도 실행가능하다.	
	}
	public void deleteOrder(String num) {
		shopInter.deleteSangpum(num);
	}
	public void selectOrder(String sang,int price,String color) {
		System.out.println("주문자: "+name);
		shopInter.selectshop(sang, price, color);
		System.out.println("주문갯수: "+cnt);
	}
	
}
