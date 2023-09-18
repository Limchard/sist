package Day0620;

import java.util.Calendar;
import java.util.Scanner;

public class ScannerReview_01 {

	public static void main(String[] args) {
		/* 
		 * 태어난연도 : 1993
		 * 이름 : 임형준
		 * 핸드폰 번호: 010-4587-5870
		 * 주소 : 서울시 관악구
		 * ====================================
		 * [개인정보]	
		 * 이름 : 임형준
		 * 나이 : 30세
		 * 연락처 : 010-4587-5870
		 * 주소 : 서울시 관악구 
		 * 
		*/
		
		
		// import
		Scanner sc=new Scanner(System.in);
		Calendar cal=Calendar.getInstance();
		
		// 변수선언	
		String name,phone,addr;
		int age,birthYear;
		
		
		// 입력
		
		System.out.println("태어난 연도는? :");
		//birthYear=sc.nextInt();
		birthYear=Integer.parseInt(sc.nextLine());
		//Integer.paraseInt("1993") => 1993  String==int
		System.out.println("이름 : ");
		name=sc.nextLine();
//		System.out.println("나이 : ");
//		age=Integer.parseInt(sc.nextLine());
//		age=sc.nextInt();
		System.out.println("핸드폰 번호 :");
		phone=sc.nextLine();
		System.out.println("주소 : ");
		addr=sc.nextLine();
		
		// 나이 계산
		age=cal.get(cal.YEAR)-birthYear;
		
		// 출력
		System.out.println("==============================\n [개인정보]");
		System.out.println("이름 : "+name);
		System.out.println("나이 : "+age);
		System.out.println("연락처 : "+phone);
		System.out.println("주소 :"+addr);
		
		
		
		
		
		
	}

}
