package spring.anno.ex6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex6Main {

	public static void main(String[] args) {
		
		ApplicationContext app=new ClassPathXmlApplicationContext("annoContext4.xml");
		
		MysqlController cont=(MysqlController)app.getBean("mysqlc");
		
		cont.myinsert("홍성경");
		cont.mydelete("3");
		cont.myselect("송주영");
		
	}

}
