package Day0616;

public class Book69 {

	public static void main(String[] args) {

		// %d: 정수
		// %f: 실수
		// %s: 문자열
		// %c: 문자(char)
		
		int value = 123;
		System.out.printf("상품의 가격:%d원\n",value);
		System.out.printf("상품의 가격:%6d원\n",value);
		System.out.printf("상품의 가격:%-6d원\n",value);
		System.out.printf("상품의 가격:%06d원\n",value);
		
		double area = 3.14159*10*10;
		System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n",10,area);
		
		String name = "임형준";
		String job = "백수";
		System.out.printf("%6d|%-10s|%10s\n",1,name,job);
		
		
		
	}

}
