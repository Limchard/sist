package Day0621;

public class ForSum_08 {

	public static void main(String[] args) {
		// 
		
		// for 문으로 합계구하기
		// 1~10 까지의 합계
		int sum=0; // 합계구하는 변수
		
		for(int i=1;i<=10;i++) {
			sum+=i; // sum=sum+i..합계 변수에 i를 누적시킨다. => i를 sum에 누적해준다. 라고 생각하자. 
		}
		System.out.println("1부터 10까지의 합은 "+sum+"입니다");
		
		// while문으로 만들어보자.
		
		int tot=0;
		int i=1;
		while(i<=10) {
			tot=tot+i;
			i++;
		}
		System.out.println("1부터 10까지의 합은 "+tot+"입니다");
		
		// 결과출력시 1~10까지의 합은 55입니다.
		
		int total=0;
		int a=1;
		for(;a<=10;a++) {
			total+=a;
		}
		System.out.println("1부터 "+a+"까지의 합은 "+total+"입니다");
		System.out.println("1부터 "+(a-1)+"까지의 합은 "+total+"입니다");

		
	}

}
