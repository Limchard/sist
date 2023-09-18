package Day0623;

import java.util.Scanner;

public class ArrayIntFind_12 {

	public static void main(String[] args) {
		// 숫자를 입력해서 그 숫자가 몇번째에 있는지 찾을것이다.
		// 있는지 없는지 유,무 먼저 확인 후 있을 시 몇번째인지 찾아야 한다.
		// 없으면 없다고, 있으면 그 숫자가 몇번째 있는지 찾기.
		// 0입력시 종료: while(true)
		
		Scanner sc=new Scanner(System.in);
		
		int su; // 입력할 수 
		int[] data= {4,63,64,76,84,62,41,4324,3535,6757,2342,5262,57,2,5};
		boolean flag;
		
		while(true) {
			System.out.println("검색할 숫자를 입력하세요.");
			su=sc.nextInt();
			
			if(su==0) {
				System.out.println("종료합니다.");
				break;
			}
			
			// 유,무에 대한 초기
			flag=false; //초기값은 false로 주는것이 좋다. 찾으면 true로 변경할 것이다.
			// class에서는 false, 0, null 등이 기본값이다.
			
			// 값을 찾아보자.
			for(int i=0;i<data.length;i++) {
				if(su==data[i]) {
					flag=true; // 찾았다 라는 의미 
					System.out.println((i+1)+"번째에서 검색 ");
				}
			}
			if(!flag) // !flag와 동일한 말 flag==false
				// 위에서 찾지 못했다면... 이라는 의미. 못찾으면 여전히 false이다.
				System.out.println(su+"는 data에 없습니다.");
		}
	}
}
