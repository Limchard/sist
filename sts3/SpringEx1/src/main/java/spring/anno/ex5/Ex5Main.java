package spring.anno.ex5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex5Main {

	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		Fruit fruit=(KoreaFruit)app.getBean("kfruit");
		fruit.writeFruitName();
		
		MyFruit myfruit=(MyFruit)app.getBean("myFruit");
		myfruit.writeFruit();

	}

}
