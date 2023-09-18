package Day0627;

class ObTestA{

    private int x;
    private static int y;

    // set method : 수정용
    // get method : return 용

    // x
//    public void setX(int x) {
//        this.x=xx; // 이름이 틀릴때는 this 생략 가능.
//    }
    public void setX(int xx) {
        x=xx;
}
    public void getX(){ // 수정용이 아니라서 인자값이 없다.
        System.out.println("x="+this.x);
    }

    //y
    public static void setY(int yy){
        // this.y=yy; ... reference 변수는 this를 가지고 있지 않다.
        ObTestA.y=yy; // static에서는 일반멤버변수 호출 못한다. static변수만 호출 가능하다.
    }
    public static void getY(){
        System.out.println("y="+ObTestA.y);
    }
}

////////////////////////////////////////////////////////////////////////////////
public class ExObTest_06 {
    public static void main(String[] args){

//        // x는 생성해서 호출 .. private 붙히는 순간 에러.... 메서드로 접근해야 한다.
//        ObTestA oa1=new ObTestA();
//        System.out.println(oa1.x);
//        // y는 클래스명으로 호출
//        System.out.println(ObTestA.y);

        // private 변수이므로 메서드 만들어서 호출가능.. 변수에 직접 접근 안됨.
        ObTestA oa1=new ObTestA();
        oa1.setX(20);
        oa1.getX();

        ObTestA oa2=new ObTestA();
        oa2.setX(50);
        oa2.getX();

        //ObTestA.y=200; private으로 멤버 y에 직접접근 못함.

        // 캡슐화 : private 하면 아무도 못가져가. 메서드로 접근해야 한다.

        // y 호출... 클래스명으로 호출한다.
        ObTestA.setY(100);
        ObTestA.getY();

    }
}
