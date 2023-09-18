package Day0616;

public class DataType_09 {

	public static void main(String[] args) {
	// 묵시적 형변환:자동결정되는 타입
		// String+int=String
		// double=int=double
		// long+short=long
		// char+int=int
		
		char a='a';
		
		System.out.println(a);
		System.out.println(a+2);
		System.out.println((char)(a+2)); // char+int=int
		
		System.out.println("Happy"+5+6);
		System.out.println("Happy"+(5+6));
		System.out.println('A'+3); // A의 아스키코드값 65 에다가 숫자 3을 더해서 68이 나온다.
		System.out.println(2+'b');
		System.out.println(2+"b");
		System.out.println('a'+'b'); // 97+98 (아스키코드)
		System.out.println("a+b");
		
		
		
	}

}
