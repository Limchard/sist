package Day0622;

public class GaroGugu_06 {

	public static void main(String[] args) {
		// 가로 방향으로 구구단을 출력하세요.
		// [2단] [3단] [4단]...[9단] 
		
		for(int dan=2;dan<=9;dan++) {
			System.out.print("["+dan+"단]\t");
		}
		System.out.println();
		
		for(int j=1;j<=9;j++) {
					
			for(int dan=2;dan<=9;dan++) { // 단 
				
				System.out.printf("%dx%d=%d\t",dan,j,dan*j);
			}
			System.out.println();

		}

	}

}
