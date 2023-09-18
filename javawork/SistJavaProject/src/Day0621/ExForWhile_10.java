package Day0621;

public class ExForWhile_10 {

	public static void test1() {
	// public(privite의 반대 의미), static(class method에 붙이는거.),	
		
		// for 문으로 1부터 5까지 구하기(반복문안의 num을 sum에 더하는 문제)
		int sum=0;
		
		for(int num=1;num<=5;num++) {
			sum+=num;
						
		}
		System.out.println("총 합계는 "+sum);
				
	}

	public static void test2() {
		
		// 1에서 100까지의 홀수의 합 (for문)
		int sum=0;
		
		for(int i=1;i<=100;i+=2) {
			
			sum+=i;
			
		}
		System.out.println("홀수의 합은 "+sum);	
		
	}
	
	public static void test3() {
		
		// 100까지의 합은 5050이다. 100을 변수처리해서 가져오세요
		int sum=0;
		int i;
		for(i=0;i<=100;i++) {
			sum+=i;
		}
		System.out.println("1부터 "+(i-1)+"까지의 합은"+sum+"이다.");
	}
	
	// main에서 호출해줘야 실행 가능하다.
	public static void main(String[] args) {
		// 
		
	test1(); // main에서 test1에대한 method를 호출하는 소스 
		test2();
		test3();
		
	}
 
		
		
		
	

}
