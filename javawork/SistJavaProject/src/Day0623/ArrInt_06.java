package Day0623;

public class ArrInt_06 {

	public static void main(String[] args) {
		// 선언하면서 초기값들을 동시에 저장할 수 있다.
		
		int [] arr= {5,6,7,12,24,35,47,58};
		
		
		System.out.println("개수 : "+arr.length);
		
		System.out.println("출력방법 1:   1 ==> 5 ");
		for(int i=0;i<arr.length;i++) {
			System.out.println((i+1)+"번 "+arr[i]);
		}
		
		System.out.println("\n출력방법 2: for~each문 ");
		for(int a1:arr) {
			System.out.println(a1);
		}

	}

}
