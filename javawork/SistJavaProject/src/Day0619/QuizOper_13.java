package Day0619;

import java.util.Scanner;

public class QuizOper_13 {

	public static void main(String[] args) {
		/* 
		 * 이름입력 : 
		 * 강호동
		 * 키 
		 * 177.5
		 * 체중 
		 * 88
		 * 
		 * 
		 * **학생 키 정보**
		 * 이름 : 강호동
		 * 키 : 177.5cm
		 * 체중 : 88kg
		 * 
		 * (표준 체중 : (키-100)*0.9))
		 * 권장 표준 몸무개는 69.75입니다.
		 * 
		 *  */
		
		Scanner sc=new Scanner(System.in);
		
		// 변수
		String name;
		double height, weight;
		
		// 입력
		System.out.println("이름 입력 :");
		name=sc.nextLine();
		System.out.println("키 입력 :");
		height=sc.nextDouble();
		System.out.println("체중 입력 :");
		weight=sc.nextDouble();
		
		// 표준 체중 계산
		double st_weight = (height-100)*0.9;
		
		// 출력 정보	
		System.out.println("**학생 키 정보**");
		System.out.println("이름 : "+name);
		System.out.println("키 : "+height+ "cm");
		System.out.println("체중 : "+weight+"kg");
		System.out.printf("권장 표준 체중은 %.2f kg",st_weight);
		
				
	}
	
}

