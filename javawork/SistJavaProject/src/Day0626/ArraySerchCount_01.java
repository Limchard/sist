package Day0626;

import java.util.Scanner;

public class ArraySerchCount_01 {

	public static void main(String[] args) {
		/* Q. 반복문안에서 실행..
		 * 성을 입력 시 그 성씨를 가진 사람과 총 인원수를 출력하시오. 종료라고 하면 프로그램 종료.   */
		
		String[] names= {"김선호","나나","이효리","엄정화","김완선","보아","유재석","하하","김신영","보아뱀","나영석","김연진","이진"};
		
		
		Scanner sc=new Scanner(System.in);
		
		String serch; // 입력할 성
		int cnt; // 총 인원
		
		while(true) {
			System.out.println("성씨를 입력하세요.");
			serch=sc.nextLine();
			
			if(serch.equals("종료")) {
				System.out.println("종료합니다.");
				break;
			}
			Boolean flag=false;
			cnt=0; // 검색할때마다 0으로 초기화가 필요함..
			
			for(int i=0;i<names.length;i++) {
				if(names[i].startsWith(serch)) {
					System.out.println(i+"번째: "+names[i]);
					flag=true;
					cnt++;
				}				
			}
			if(flag) {  // flag==true
				System.out.println(serch+"성씨를 가진 사람은 총"+cnt+"명 입니다.");	
			}
			else { //!flag
				System.out.println(serch+"성씨를 가진 사람은 없습니다.");	

			}
		}
	}
}
