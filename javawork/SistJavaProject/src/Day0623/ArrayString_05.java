package Day0623;

public class ArrayString_05 {

	public static void main(String[] args) {
		// 배열 선언을 문자열로 해봅시다.
		
		String [] str=new String[4];
		
		// 초기화
		str[0]="최진평";
		str[1]="고은비";
		str[2]="김영환";
		str[3]="홍성경";
		
		
		//출력
		System.out.println("for문 출력");
		for(int i=0;i<str.length;i++) {
			System.out.println(i+1+": "+str[i]);
		}
		
		System.out.println("for~each문 출력");
		for(String s:str)
			System.out.println(s);

	}

}
