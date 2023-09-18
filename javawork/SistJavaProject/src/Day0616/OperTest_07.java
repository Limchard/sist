package Day0616;

public class OperTest_07 {

	public static void main(String[] args) {
		// 기본자료형은 총8개
		// 1. 논리형_true,false
		boolean b=false;
		
		// 2.문자형_반드시 하나의 문자, 16비트 유니코드값 표현
		// 자바에서 char가 문자하나. 2byte 까지도 가능
		// 기본적으로 정수형, 아스키코드로 변환해보면 알 수 있다.
		char ch='A';
		//char ch1='A';
		
		// 3. 정수형
		byte a=-128; // 1바이트 -128~127 까지 가능 원통형 구조
		short s=32000; // 16 bit
		int c=670000; // 32 bit
		long num=100L; // 64 bit long은 구분을 위해 맨 뒤에 알파벳 "L,l"을 붙힌다.
		
		// 실수형
		double d=1532.216; // 64 bit, 소수점 포함
		float f=1532.216f; // 32bit, float은 구분을 위해 숫자 뒤에 'f'를 붙힌다.
		
		// int, float는 똑같이 32bit사용하지만 기본적으로 실수형이 정수형보다 큰타입으로 처리된다.
				
		//출력
		System.out.println("bool="+b);
		System.out.println("not bool="+!b);
		System.out.println("ch="+ch); // 65
		System.out.println("ch="+(ch+1)); //66
		System.out.println("ch="+(char)(ch+1)); //B (아스키코드 참고)
		System.out.println("d="+d);// 정밀도 15자리(반올림)
		System.out.println("f="+f);// 정밀도 8자리(반올림)
		
		// printf %f:실수
		// 전체자리수 10자리 소수점 2자리
		System.out.printf("d=%10.2f\n",d); // (전체10자리.소수점 2자리)자릿수 맞추기 위해 공백이 온다.
		// 소수점1자리
		System.out.printf("d=%.1f",d);


		
	}

}
