package Day0620;

import java.util.Scanner;

public class QuizOper_06 {

	public static void main(String[] args) {
		/* 
		 * 이름을 입력하세요.
		 * limcahrd
		 * 3과목의 점수를 입력하세요
		 * 한 과목이 39
		 * 88
		 * 99
		 * ==============================================
		 * 3과목 점수 : 39, 88, 99 나타내자
		 * 평균점수 : 75.3333333333..
		 * ----------------------------------------------
		 * 합격조건 : 평균 60점 이상, 과목별 각 40점 이상
		 * ----------------------------------------------
		 * limcahrd님은 불합격 입니다.
		 * */ 
		
		
		Scanner sc=new Scanner(System.in);
		
		//변수 선언
		String name;
		int kor,mat,eng,tot;
		double avg;
		
		System.out.println("이름을 입력하세요.");
		name=sc.nextLine();
		System.out.println("3과목의 점수를 입력하세요.");
		kor=sc.nextInt();
		mat=sc.nextInt();
		eng=sc.nextInt();
		
		//변수 계산
		tot=kor+mat+eng;
		avg=tot/3.0;
		
		//출력
		System.out.println(name+"님의 한국어 점수는"+kor+"점 입니다.");
		System.out.println(name+"님의 수학 점수는"+mat+"점 입니다.");
		System.out.println(name+"님의 영어 점수는"+eng+"점 입니다.");
		System.out.printf("name 님의 평균 점수는 %.2f점 입니다.\n",avg);
		System.out.println("--------------------\n합격조건 : 평균 60점 이상, 과목별 각 40점 이상\n--------------------");
		
		//if문
		if(kor>=40&&mat>=40&&eng>=40&&avg>=60)
			System.out.println(name+"님은 최종 합격 입니다.");
		else
			System.out.println(name+"님은 최종 불합격 입니다.");
		
		
		
		
		
		
		
		
		
	}

}
