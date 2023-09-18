package Day0619;


import java.util.Calendar;
import java.util.Scanner;

public class ScannerMyAge_05 {

	public static void main(String[] args) {
		// 
		/* 당신의 이름은? 임형준
		 * 현재년도는? 2023 년
		 * 당신의 출생년도는? 1993년 
		 * ============================
		 * 이름 : 임형준
		 * 현재년도 : 2023년 
		 * 나이 : 30세  */

		// 생성 	
		Scanner sc=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		
		// 변수	
		String name;
		int curYear=cal.get(cal.YEAR); // 2023년
		int myBirth=1993;
		
		// 입력
		System.out.println("당신의 이름은? ");
		name=sc.nextLine();
		System.out.println("당신의 출생년도는 ?");
		myBirth=Integer.parseInt(sc.nextLine());
		
		
		//최종 출력
		
		System.out.println("이름 :"+name);
		System.out.println("현재년도 : "+curYear+"년도");
		System.out.println("나이 :"+(curYear-myBirth+"세"));
		
		
	
	}

}
