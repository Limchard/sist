package spring.di.ex2;

public class Person {

	String schoolName;
	MyInfo info;
	
	// 생성자 주입
	public Person(MyInfo info) {
		super(); // super는 생략 가능.
		this.info=info;
	}
	// setter 주입
		public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
		
	// 출력
	public void writeData() {
		System.out.println("** 학생 정보 출력 **");
		System.out.println("학교명: "+schoolName);
		System.out.println("학생명: "+info.name);
		System.out.println("나이: "+info.age);
		System.out.println("주소: "+info.addr);
	}
	
	
	
	
}
