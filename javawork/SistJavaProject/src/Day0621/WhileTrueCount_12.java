package Day0621;

import java.util.Scanner;

public class WhileTrueCount_12 {

	public static void main(String[] args) {
		/* 
		 * 임의의 수를 입력해서 함계, 평균, 갯수를 구해볼꺼야
		 * 단, 0을 입력하면 while문을 져나가게 하자.  */
		
		Scanner sc=new Scanner(System.in);
		int su,sum=0; // 입력한 수, 합계 
		int cnt=0; // 갯수 
		double avg=0; // 평균 
		
		while(true) {
			System.out.println("숫자를 입력하세요 (종료:0) ");
			su=sc.nextInt();

			if(su==0)
				break;
			
			sum+=su; // +=을 누적한다고 생각하면 이해가 쉽다. 
			cnt++;
		
		}	
		avg=(double)sum/cnt;
		System.out.println("입력한 수의 합 : "+sum);
		System.out.println("입력한 수의 갯수 : "+cnt);
		System.out.println("입력한 수의 평균 : "+avg);
	}

}
