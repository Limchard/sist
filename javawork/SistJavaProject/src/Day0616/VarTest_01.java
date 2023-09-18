package Day0616;

public class VarTest_01 {

	public static void main(String[] args) {

		// 정수는 십진수, 
		// 변수를 선언하는 이유는, 메모리를 할당하기 위해 컴파일러에게 알려주는 행위
		
		// 10진수의 정수의 저장을 위한 메모리공간을 할당하겠다.
		// 그 메모리공간의 이름을 num이라 하겠다.
		// int처럼 변수의 특성을 결정짓는 키워드를 자료형 이라한다.
		// 단, 키워드는 첫 글자는 숫자로 시작하면 안된다.
		int num1;
		num1=100;
		
		int num2=200;
		
		int num3=num1+num2;
						
		System.out.println(num1+"+"+num2+"="+num3);
		
		

	}

}
