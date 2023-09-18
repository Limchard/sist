package Day0616;

import java.util.Calendar;
//import java.util.Date;

public class CalendarTest_11 {

	public static void main(String[] args) {
		// 

//		Date date=new Date(); // Date라는 class를 쓸꺼야. 이름은 date야.
		
//		System.out.println("지금은"+(date.getYear()+1900));

		Calendar cal = Calendar.getInstance(); // 달력, 수학공식 등 이미 정해진 것은 'new'를 이용하지 않고 Instance로 할 수 있다.
		// 위에서 'cal'은 참조변수명 이라고 한다.
		
		System.out.println("지금은 "+cal.get(cal.YEAR)+"년도입니다");
		System.out.println("지금은 "+(cal.get(cal.MONTH)+1)+"월 입니다"); // 월은 한달 덜 나온다. 그래서 +1을 해줘야 한다.
		System.out.println("지금은 "+cal.get(cal.DATE)+"일 입니다.");
		System.out.println("지금은 "+cal.get(cal.DAY_OF_MONTH)+"일 입니다.");
		System.out.println("지금은 "+cal.get(cal.HOUR)+"시 입니다.");
		System.out.println("지금은 "+cal.get(cal.HOUR_OF_DAY)+"시 입니다.");
		System.out.println("지금은 "+cal.get(cal.MINUTE)+"분 입니다.");
		System.out.println("지금은 "+cal.get(cal.SECOND)+"초 입니다.");
		System.out.println("지금은 "+cal.get(cal.HOUR_OF_DAY)+"시"+cal.get(cal.MINUTE)+"분"+cal.get(cal.SECOND)+"초 입니다.");
	
	
		
	}

}