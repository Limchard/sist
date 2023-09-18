package Day0621;

public class ExWhile_02 {

	public static void main(String[] args) {
		// while문으로 1부터 10까지 출력해보자.
		
		int n=0;
		
		while(n<10) {
			n++;
			System.out.printf("%4d",n);
		}
		System.out.println();
		
		// 다른방법 
		n=0; // 먼저 선언한 n에 대해 다시 0으로 선언한다.
		int m=0;
		while(n<10) {
			System.out.printf("%4d",++n);
		
		}
		System.out.println();
		
		while(m<10) {
		System.out.printf("%4d",m++);
		}
		
		System.out.println();
		n=0;
		while(true) {
			System.out.printf("%4d",++n);
			// 위 식은 무한루프에 빠지므로 반드시 break문을 주어야 한다. 
			if(n==10)
				break;
		}
		
		System.out.println();
		
		n=0;
		while(++n<=10) {
			System.out.printf("%4d",n);
			
		}
				
	}

}
