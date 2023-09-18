package Day0630;

interface InterAA{
    public void eat();
    public void go();
}
/////////////////////////////////////////////////////////
interface InterBB extends InterAA{
    public void ride();
}
/////////////////////////////////////////////////////////
class InterImple2 implements InterBB{

    @Override
    public void eat() {
        System.out.println("저녁을 먹어요");
    }

    @Override
    public void go() {
        System.out.println("롯데월드에 가요");
    }

    @Override
    public void ride() {
        System.out.println("자전거 타고 놀아요");
    }
}
/////////////////////////////////////////////////////////
public class InterExtends_03 {

    public static void main(String[] args) {
        // 생성
        InterImple2 ii2=new InterImple2();
        ii2.eat();
        ii2.go();
        ii2.ride();
        System.out.println("--다형성--");
        // 다형성
        InterBB bb=new InterImple2();
        bb.eat();
        bb.go();
        bb.ride();

    }
}
