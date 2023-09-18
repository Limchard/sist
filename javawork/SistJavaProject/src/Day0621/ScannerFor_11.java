package Day0621;

import java.util.Scanner;

public class ScannerFor_11 {
	
	public static void numSum() {
		
		// 합계를 구할 숫자는?
		// 1부터 100까지의 합은 5050입니다.
		
		Scanner sc=new Scanner(System.in);
		
		int n; // 입력할 수 
		int sum=0;
			
		System.out.println("합계 구할 숫자는?");
		n=sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			sum+=i; // sum=i+1 이라는 뜻
		}
		System.out.println("1부터"+n+" 까지의 합은"+sum+"입니다.");
	}

	public static void factorialTest() {
		
		// 1! = 1
		// 2! = 2
		// 3! = 6
		
		// 10! 출력
		int result=1;
		for(int i=1;i<=10;i++) {
			result*=i;
		System.out.println(i+"! = "+result);
					
		}	
		
	}
	
	
	public static  void quizFact() {
		// 팩토리얼을 구할 숫자를 입력!
		// 5!=120 (예시)
		
		Scanner sca=new Scanner(System.in);
		
		int result=1;
		int n;
		
		System.out.println("팩토리얼 구할 숫자를 입력하시오.");
		n=sca.nextInt();
		
		for(int i=1;i<=n;i++) {
			result*=i;
		
		}
		System.out.println(n+"! = "+result);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		numSum();
		factorialTest();
		quizFact();
		
	}

}
