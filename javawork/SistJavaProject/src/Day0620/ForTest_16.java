package Day0620;

public class ForTest_16 {

	public static void main(String[] args) {
		// 
		// 1. 1~5까지 출력하시오
		

		for(int i=1;i<=5;i++) {
			System.out.println(i+"hohoho");
		}
		System.out.println();
		// 5,4,3,2,1
		for(int i=5;i>=1;i--) {
			System.out.print(i+"   ");
		}
		
		System.out.println();
		
		// 0,2,4,6,8,10
		for(int s=0;s<=10;s+=2) {
			System.out.print(s+"   ");
		}
		System.out.println();
		// 3,6,9,12,15
		for(int f=3;f<=15;f+=3) {
			System.out.print(f+" ");
		}
		System.out.println();
		// I lobe Java_0
		// I lobe Java_1
		// I lobe Java_2
		// I lobe Java_3

		for(int a=0;a<=3;a++) {
			System.out.println("I love Java_"+a);
			
		}
				
	}

}
