package Day0619;

public class OperTest_09 {

	public static void main(String[] args) {
		// 비교(관계)연산자: >,<,>=,<=,==,!=
		// 논리 연산자 : &&(and), ||(or), !(not) 
		
		// 결과값을 true,false로 출력해보자.
		
		int a=5, b=3, c=5;
		
		System.out.println(a>b); //true
		System.out.println(a==b); //false
		System.out.println(!(a==b)); // true
		System.out.println(a!=b); // true
		
		System.out.println(a>b&&b>c); // true&&false=false
		System.out.println(a>b||b>c); // true||false=true
		
		
	}

}   