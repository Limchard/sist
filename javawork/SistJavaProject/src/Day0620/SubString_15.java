package Day0620;

public class SubString_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="나는 쌍용에서 자바를 공부중입니다";
		
		char ch=str.charAt(3);
		String word1=str.substring(8);
		String word2=str.substring(8, 10); // 뒷자리는 하나 더 더해줘야한다. 자바 추
		String word3=str.substring(8, 11); // 자바를 추출
		int i=str.length(); // 총 길이. 공백 포함하여 1부터 센다. 갯수니까 
		
		
		System.out.println(ch);
		System.out.println(word1);
		System.out.println(word2);
		System.out.println(word3);
		System.out.println(i);
			
	}

}
