package Day0619;

public class IfTest_14 {

	public static void main(String[] args) {
		// 
		/*
		int n=20;
		
		if(n>=100) // 블락괄호가 없을 시 if의 조건은 아래 한줄 까지만이다.
			System.out.println("n은 100보다 크거나 같다");
			System.out.println("프로그램종료!!!");
			
		if(n<=100) {
			System.out.println("n은 100보다 크거나 같다");
			System.out.println("******");
			System.out.println("프로그램종료!!!");}

			*/
		
		/*
		
		// 홀수인지 짝수인지 구하기
		int i=10;
		
		if(i%2==1)
			System.out.println(i+" 홀수 입니다.");
		else
			System.out.println(i+" 짝수 입니다.");
		
		*/
		
		
		// if문을 이용해서 학점 구하기 .. 90이상 A, 80이상 B, ... 60이상 D, 60미만 F
		
		int score=88;
		
		/* if else 사용 
		
		if(score>=90) 
			System.out.println("학점은 A 입니다.");
		else if(score>=80)
			System.out.println("학점은 B 입니다.");
		else if(score>=70)
			System.out.println("학점은 C 입니다.");
		else if(score>=60)
			System.out.println("학점은 D 입니다.");
		else
			System.out.println("학점은 F 입니다.");
			*/
		
		//grade 사용 
		String grade;
		
		if(score>=90) 
			grade="A";
		else if(score>=80)
			grade="B";
		else if(score>=70)
			grade="C";
		else if(score>=60)
			grade="D";
		else
			grade="F";
		System.out.println("학점은 "+grade+"입니다.");
		
		
		
		// 학점을 삼항연산자를 이용하여 구해보기 
		
//		char grade=(score>=90)?'A':(score>=80)?'B':(score>=70)?'C':(score>=60)?'D':'F';
//			
//		System.out.println("학점은 "+grade+"입니다.");
//		
		
		
	}

}
