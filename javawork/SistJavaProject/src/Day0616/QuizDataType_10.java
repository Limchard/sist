package Day0616;

public class QuizDataType_10 {

	public static void main(String[] args) {
				
		/* 매개변수(args)를 이용하여 출력해보세요 
		 * [시험결과]
		 * Java=88,Jsp=77,Spring=99
		 * 총점: 264 점
		 * 평균: 88.00 점 */
		
		
		// 변수 선언
//		int Java=Integer.parseInt(args[1]);
//		int Jsp=Integer.parseInt(args[2]);
//		int Spring=Integer.parseInt(args[3]);
//		int count=3; // 3과목을 의미하는 변수
//		int total=Java+Jsp+Spring;
		
		
//		double avg1=total/count; // 결과가 무조건 int
//		double avg2=(double)total/count; // 결과가 double
		// 계산
//		total=Java+Jsp+Spring;
						
		
		//출력
//		System.out.println(args[0]);
//		System.out.println("Java="+Java+", Jsp="+Jsp+"Spring="+Spring);
//		System.out.println("총점:"+total+"점");
//		System.out.printf("평균:%.2f점",total/(double)count);
		
		
	// 선생님 풀이
		// 변수 선언 및 계산
		int Java=Integer.parseInt(args[1]);
		int Jsp=Integer.parseInt(args[2]);
		int Spring=Integer.parseInt(args[3]);
		int count=3; // 3과목을 의미하는 변수
		int total=Java+Jsp+Spring;
		
		
		double avg1=total/count; // 결과가 무조건 int
		double avg2=(double)total/count; // 결과가 double
		
		// 출력
		System.out.println("[시험결과]");
		System.out.printf("Java=%d, Jsp=%d, Spring=%d\n",Java,Jsp,Spring);
		System.out.println("총점: "+total+"점");
		System.out.printf("평균: %.2f",avg1);
		
	}

}