package Day0628;

class Test{
    public Test() {
        System.out.println("디폴트 생성자");
    }

    // 생성자 대신 인스턴스를 반환해주는 메서드를 만들어준다.
    public static Test getInstance(){
        return new Test();  // 괄호 안에 생성자 명...??
    }

    // 일반메서드
    public void writeMessage(){
        System.out.println("안녕?");
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////
public class ConstGetInstance_02 {

    public static void main(String[] args){
        // new로 할 수 있게
        Test t1=new Test();
        t1.writeMessage();
        ////////////////////////////////////////////////////////////////////
        // 인스턴스로 할 수 있게..
        Test t2=Test.getInstance();
        t2.writeMessage();

    }
}
