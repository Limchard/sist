package Day0621;

public class ExFor_05 {

	public static void main(String[] args) {
		 
		// for문
		
		// 1~10까지 가로로 출력	
		for(int i=1;i<=10;i++) {
			System.out.print(i+"\t");
		}
		System.out.println();
		
		// 10~1까지 가로로 출력
		for(int i=10;i>=1;i--) {
			System.out.print(i+"\t");
		}
		
		System.out.println();
		
		// 1~50까지 3씩 증가하게 출력
		// 1 4 7 ...
		for(int i=1;i<=50;i+=3) {
			System.out.print(i+"\t");
		}
		
		System.out.println();
		
		// continue
		// 1~20까지 출력하는데 1 2 3 4 6 7 8 9 11 12 13 14... (5의 배수 빼고) 
		for(int i=1;i<=20;i++) {
			// 5의 배수를 빼고 출력하자.
			if(i%5==0)
				continue; //i++로 이동.
			System.out.print(i+"\t");
		}
		
		System.out.println();
		
		for(int i=1;i<=20;i++) {
			// 5의 배수를 빼고 출력하자.
			if(i%5==0)
				break; // 반복문 자체를 아예 빠져나옴 
			System.out.print(i+"\t");
		}		
	}
}
