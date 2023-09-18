package Day0621;

public class QuizFor_09 {

	public static void main(String[] args) {
		//

		// Q. 1 2 4 5 7 8 10 continue를 이용해서 출력해보자.

		for (int i = 1; i <= 10; i++) {
			if (i % 3 == 0)
				continue;
			System.out.print(i + "  ");
		}

		System.out.println();
		// Q. continue 이용할 것!!
//		홀수값 : 1
//		홀수값 : 3
//		홀수값 : 5
//		홀수값 : 7
//		홀수값 : 9

		for (int i = 1; i <= 9; i++) {
			if (i % 2 == 0)
				continue;
			System.out.println("홀수값 :" + i);
		}

		// 1~100 까지중에서 홀수의 합을 구하시오.
		int osum = 0;// 홀수합계구할 변수
		int esum = 0;// 짝수합계구할 변수
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 1)
				osum += i;
			else 
				esum += i;
		}
		System.out.println("홀수의 합: " + osum);
		System.out.println("짝수의 합: " + esum);

		
		// while(true)문을 이용해서 1~100 까지중에서 짝수의 합을 구하시오.
		int a=0;
		int sum=0;
		while(true) { // 반드시 break문이 필요하다.
			a++;
			if(a%2==1)
				continue;
			sum+=a;
			
			if(a==100)
				break;
		}
		System.out.println("1~100까지 중 짝수의 합은"+sum);
		
		int b=1;
		int bsum=0;
		while(true) { // 반드시 break문이 필요하다.
			++b;
			if(b%2==1) {
				continue; 
				}
		
			bsum+=b;
			
			if(b==100) {
				break;
			}
		}
		System.out.println("1~100까지 중 짝-수의 합은"+bsum);
	
		// 홀수
		int c=0;
		int csum=0;
		while(true) { // 반드시 break문이 필요하다.
			++c;
			if(c%2==0) 
				continue; 				
		
			csum+=c;
			
			if(c>100) 
				break;
			
		}
		System.out.println("1~100까지 중 홀수의 합은"+csum);
		
		
		int z=0;
		int zsum=0;
		while(true) { // 반드시 break문이 필요하다.
			++z;
			if(z%2==0) {
				continue; // continue가 오면 이후 사항을 모두 skip, 즉 continue 기준으로 바로 위로 올라가버린다.
							// 그래서 아래 zsum=+z나 if등 모두 시행이 안된다.
				}
			
			zsum+=z;
			
			if(z>=100) { // d==100 이면 왜 실행이 안될까?
				break;
			
			}
			
		}
		System.out.println("1~100까지 중 홀-수의 합은"+zsum);
	}

}
