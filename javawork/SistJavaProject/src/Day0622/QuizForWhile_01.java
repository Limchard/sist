package Day0622;

public class QuizForWhile_01 {

	public static void quiz1() {
		// for문 가즈아!! 
		// 가로로 출력 _ for _ 1 2 3 4 5 그리고 다음줄에 종료 라고 출력
		
		for(int i=1;i<=5;i++) {
			System.out.print(i+" ");
		}
		System.out.println("\n종료");		
	}

	public static void quiz2() {
		// 가로로 출력 _ for _ 1 2 4 5 7 8 10 출력
		
		for(int i=1;i<=10;i++) {
			if(i%3==0) // 3의 배수 지정하는 식
				continue;
			System.out.print(i+"\t");
		}
		System.out.println("\n종료");
	}

	public static void quiz3() {
		// 안녕 을 가로로 3번 출력하세요
		
		for(int i=1;i<=3;i++)
			System.out.print("안녕   ");
		// for문이 뭐가 되었던 3번만 실행되면 안녕은 3번 출력된다.	
	}

	public static void quiz4() {
		// 1부터 10까지 중 짝수만 가로로 출력하세요.
		
		for(int i=1;i<=10;i++) {
			if(i%2==0)
		System.out.print(i+"  ");
		}

	}

	public static void quiz5() {
		// 1부터 10까지의 합은 55입니다. 
		int sum=0;
		int i=0;
		
		for(i=1;i<=10;i++) {
			sum+=i;
		}
		System.out.println("1부터 "+(i-1)+"까지의 합은 "+sum+"입니다.");

	}

	public static void main(String[] args) {
		
		//quiz1();
		//quiz2();
		//quiz3();
		//quiz4();
		quiz5();
		

	}

}
