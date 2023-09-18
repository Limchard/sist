package Day0627;

public class ExObject_01 {

    String name; // 인스턴스변수.. 일반인스턴스 멤버변수는 객체생성후 각각 다른 값을 가질 수 있다.
    static final String MESSAGE="Happy Day"; // static 멤버변수는 주로 상수로 선언할때 사용하며, 인스턴스 변수 없이 클래스명으로 접근 가능하다.
    // 여러 객체가 같은값을 가져야 할 경우 주로 static으로 선언한다.

//    public ExObject_01(){ // 생성만을 목적으로 태어난 아이. 생성자.
//
//    }

    public static void main(String[] args) {

        System.out.println("static 변수는 new로 생성없이 호출가능");
        System.out.println(ExObject_01.MESSAGE);
        System.out.println(MESSAGE);
      //  MESSAGE="Nice Day!!"; // final 이라서 오류가 난다. 값변경 불가. 위에 final을 없애면 가능.

//      ExObject_01.name;
        // 클래스명 참조변수명=new 클래스명();
        ExObject_01 ex1=new ExObject_01(); // default 생성자는 괄호안에 비어있는 것.

        System.out.println(ex1.name);

        ex1.name="김철수"; // 초기화 시켜보자.
        System.out.println(ex1.name);

        ExObject_01 ex2=new ExObject_01();
        ex2.name="홍길동";
        System.out.println(ex2.name);

        ExObject_01 hoo=new ExObject_01();
        hoo.name="임형준";
        System.out.println(hoo.name);

        System.out.println("다 같이 사용하는 메세지: "+MESSAGE);


    }
}
