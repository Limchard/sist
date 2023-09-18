package Day0621;

public class QuizFor_09_2 {

	public static void main(String[] args) {
		// 나 혼자 연습
		
		int z=0;
		int zsum=0;
		while(true) { // 반드시 break문이 필요하다.
			z++;			
			if(z%2==0) 
				continue; // continue가 오면 이후 사항을 모두 skip, 즉 continue 기준으로 바로 위로 올라가버린다.
							// if문 밖으로 나가버린다. 그래서 아래 zsum=+z나 if등 모두 시행이 안된다.							
//			zsum+=z;
//			System.out.println("1~100까지 중 홀수의 합은"+zsum);
			
			if(z>2) // d==100 이면 왜 실행이 안될까?
				break;	
			zsum+=z;
			System.out.println("1~100까지 중 홀-수의 합은"+zsum);
		}
		
	}

}
