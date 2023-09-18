package Day0616;

public class ParseArgs_04 {

	public static void main(String[] args) {
		/* main에서 실행할때 args로 변수 넘기는 문제
		 * 변수명: PhoneName,su,dan,total
		 * 
		 * 1.변수선언
		 * 2.계산
		 * 3.출력
		 * 
		 * [상품정보]
		 * 상품명: 아이폰 프로
		 * 수량: 5개
		 * 단가: 1650000원
		 * 총 금액: 8250000원 */
				
		//변수 선언
		String Phonename=args[0];
		int su=Integer.parseInt(args[1]);
		int dan=Integer.parseInt(args[2]);
		int total;
				
		// 계산
		total=su*dan;
		
		// 출력
		System.out.println("[상품정보]");
		System.out.println("상품명 :"+Phonename);
		System.out.println("수량"+su+"개");
		System.out.println("단가:"+dan+"원");
		System.out.println("총 금액:"+total+"원");
		
	}

}
