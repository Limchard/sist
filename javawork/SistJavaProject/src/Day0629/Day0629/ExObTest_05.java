package Day0629.Day0629;

class Point{
    int x;
    int y;


    // 명시적 생성자
    public Point(int x,int y) {
        System.out.println("super_인자있는 생성자(명시적 생성자)");
        this.x=x;
        this.y=y;
    }

    // 디폴트 생성자
    public Point() {
        System.out.println("super_디폴트 생성자");
    }




    // 메서드
    public void write(){
        System.out.println("x좌표= "+x+", y좌표= "+y);

    }
}

////////////////////////////////////////////////////////////
class SubPoint extends Point {

    String msg;
// 명시적 생성자
    public SubPoint(int x, int y, String msg) {
        super(x, y);
        this.msg=msg;
        System.out.println("sub_명시적 생성자");

    }
// 디폴트 생성자
    public SubPoint(){
//        super();   // 생략되어 있음
        System.out.println("sub_디폴트 생성자");
    }

    // 오버라이딩... 부모의 메서드 재구현할 목적(미완의 메서드를 완성할 목적)

    @Override
    public void write() {
        super.write();
        System.out.println("메세지: "+msg);
    }
}

////////////////////////////////////////////////////////////
public class ExObTest_05 {

    public static void main(String[] args) {

        SubPoint sp=new SubPoint(); // 디폴트 생성자용
        sp.write(); // set메서드 안하고 값도 지정 안해서 0과 null로 나온다.
        // print 해보면 super 먼저 나오고, sub 나오고, 나머지 나온다.

        System.out.println("--------------------------------");

        SubPoint sp1=new SubPoint(2,3,"가즈아!!"); // 명시적 생성자용
        sp1.write(); // 명시적으로 값 입력해줘서 모두 출력됨.
    }
}
