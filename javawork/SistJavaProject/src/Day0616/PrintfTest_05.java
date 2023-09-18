package Day0616;

public class PrintfTest_05 {

	public static void main(String[] args) {
		// Printf는 문자열을 구성해서 출력하는 것
		// 문자열뒤에 따라오는 데이터(%)를 순서대로 배치한다.
		// %d: 정수
		// %f: 실수
		// %s: 문자열
		// %c: 문자(char)
		
		int num1=10, num2=20;
		int num3=num1+num2;
		
		System.out.println(num1+"+"+num2+"="+num3);
		
		//printf로 출력
		System.out.printf("num1의 값은 %d, num2의 값은 %d, num3의 값은 %d 입니다.",num1,num2,num3);
		//순서대로 대입된다. 
		//printf는 %사용할 때만 사용

	}

}
