package Day0621;

public class ExFor_07 {

	public static void main(String[] args) {
		// 
		
		// 초기값이 조건에 안맞으면 한번도 반복 안되는 조건문	
		
		for(int i=5;i<=1;i++) {
			System.out.println(i);
		}
		
		int i;
		for(i=1;i<=10;i++)
		{
			System.out.print(i+"\t");
		}
		System.out.println("\n빠져나온후의 i값 :"+i);
			
		
		
		int a=10;
		for(;a<=50;a+=5) {
			System.out.print(a+"\t");
		}
		System.out.println("\n 빠져나온후의 a값"+a);
		
		// Hello를 가로로 5번 반복하시오.
		
		for(int b=1;b<=5;b++) {
			System.out.print("Hello   ");
		} // 출력문에 변수가 포함되어 있지 않다. 변수가 출력문에 영향을 주지 않으므로 어떻게든 for문이 5번 반복만 되면 된다.
		
		System.out.println();
		System.out.println("1부터 10까지의 숫사 중 짝수만 가로로 출력하기");
		
		for(int c=1;c<=10;c++) {
			if(c%2==0)
				System.out.print(c+"   ");								
		}
		System.out.println();
			
		
		System.out.println("1부터 10까지의 숫사 중 짝수만 가로로 출력하기");
		
		for(int c=1;c<=10;c++) {
			if(c%2==1)
				continue;
				System.out.print(c+"   ");								
		}
		
	}

}
