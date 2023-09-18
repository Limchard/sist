package Day0616;

public class DataType_08 {

	public static void main(String[] args) {
		
		
		byte a=127; // -128~127
		byte b=(byte)128; // 더 작은 자료형으로 변환(디모션_값손실)
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		
		int x=7;
		int y=4;
		
		System.out.println(x/y);// 정수끼리의 계산은 무조건 결과값도 정수로 나온다.
		System.out.println((double)x/y); // 계산시 x를 double로 변환해서 계산 : 결과는 double
		System.out.println(x/(double)y);
		
		// 강제형변환
		
		double d=100.0;
		int i=100;
		
		int result=(int)d+i;
		double result2=d+i;
		double result3=(double)d+i;
				
		System.out.println("d="+d);
		System.out.println("i="+i);
		System.out.println("result="+result);
		System.out.println("result2="+result2);
		System.out.println("result3="+result3);
		System.out.println((int)d+i);
		
	}
}
