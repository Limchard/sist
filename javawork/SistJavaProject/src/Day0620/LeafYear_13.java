package Day0620;

import java.util.Scanner;

public class LeafYear_13 {

	public static void main(String[] args) {
		/* 년도를 입력하자.
		 * 4로 나누면 윤년
		 * 100으로 나누어 나머지가 0이면, 평년
		 * 400으로 나누어 나머지가 0이면, 윤년    */

		Scanner sc=new Scanner(System.in);
		int year;
				
		System.out.println("년도를 입력하세요.");
		year=sc.nextInt();
		
		if(year%4==0&&year%100!=0||year%400==0)
			System.out.println(year+"년도는 윤년입니다.");
		else
			System.out.println(year+"년도는 평년입니다.");
		
		
	}

}
