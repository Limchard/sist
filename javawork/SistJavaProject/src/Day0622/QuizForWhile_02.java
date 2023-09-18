package Day0622;

import java.util.Scanner;


public class QuizForWhile_02 {

	public static void quiz1() {
		// 점수를 반복해서 입력하면 합계를 구하시오.
		// 1~100 이 아니면 제외
		// 0을 입력하면 프로그램 종료 
		
		Scanner sc=new Scanner(System.in);		
		int i; // 입력할 점수 
		int sum=0;
		
		while(true) {
			System.out.println("점수를 입력하세요.");
			i=sc.nextInt();			
			if(i==0) // break문은 항상 맨 위에 쓴다. 그래야 continue와 겹치지 않는다.	
				break;
			if(i<1||i>100) //continue가 break 위로 가면 0을 눌렀을 시 다시 위로 올라간다. 즉 break가 먹지 않는다.				
				continue;		
			sum+=i; // sum=sum+i
		}
		System.out.println("점수의 합은"+sum);
	}
	
	public static void quiz2() {
		// 점수를 반복해서 입력하면 합계,평균을 구하시오.
		// 끝이라고 입력시 프로그램 종료.
		
		Scanner sc=new Scanner(System.in);
		
		String a;
		int sum=0;
		int cnt=0; // 'int sum,cnt=0;' : sum은 정수, cnt는 정수 겸 0 // 'int sum=0,cnt=0;'sum,cnt 모두 정수 겸 0
		double avg;
		
		while(true) {
			System.out.println("점수를 입력하세요.(끝 이면 종료)");
			a=sc.nextLine();
			
			if(a.equals("끝"))
				break;
					
			sum+=Integer.parseInt(a);
			cnt++;
			
		}
		avg=(double)sum/cnt;
		System.out.println("점수의 합 :"+sum);
		System.out.printf("점수의 평균 :%.2f",avg);
		
	}
	
	public static void quiz3() {
		/* 총 5개의 점수를 입력받아 합계를 구하시오.
		 * 만약 1~100 이 아닐 경우 다시 입력받아 
		 * 1번 점수 : 88
		 * 2번 점수 : 99
		 * 3번 점수 : 200
		 * 		잘못입력했어요.
		 * 4번 점수 : 33
		 * 5번 점수 : 88
		 * */
		
		
		Scanner sc=new Scanner(System.in);
		
		int i;
		int cnt=0;
		int sum=0;
		
//		for(i=1;i<=100;i++) {
//			System.out.println("점수를 입력하세요.");
//			i=sc.nextInt();
//			
//			if(i<1||i>100)
//				continue;
//			cnt++;
//			if(cnt==5)
//				break;
//			sum+=i;
//			}	
		
		for(int a=1;a<=5;a++) {
			System.out.println(a+"번 점수: ");
			i=sc.nextInt();
			
			if(i<1 || i>100) {
				System.out.println("\t잘못입력했어요");
				a--;
				continue;
			}
			sum+=i;
		}
		System.out.println("=======================================");
		System.out.println("총점 : "+sum);
/*
		while(true) {
			System.out.println("점수를 입력하세요.");
			i=sc.nextInt();
				
			if(i<1||i>100) {
				System.out.println("잘못 입력했어");
				continue;
			}
			cnt++;
			if(cnt==5)
				break;
			sum+=i;			
			
		}
		System.out.println("점수의 합은 "+sum+"입니다.");
		*/
		
	}
	
	public static void main(String[] args) {
	
//		quiz1();
//		quiz2();
		quiz3();

	}

}
