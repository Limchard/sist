package Day0630;

// 내부클래스 -특정 클래스 안에 또다른 클래스가 정의됨.
// 하나의 멤버처럼 사용 가능. 하나의 메서드처럼 사용 가능. (외부의 모든 멤버들을 자신의 멤버처럼 사용 가능)
// 상속이 하나인 단점을 어느정도 보완해준다.

class OuterObj{

    class InnerObj{

        public void write(){
            System.out.println("내부클래스의 메서드");
        }
    }
    public void showMsg(){
        System.out.println("외부클래스의 메서드");
        System.out.println("외부에서 내부클래스 매서드 호출");

        InnerObj inObj=new InnerObj(); // 내부의 메서드 호출
        inObj.write();
    }
}

//////////////////////////////////////////////////////////
public class InnerClass_11 {

    public static void main(String[] args) {
        OuterObj outObj=new OuterObj();
        outObj.showMsg();
        System.out.println("-----------------------------");

        // 내부클래스의 메서드 선언.. 외부통해서만 가능
        OuterObj.InnerObj obj=new OuterObj().new InnerObj(); // 방법 1번
        obj.write();
        System.out.println("----------------------------");
        OuterObj.InnerObj obj1=outObj.new InnerObj(); // 방법 2번
        obj.write();
    }
}
