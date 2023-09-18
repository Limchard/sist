package Day0626;

import java.util.Arrays;

public class ArrNumsChange_02 {

	public static void main(String[] args) {
		// 
		
		int[] arr= {99,26,48,59,22,34,53,76,82,97,75,33,11,42,54};
		
		// 출력
		System.out.println("원래 데이터");
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		System.out.println();
		
		
		// 데이터 거꾸로 변경하기.
		for(int i=0;i<arr.length/2;i++) {
			int temp=arr[i];
			arr[i]=arr[arr.length-1-i]  ; // 10개 일때 0하고 9번이랑 바꾸는 것.
			arr[arr.length-1-i]=temp;
		}
		
		// 출력
		System.out.println("순서 바꾼 데이터");
		
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		
		
		// selection sort(오름차순 정렬)
		// Arrays.sort(arr) : 배열 arr을 정렬한다.
		// 선택정렬: 가장 작은 숫자를 앞으로 보내자. 
		// 중첩 for문을 이용한다.
		
		// 기준데이터는 0부터 끝에서 두번째까지
		for(int i=0;i<arr.length-1;i++) {
			// 비교하는 데이터는 기준 다음값부터 끝가지.
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		// 오름차순 후의 데이터
		System.out.println("\n오름차순 후 데이터");
				
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"  ");
		}
		
		System.out.println();
		Arrays.sort(arr);
		for(int i=0;i<arr.length;i++) {
		System.out.print(arr[i]+"  ");
		}
	}
}
