package Day0628;

public class MethodObject_13 {

    public static void hello(int age,double height) {
        System.out.println("안녕 클레오파트라 세상에서 제일가는 포테이토 칩!!!!!!!!!");
        System.out.println("제 나이는"+age+"세 입니다.");
        System.out.println("저의 키는 "+height+"cm 입니다.");
    }

    public static void main(String[] args) {

        System.out.println("메서드 연습 시작!!!");

        hello(29,193.2); // 출력은 main 순서로 출력된다.
        goodbye();
        System.out.println("메서드 연습 끝~~~");
        hello(22,186.4);
    }

    public static void goodbye(){
        System.out.println("빠이 짜이찌엔~~");
    }

}
