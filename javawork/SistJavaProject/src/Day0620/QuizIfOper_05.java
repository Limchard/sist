package Day0620;

import java.util.Scanner;

public class QuizIfOper_05 {

	public static void main(String[] args) {
		/*
		 * 상품명? 아이패드	
		 * 수량? 3
		 * 가격? 500000
		 * ==============================
		 * 아이패드 3개는 총 1500000원 입니다.
		 * 3개 이상 구매 시 10프로 DC가 됩니다.
		 * DC된 총 금액은 1350000 원 입니다.
		 * */ 
		
		Scanner sc=new Scanner(System.in);
		
		String iPad;
		int num,price,tot;
		
		//입력 
		System.out.println("상품명?");
		iPad=sc.nextLine();
		System.out.println("수량?");
		num=sc.nextInt();
		System.out.println("개당 가격?");
		price=sc.nextInt();
		
		//총액 계산
		tot=num*price;
		
		//if문	
		System.out.println("**if문**");
		if(num>=3)
			tot=(int) (tot*0.9);
	
		System.out.println("총 금액은 "+tot+"원 입니다.");
		System.out.println("3개 이상 구매 시 10프로 DC 됩니다.");
		
		
		//삼항연산자
		System.out.println("**삼항연산자**");
		tot=(int) (num>=3?(tot*0.9):tot);
			System.out.println("총 금액은 "+tot+"원 입니다.");
		

	}

}
