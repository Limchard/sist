package Day0622;

import java.util.Scanner;

public class ScanGugu_05 {

	public static void main(String[] args) {
		// 단을 입력해서 해당 단 출력하기
		// 0을 입력 시 종
		
		Scanner sc=new Scanner(System.in);
		
		int dan;

		while(true) {
			System.out.println("단을 입력하세요(종료: 0)");
			dan=sc.nextInt();
			
			// 종료
			if(dan==0) {
				System.out.println("종료합니다");
				break;
			}
			
			if(dan<2||dan>9) {
				System.out.println("2~9단 까지만 입력 가능합니다.");
				continue;
			}
			// 2~9단까지만 입력 가능하능 하도록 해보자 
			
			// 구구단출력 
			System.out.println("["+dan+"단]");
			for(int j=1;j<=9;j++) {
				System.out.println(dan+"x"+j+"="+dan*j);
				System.out.printf("%d X %d = %2d\n",dan,j,dan*j);
			}
				
		}

	}

}
