package Day0623;

public class ArrayTest_04 {

	public static void main(String[] args) {
		// 기본형배열은 객체로 인식
		
		int [] arr1,arr2; // 배열로 선언 	
		arr1=new int[3]; // 메모리 할당. 메모리 할당을 위해 숫자 반드시 기입해야함
		arr2=new int[5]; // 할당만 되도 값은 0으로 초기화가 된다. 즉 숫자는 0, String 은 null
		
//		int [] arr1=new int[3];
//		int arr2 []=new int[5];
		
		// arr1 배열에 값을 넣는다.
		arr1[0]=10;
		arr1[1]=5;
		arr1[2]=20;
		
		// 배열의 갯수
		System.out.println(arr1.length); // 3(0~2)
		System.out.println(arr2.length); // 5(0~4)
		
		// arr1출력
		System.out.println("arr1 출력");
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		
		// for문으로 arr1 출력 // i값을 활용 가능하다.
		System.out.println("for문으로 arr1 출력");
		for(int i=0;i<3;i++) {
			System.out.println(arr1[i]);
		}
		
		// for문으로 arr1 출력
		System.out.println("for문으로 arr1 출력_범위를 변수화 해보자 ");
		for(int i=0;i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
		
		//arr2를 출력해보는데 범위를 변수화한 for문으로 출력해보세요.
		System.out.println("for문으로 arr2 출력");
		for(int i=0;i<arr2.length;i++)
			System.out.println(arr2[i]);
		
		// for~each : (배열변수자료형 임의의이름 : 변수명) i값을 활용 불가능 하다.
		System.out.println("for~each_arr1");
		for(int a1:arr1) {
			System.out.println(a1);
		}
		
		System.out.println("for~each_arr2");
		for(int a2:arr2) {
			System.out.println(a2);
		}
		
	}

}
