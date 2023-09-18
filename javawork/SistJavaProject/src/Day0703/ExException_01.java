package Day0703;

public class ExException_01 {

    public static void main(String[] args) {

        System.out.println("프로그램 시작!!!");
        try { // 에러 발생할 수 있는 가능코드
            int num = 3 / 0; // 정수를 0으로 나누면 무조건 에러발생.
        } catch (ArithmeticException e) { // 에러에 대한 해결(처리)
            System.out.println(e.getMessage()); // 예외처리에 대한 처리 방법(ex. 예외처리 메세지)
//            e.printStackTrace(); // 에러에 대한 자세한 예외 정보 출력.
        }
        System.out.println("프로그램 종료!!!");

    }
}
