package Day0626;

import java.util.Arrays;
import java.util.Scanner;

public class BuyLottes_4_1 {

	public static void main(String[] args) {
		// 몇장 구입할건지 입력하여 여러개 출력
		
		Scanner sc=new Scanner(System.in);
		int guip; // 얼마치 살껀지	
		int[]lotto=new int[6];
		
		System.out.println("lotto는 얼마치를 사실껀가요?");
		guip=sc.nextInt();
		
		// 예외조항
		if(guip<1000) {
			System.out.println("***lotto 구입 장수가 부족합니다.***");
			return; // 메인함수 자체를 빠져나간다.
		}
		
		for(int n=0;n<guip/1000;n++) {
			System.out.printf("\n%d회: ",n+1);			
		
		for(int i=0;i<lotto.length;i++) {
			// 1~45까지의 랜덤수 발생.	
			lotto[i]=(int)(Math.random()*45+1);
			
			// 중복처리
			for(int j=0;j<i;j++) {
				if(lotto[i]==lotto[j]) {
					i--; // 1. 잘못 뽑으면 일단 횟수를 1개 빼서 재시도.
					break;  //2. i++로 올라가서 같은 번지에 다시 값을 구하기 위해서.
				}
			}
		}
		// 오름차순 정렬.
		Arrays.sort(lotto);
		
		// 오름차순정렬(기분:처음~끝에서 2번째    비교:시작다음값~끝)
		for(int i=0;i<lotto.length-1;i++) {
			for(int j=1+i;j<lotto.length;j++) {
				if(lotto[i]>lotto[j]) {
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
	
		// 출력
		for(int i=0;i<lotto.length;i++) {
			System.out.printf("%5d",lotto[i]);
		}
		} // 첫번째 for문 끝지점 
	}

}
