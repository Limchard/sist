package Day0629.Day0629;
// 추상클래스는 new로 생성을 못한다.
/*
추상클래스는 new로 생성을 못한다.
추상메서드가 하나라도 존재하는 클래스를 추상클래스 라고 한다.
추상클래스: 일반메서드, 추상메서드 둘다 존재 가능하다.
변수는 못쓴다. 상수정도는 가능하다.
 */
abstract class Fruit{ // 상수는 들어갈 수 있다.
//class Fruit{ // 상수는 들어갈 수 있다.

    static final String MESSAGE="오늘은 비가 많이오네요.";

    // 일반메서드
    public void getTitle(){
        System.out.println("우리는 추상클래스 공부중!!!");
    }

    // 추상메서드(미완의 메서드.. 선언문만 있고 구현부인 몸통이 없다.)
//    public void showMessage();
    abstract public void showMessage(); // 추상메서드 : 오버라이딩을 하기 위한 목적!!

    // 인터페이스 : 추상의 메서드만 모아놓은 곳.
}

//////////////////////////////////////////////////
class Apple extends Fruit{  // 위에가 추상이긴 하나 어쨌든 클래스이다.

    @Override
    public void showMessage() {
        System.out.println("Apple_Message");
        System.out.println(Fruit.MESSAGE);
    }
}
//////////////////////////////////////////////////
class Banana extends Fruit{

    @Override
    public void showMessage() {
        System.out.println("Banana_Message");
    }
}
//////////////////////////////////////////////////
class Orange extends Fruit{

    @Override
    public void showMessage() {
        System.out.println("Orange_Message");
    }
}
//////////////////////////////////////////////////
public class ExAbstract_08 {

    public static void main(String[] args) {

        // 일반적인 생성 (변수 3개... 변수 여러개)
        Apple apple=new Apple();
        Banana banana=new Banana();
        Orange orange=new Orange();

        apple.showMessage();
        banana.showMessage();
        orange.showMessage();

        // 다형성 (변수 1개)
        // 다형성은 하나의 변수로 여러가지 일을 처리할때 이용한다.
        // 다형성은 하위클래스로 생성한다.
        // 부모클래스명 변수명=new 자식클래스명();

        System.out.println("----------------------------");

        Fruit fruit;

        fruit=new Apple();
        fruit.showMessage();

        fruit=new Banana();
        fruit.showMessage();

        fruit=new Orange();
        fruit.showMessage();

        fruit.getTitle();


    }
}
