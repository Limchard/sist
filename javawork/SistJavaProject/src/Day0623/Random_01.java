package Day0623;

public class Random_01 {

	public static void main(String[] args) {
		/* 
		 * 자바에서 난수를 구하는 방법 2가지
		 * 1. Math.randor() 메서드를 이용하는 방법 // 기본이 실수(double)인데, 1.0은 불가능함. 0.9999..는 가능.. 그래서 주로 사용할때 int로 형변환 해서 사용한다.
		 * 2. Random 이라는 클래스를 생성해서 구하는 방법  
		 *  */
		
		System.out.println("기본 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			double a=Math.random(); //0.xxxx ~ 0.9XXXX 이다.
			System.out.println(a);
		}
		
		System.out.println("0~9 사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a=(int)(Math.random()*10); // 0에서 9까지의 난수가 발생한다. 
			System.out.println(a);
		}
		
		System.out.println("1~10 사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a=(int)(Math.random()*10)+1; // 1에서 10까지의 난수가 발생한다. 
			System.out.println(a);
		}

		System.out.println("1~10 사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a=(int)(Math.random()*100)+1; // 1에서 100까지의 난수가 발생한다. 
			System.out.println(a);
		
		}
		
		System.out.println("1~10 사이의 난수 5개 발생");
		
		for(int i=1;i<=5;i++) {
			int a=(int)(Math.random()*100); // 0에서 99까지의 난수가 발생한다. 
			System.out.println(a);
		
		}
	}
}
