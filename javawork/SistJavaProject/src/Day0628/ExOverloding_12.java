package Day0628;

public class ExOverloding_12 {

    public static int sum(int a,int b){
        System.out.println("1번째 함수 호출");
        return a+b;
    }

    public static double sum(int a,double b){
        System.out.println("2번째 함수 호출");
        return a+b;
    }

    public static double sum(double a,int b){
        System.out.println("3번째 함수 호출");
        return a+b;
    }

    public static double sum(double a,double b){
        System.out.println("4번째 함수 호출");
        return a+b;
    }

    public static void main(String[] args) {

        // 인자타입에 따라서 자동으로 중복함수가 호출된다.
        System.out.println(sum(5,5));
        System.out.println(sum(5,5.5));
        System.out.println(sum(5.5,5));
        System.out.println(sum(5.5,5.5));

    }
}
