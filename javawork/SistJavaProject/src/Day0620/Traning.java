package Day0620;

public class Traning {

	public static void main(String[] args) {
		// 책보고 나 혼자 따라해보기
		// random으로 숫자 뽑기.
		// 기본이 double이니까 주의.
		// 숫자는 0부터 시작. 1부터 시작하기 위해서 뒤에 +1을 붙여야 함
		// random 뒤에 곱해지는 숫자가 글자가 몇개 쓸건지 적는 것이다.

		int score=(int)(Math.random()*9)+1;
		
		if(score==1)
			System.out.println("ff1");
		else if(score==2)
			System.out.println("ff2");
		else if(score==3)
			System.out.println("ff3");
		else if(score==4)
			System.out.println("ff4");
		else if(score==5)
			System.out.println("ff5");
		else if(score==6)
			System.out.println("ff6");
		else if(score==7)
			System.out.println("ff7");
		else if(score==8)
			System.out.println("ff8");
		else
			System.out.println("ff9");
		
		
		
		
	}

}
