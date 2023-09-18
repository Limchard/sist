package Day0621;

import java.util.Scanner;

public class QuizWhileTrue_13_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 점수를 반복해서 입력하다가 q나 Q를 입력하면 while문을 빠져나온뒤 총갯수, 총점, 평균을 출력하시오.
		
		Scanner sc=new Scanner(System.in);
		
		
		String n;
		int num = 0,cot=0;
		double avg=0;
		
		while(true) {
			
			System.out.println("숫자를 입력하시오.(q or Q 종료)");
			n=sc.nextLine();
	
//			if(n.equals("q")||n.equals("Q"))
//			if(n.charAt(0)=='q' || n.chartAt(0)=='Q')
			if(n.equalsIgnoreCase("q"))
				break;
	
			num+=Integer.parseInt(n);
			cot++;
			
		}
		
		avg=(double)num/cot;
		System.out.println("총점 : "+num);
		System.out.println("갯수 : "+cot);
		System.out.printf("평균 : %.1f",avg);
	}

}
