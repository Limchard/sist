package Day0615;

public class SpecialChar_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// 문자열 내에서 특별한 의미로 해석되는 문자를 이스케이프 시퀀스(Escape Sequence)라고 한다.
		// 이스케이프 시퀀스(Escape Sequence)는 모두 \로 시작함
		/*
		 *  \t : 다음탭위치로 이동(탭 만큼 띄운다)
		 *  \n : 다음줄로 이동
		 *  \" : 쌍따옴표를 단순 문자로 인식
		 *  \' : 홑따옴표를 단순 문자로 인식
		 *  \\ : 백슬래시를 단순 문자로 인식
		 */
		
		System.out.println("Apple\tMellon\n");
		System.out.println("Orange\tkiwi\tbanana");
		System.out.println("Apple\\");
		System.out.println("Apple\"");
		System.out.println("Apple\'");
		System.out.println("Apple\\");
		// "Hello"
		System.out.println("\"Hello\"");
		// c:\
		System.out.println("c:\\");
		
		// Q: "red","green","blue"
		
		System.out.println("\"red\",\"green\",\"blue\"");
	

	}

}
