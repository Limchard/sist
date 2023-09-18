package Day0623;

public class ArrayMaxMin_10 {

	public static void main(String[] args) {
		// 
		
		int [] data= {42,4,56,235,346,7653,3456,23,2,234};
		
		System.out.println("data의 길이: "+data.length);
		System.out.println("data의 길이: "+data.length);

		int max=data[0]; // 첫데이터를 무조건 최대값에 저장
		int min=data[0];
		// 두번째 값부터 끝까지 max와 각각 비교
		for(int i=1;i<data.length;i++) {
			if(max<data[i])
				max=data[i];
			
			if(min>data[i])
				min=data[i];
		}
		
		System.out.println("최대값: "+max);
		System.out.println("최소값: "+min);		

	}

}
