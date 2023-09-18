package Day0626;

public class ArrayDachawon_07 {

	public static void main(String[] args) {
		// 다차원배열 선언과 동시에 초기값 지정후 출력 
		
		int[][]arr= {
				{39,43},
				{67,87,80},
				{71,32,24,42}
				};
		
		System.out.println("총 행갯수: "+arr.length);	
		System.out.println("0번행의 열갯수: "+arr[0].length);
		System.out.println("0번행의 열갯수: "+arr[1].length);
		System.out.println("0번행의 열갯수: "+arr[2].length);
		
		for(int i=0;i<arr.length;i++) { // 행
			for(int j=0;j<arr[i].length;j++) { // 열
				System.out.printf("[%d][%d]=[%d]\t",i,j,arr[i][j]);
			}
			System.out.println();
		}

	}

}
