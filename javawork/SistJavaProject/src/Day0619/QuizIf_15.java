package Day0619;

import java.util.Scanner;

public class QuizIf_15 {

	public static void main(String[] args) {
		// 점수를 입력하여 평가를 출력하시오.
		/* 
		 * 당신의 점수는 ? 88
		 * ======================================================
		 * 90점 이상:장학생, 80점 이상:우수상, 80점 미만:재시험
		 * =====================================================
		 * 당신은 우수상~~~
		 */
		
		Scanner sc=new Scanner(System.in);
		
	/*	int score=88;
		
		String grade=(score>=90)?"장학생":(score>=80)?"우수상":"재시험";
		
		System.out.println("당신은 "+grade+"~~~");
		
		*/
		
		int score;
		System.out.println("당신의 점수는 ?");
		score=sc.nextInt();
		
		
		if (score>=90)
			System.out.println("장학생~~~");
		else if (score>=80)
			System.out.println("우수상~~~");
		else 
			System.out.println("재시험!!!");
		
		
		// 선생님 풀이
		/*
		Scanner sc=new scanner(System.in);
		int score;
		String msg;
		
		System.out.println("당신의 점수는? ");
		score=sc.nextInt();
		
		//점수별 평가
		msg=score>=90?"장학생":
			score>=80?"우수상":"재시험";
			
		//결과 출력
		System.out.println("당신은 "+score+"점 이므로 평가는 "+msg+"~~~");
		
		*/
		
	}

}
