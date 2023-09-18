package Day0623;

import java.util.Scanner;

public class SuMatch_03 {

	public static void main(String[] args) {
		// 랜덤수를 발생시킨 후 그 숫자를 맞춰보자.
		
		Scanner sc=new Scanner(System.in);
		
		//1~100 사이의 랜덤수 발생
		int rnd=(int)(Math.random()*100+1); // 출력만 안했을 뿐 이미 저장한 순간 random수는 있는 것이다.
		
		int su; // random수를 맞추기 위해 입력할 숫자
		int cnt=0; // 횟수. 몇번 눌러서 맞췄는지..
		int count=0;
		
		while(true) {
			cnt++;
			System.out.println(cnt+"회");
			su=sc.nextInt();
			
			if(su>rnd) 
				System.out.println(su+"보다 작습니다.");
			
			else if(su<rnd)
				System.out.println(su+"보다 큽니다.");
			else {
				System.out.println("맞았습니다. 정답은 "+rnd+"입니다.");
				break;
			}
		}
		System.out.println("게임 종료");
		

	}

}
