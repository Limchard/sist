package Day0619;

public class OperTest_10 {

	public static void main(String[] args) {
		// 대입연산자 =+,-=,*=,/=,%= 
		
		int a,b,c,d,e;
		a=b=c=d=e=10;
		
		a+=2; // a=a+2 .. a에 2를 더한값이 다시 a가 된다.
		b-=3; // b=b-3 ..
		c*=3; // c=c*3
		d/=3; // d=d/3
		e%=3; // e=e/3에 대해 남은 나머지 값 
		
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);
		System.out.println("d="+d);
		System.out.println("e="+e);
		
	}

}
