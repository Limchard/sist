package Day0626;

public class ReviewArray_08 {

	public static void main(String[] args) {
		// 해당 배열을 for문을 이용하여 출력하시오.
		
		//1.ex) 0번지: 영환이 ...
		String[] names= {"영환이","수환이","동환이","성환이"};
		
		for(int i=0;i<names.length;i++) {
			System.out.println(i+"번지 :"+names[i]);
		}
		
		//2. 해당 배열을 가로로 출력하시오.
		int[]nums= {2,4,5,7,8};
		
		for(int i=0;i<nums.length;i++) {
			System.out.print("\t"+i+"번째 숫자: "+nums[i]);
		}
		
		System.out.println();
		//3. flowers
		String[] flowers= {"장미","벚꽃","매화","코스모스","아카시아"};
		for(int i=0;i<flowers.length;i++) {
			System.out.print("\t"+i+"번째 꽃: "+flowers[i]);
		}
		
		//4.colors 
		System.out.println();
		String[]colors= {"green","yellow","gold","silver","black","red"};
		for(int i=0;i<colors.length;i++) {
			System.out.print("\t"+i+"번째 색깔: "+colors[i]);
		}
		
	}

}
