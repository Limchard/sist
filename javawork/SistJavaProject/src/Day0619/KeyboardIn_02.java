package Day0619;

import java.util.Scanner;

public class KeyboardIn_02 {

	public static void main(String[] args) {
		
		//스케너를 생성해서 쓰자 : 
		//sc : 참조변
		
		
		try (// Scanner는 문자열이나 숫자를 모두 키보드로 입력받으려 할때 생성해 준다.
		Scanner sc = new Scanner(System.in)) {
			// 변수
			String name;
			int age;
			String city;
			
			//출력(입력문)
			System.out.println("이름을 입력해보세요==>");
			name=sc.nextLine();//한줄을문자로 읽어온다(공백사용가능)
			
			System.out.println("나이도 입력해 보세요==>");
			//age=sc.nextInt();
			// 문자, 숫자, 문자 번갈아서 쓰면 버퍼가 걸린다. 그걸 해결하기 위해서 라인을 한칸 띄어줘야 한다.
			age=Integer.parseInt(sc.nextLine()); // 숫자입력과 동시에 라인도 띄어준다.
			//숫자 입력후 엔터를 누르면 그 엔터가 키보드 버퍼로 저장되어서 다음문자열 읽을때 먼저 읽어버린다.
			//그래서 다음문자열 읽기 전에 sc.nextLine()을 써서 띄어줘야 한다.
			// 결국 문자로 쓰고 형변환으로 인트 해주면. 원문이 글자니까 버퍼 현상을 잡아준다.
			
			
			
			System.out.println("당신이 사는 지역은?==>");
			city=sc.nextLine();
			
			// next는 라인 안내려줌, nextLine은 한줄 내려줌
			
			//최종 출력
			System.out.println("내이름은"+name+"입니다" );
			System.out.println("내나이는"+age+"세 입니다" );
			System.out.println("내가 사는 지역은 "+city+"입니다" );
			
		}
		
	}

}
