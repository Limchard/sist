package framework.di.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("자바 방식으로 Hello 메서드 호출하기");
		
		Hello hello1=new Hello();
		System.out.println(hello1.getMessage());
		
		Hello hello2=new Hello();
		System.out.println(hello2.getMessage());
		
		System.out.println(hello1==hello2); // java에서는 new로 생성 할때마다 다른 주소에 생성된다. 즉, hello1과 hello2는 주소값이 다르다. 아래 값 : false
		
		System.out.println("스프링방식으로 Hello 메서드 호출하기");
		// xml 파일 가져오기.. 오늘만 xml 이용해서 사용하기 때문에 
		// 웹으로 실행시에는 web.xml에 설정이 되어있으므로 필요 없음
		
		ApplicationContext app1=new ClassPathXmlApplicationContext("helloContext.xml");
		
		// hello 객체 생성
		Hello h1=(Hello)app1.getBean("hello"); // 방법 1,,,, getBean 괄호 안에는 helloContext.xml 파일에서 bean의 name 에 적었던 것 넣어야 함.	
		System.out.println(h1.getMessage());
		
		Hello h2=app1.getBean("hello", Hello.class); // 방법 2 ,,,, .class 까지 꼭 적어줘야 한다. 
		System.out.println(h2.getMessage());
		
		System.out.println(h1==h2); // 생성주소가 같다(true). 스프링에서는 기본이 싱글톤이기 때문이다. 
		
	}

}
