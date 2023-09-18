package Day0626;

import java.util.Arrays;

public class LottoSort_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[]lotto=new int[6];
		
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
		
//		// 오름차순정렬(기분:처음~끝에서 2번째    비교:시작다음값~끝)
//		for(int i=0;i<lotto.length-1;i++) {
//			for(int j=1+i;j<lotto.length;j++) {
//				if(lotto[i]>lotto[j]) {
//					int temp=lotto[i];
//					lotto[i]=lotto[j];
//					lotto[j]=temp;
//				}
//			}
//		}
	
		// 출력
		for(int i=0;i<lotto.length;i++) {
			System.out.printf("%5d",lotto[i]);
		}
	}
}
