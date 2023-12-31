package Day0619;

import java.util.Calendar;
import java.util.Scanner;

public class OperTest_12 {

	public static void main(String[] args) {
		// 삼항연산자로 조건 12개 태어난연도로 띠 구해보기
		// 로직에서는 언제나 시작은 원숭이띠 
		
		Scanner sc=new Scanner(System.in);
		int myYear,age;
		String name,ddi;
		
		System.out.println("이름입력 :");
		name=sc.nextLine();
		
		System.out.println("태어난 연도 입력 :");
		myYear=sc.nextInt();
		
		Calendar cal=Calendar.getInstance();
		age=cal.get(cal.YEAR)-myYear;
		
		//로직에서 사용순서는 원숭이부터.
		ddi=myYear%12==0?"원숭이":
			myYear%12==1?"닭":
				myYear%12==2?"개":
					myYear%12==3?"돼지":
						myYear%12==4?"쥐":
							myYear%12==5?"소":
								myYear%12==6?"호랑이":
									myYear%12==7?"토끼":
										myYear%12==8?"용":
											myYear%12==9?"뱀":
												myYear%12==10?"말":"양";

		System.out.println("**나이와 띠 구하기**");
		System.out.println("이름 :"+name);
		System.out.println("나이 :"+age);
		System.out.println("띠 :"+ddi);
		
		
	}

}
