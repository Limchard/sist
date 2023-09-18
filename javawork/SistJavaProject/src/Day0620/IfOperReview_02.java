package Day0620;

import java.util.Scanner;

public class IfOperReview_02 {

	public static void main (String[] age) {
		
		/* 
		 * 평가메세지 : 90점 이상 참잘함, 80점 이상이면 잘함, 80점 미만:다음기회에
		 * 학점 : 90점 이상 A, 80 B 80 미만 C
		 * 평가메세지 : 삼항연산자, 학점은 if문
		 * 점수를 입력하세요
		 * 88 점
		 * =============================
		 * 점수 : 88점
		 * 평가메세지 : 잘함
		 * 학점 : B
		 * 
		 * 
		 */
		
		Scanner sc=new Scanner(System.in);
		
//		int score;
//		System.out.println("점수를 입력하세요");
//		score=sc.nextInt();
//		
//		String grade=(score>=90)?"참잘함":(score>=80)?"잘함":"다음기회에...";
//		System.out.println(grade);
//		
//		
//		if(score>=90)
//			grade="A";
//		else if(score>=80)
//			grade="B";
//		else
//			grade="C";
//		System.out.println("학점 :"+grade);
//		
//		
//		if(score>=90)
//			System.out.println("학점 : A");
//		else if(score>=80)
//			System.out.println("학점 : B");
//		else
//			System.out.println("학점 : C");
		
	// 선생님 풀이
		
		int score;
		String msg,grade;
		
		//입력
		System.out.println("점수를 입력하세요");
		score=sc.nextInt();
		
		//점수별 메세지
		msg=score>=90?"참잘함":score>=80?"잘함":"다음기회에...";
			
		// 학점
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
		
		// 출력
			System.out.println("[결과출력]");
			System.out.println("점수 :"+score);
			System.out.println("평가 메세지 :"+msg);
			System.out.println("학점 :"+grade);
			
		
	}
	
}
