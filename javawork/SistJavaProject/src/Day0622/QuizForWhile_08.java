package Day0622;

import java.util.Scanner;

public class QuizForWhile_08 {

	public static void quiz1() {
		
		/* 나이를 반복해서 입력 받을께요
		 * 0이 되면 빠져나와서 출력한다.
		 * 나이가 50이상일 경우 a변수 증가
		 * 나이가 30이상일 경우 b변수 증가
		 * 그 외 c변수를 증가시킨다.
		 * 
		 *  ==================================
		 *  50세 이상 : 3명
		 *  30세 이상 : 2명
		 *  그 외 : 1명 */
		
		Scanner sc=new Scanner(System.in);
		
		int i;
		int a=0,b=0,c=0;
		
		while(true) {
			System.out.println("나이를 입력해주세요.(종료: 0)");
			i=sc.nextInt();
			
			if(i==0)
				break;
			else if(i>=50) 
				a++;			
			else if(i>=30)
				b++;
			else
				c++;
			
		}
		System.out.println("====================");
		System.out.println("50세 이상: "+a);
		System.out.println("30세 이상: "+b);
		System.out.println("그외: "+c);
		
	}
	
	
	public static void quiz2() {
		
		Scanner sc=new Scanner(System.in);
		int age;
		int a=0,b=0,c=0;
		
		while(true) {
			
			System.out.println("나이입력 : ");
			age=sc.nextInt();
			
			//break
			if(age==0) {
				System.out.println("프로그램 종료");
				break;
			}
			
			// 조건.. 인원증가
			if(age>=50)
				a++;
			else if(age>=30)
				b++;
			else
				c++;
								
		}
		System.out.println("50세 이상: "+a+"명");
		System.out.println("30세 이상: "+b+"명");
		System.out.println("그외: "+c+"명");		
		
	}
	
	public static void quiz3() {
		// Q. 총 10개의 다양한 숫자(양수,음수)를 입력받아 양수의 갯수와 음수의 갯수를 구하시오.
		/* 1: 45
		 * 2: -23
		 * 3: 0
		 * 
		 *  ==========
		 *  양수갯수 : 6개
		 *  음수갯수 : 3개 */
		
		Scanner sc=new Scanner(System.in);
		
		int a;
		int pn=0,nn=0;
		
		for(int i=1;i<=10;i++) {
			System.out.println("숫자를 입력해주세요.");
			a=sc. nextInt();
			
			if(a>0) 
				pn++;
			else if(a<0)
				nn++;
			
		}	
		System.out.println("=======================");
		System.out.println("양수갯수 : "+pn);
		System.out.println("음수갯수 : "+nn);
	}
	
	
	public static void main(String[] args) {
		
//		quiz1(); 
//		quiz2(); // 선생님 풀이	
		quiz3();
		
	}

}
