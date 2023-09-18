package Day0622;

public class ForStar_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 중첩(다중)for문 별모양 찍기
		
		for(int i=1;i<=5;i++) { // 행 갯수 
			
			for(int j=1;j<5;j++) { //열 갯수 
				System.out.print("*");
			}
			System.out.println("*");
		}

		// 2번 
		
		System.out.println("\n");
		
		for(int i=1;i<=5;i++) { // 행 갯수 
			
			for(int j=1;j<=i;j++) { //열 갯수 (i값만틈만 반복) 
				System.out.print("*");
			}
			System.out.println("");
		}
		
		// 3번 
			
		System.out.println("\n");
		
		for(int i=1;i<=5;i++) { // 행 갯수 
			
			for(int j=5;j>=i;j--) { //열 갯수(i가 1일때 5번, 2일때 4번...) 
				System.out.print("*");
			}
			System.out.println();
		}
		
	}

}
