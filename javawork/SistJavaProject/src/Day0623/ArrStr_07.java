package Day0623;

public class ArrStr_07 {

	public static void main(String[] args) {
		// 문자열 배열 str1,st2 ...선언과 동시에 초기화 해주자.

		String [] str1 = {"김밥","피자","스파게티","햄버거","짱깨","돈까스"};
		
		String [] str2 =new String[5]; // 5개의 문자열이 들어가도록 메모리할당, null로 초기화 됨
		
		// str2에 문자열 넣기
		str2[0]="초록";
		str2[1]="노랑";
		str2[4]="파랑";
		 
		// str1을 변수 i를 이용해서 출력
		// 예시) 음식1: 김밥..
		System.out.println("str1 출력 ");
		for(int i=0;i<str1.length;i++) {
			System.out.println("음식"+(i+1)+": "+str1[i]);
		}
		
		
		System.out.println("\nfor~etch문으로 str2 출력, 가로로 나열 ");
		for(String a:str2)
			System.out.print(a+"\t");
		
	}

}
