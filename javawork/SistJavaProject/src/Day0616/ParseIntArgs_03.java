package Day0616;

public class ParseIntArgs_03 {

	public static void main(String[] args) {
		/* [결과출력] 
		 * 내이름은 임형준
		 * 자바 점수는 88점
		 * 오라클 점수는 77점
		 * 두과목의 합계는 165점 입니다.*/
		
//		int num1=Integer.parseInt(args[1]);
//		int num2=Integer.parseInt(args[2]);
				
//		System.out.println("[결과출력]");
//		System.out.println("내 이름은"+args[0]);
//		System.out.println("자바 점수는 "+num1+"점");
//		System.out.println("오라클 점수는 "+num2+"점");
//		System.out.println("두과목의 합계는"+(num1+num2)+"입니다.");

				
	// 아래는 선생님 풀이
		// 변수 선언
		String name=args[0];
		int java=Integer.parseInt(args[1]);
		int oracle=Integer.parseInt(args[2]);
		//계산
		
		//출력
		System.out.println("[결과출력]");
		System.out.println("내 이름은"+name);
		System.out.println("자바 점수는 "+java+"점");
		System.out.println("오라클 점수는 "+oracle+"점");
		System.out.println("두과목의 합계는"+(java+oracle)+"점 입니다.");	
		
	}

}
