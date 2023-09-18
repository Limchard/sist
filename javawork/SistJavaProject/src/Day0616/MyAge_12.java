package Day0616;

import java.util.Calendar;

public class MyAge_12 {

	public static void main(String[] args) {
		/* 매개변수 args에서 실행시 이름과 태어난 연도를 보낸 후 출력하세요(name,myBirth)
		 * 이름 : 임형준
		 * 태어난 연도: 1993년도
		 * 나이 : 31세
		 * 
		 * -------------------------
		 * 현재년도는 calendar import하여 구할 수 있다.
		 * */

		// 1.import
			
		Calendar cal=Calendar.getInstance();
		
		// 2. 변수 선언
		String name = args[0];
		int myBirth = Integer.parseInt(args[1]);
		
		int curYear = cal.get(cal.YEAR); // 현재년도
		
		// 3. 계산
		
		int myAge = curYear-myBirth;
		
		// 4. 출력
		System.out.println("이름 : "+name);
		System.out.println("태어난 연도 : "+myBirth+"년도");
		System.out.println("나이 : "+myAge+"세");
		
			
	}

}
