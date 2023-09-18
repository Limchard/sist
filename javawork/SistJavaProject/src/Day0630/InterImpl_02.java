package Day0630;

interface InterA{
    public void draw();
    public void write();
}
////////////////////////////////////
//interface InterB extends InterA{
interface InterB {
    public void play();
}
////////////////////////////////////
class Impl implements InterA,InterB{
    @Override
    public void draw() {
        System.out.println("그림을 그립니다.");
    }

    @Override
    public void write() {
        System.out.println("일기를 씁니다.");
    }

    @Override
    public void play() {
        System.out.println("축구를 합니다.");

    } //2개의 인터페이스를 구현하는 클래스가 된다.

}
////////////////////////////////////
public class InterImpl_02 {

    public static void main(String[] args) {

        // 생성#1
        Impl impl=new Impl();
        impl.draw();
        impl.write();
        impl.play();

        System.out.println("---다형성---");
        // 다형성
        InterA inA=new Impl();
        inA.draw();
        inA.write();
        InterB inB=new Impl();
        inB.play();

    }
}
