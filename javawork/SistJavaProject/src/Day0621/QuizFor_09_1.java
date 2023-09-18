package Day0621;

public class QuizFor_09_1 {

	public static void main(String[] args) {

		int d = 0;
		int dsum = 0;
		while (true) { // 반드시 break문이 필요하다.
			d++;
			if (d%2==1) 
			
			dsum += d;
			
			if (d==100) 
				break;
				
		}
		System.out.print("1~100까지 중 홀수의 합은" + dsum);
	}

}

