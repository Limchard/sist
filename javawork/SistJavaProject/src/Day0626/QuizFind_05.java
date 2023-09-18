package Day0626;

import java.util.Scanner;

public class QuizFind_05 {

	public static void main(String[] args) {
		/* 숫자를 입력받아서 배열의 몇번째에 있는지 출력하고 없을 경우 없습니다. 라고 출력하세요.
		 * (0이면 종료)
		 * 입력값:22
		 *      22은 6번째에 있어요!
		 * 입력값:7
		 *      7은 없습니다. 
		 * 입력값:0
		 *      종료합니다.(프로그램종료)	
		 *   */
		
		int[] arrNums= {2,4,5,6,7,22,55,44,77,982,88,54,25,35,45};
		
		Scanner sc=new Scanner(System.in);
		int num;
		
		while(true) {
			System.out.print("입력값: ");
			num=sc.nextInt();
			
			//break
			if(num==0) {
				System.out.println("***종료합니다***");
				break; // 반복문(while)을 빠져 나간다.
			}
			
			boolean flag=false; // 반복문 안에서 찾았을 경우 true로 변경해줄거야.
			
			// 배열개수만큼 반복해서 입력한 숫자 찾기 
			for(int i=0;i<arrNums.length;i++) {
				if(num==arrNums[i]) {
					flag=true;
					System.out.println("\t"+num+"은 "+(i+1)+"번째에 있어요.");
				}
			}
			// 배열에 없는경우 flag는 영전히 false라고 만들어줘야 한다.
			if(!flag) 
				System.out.println("\t"+num+"은 없습니다.");
		}
	}
}
