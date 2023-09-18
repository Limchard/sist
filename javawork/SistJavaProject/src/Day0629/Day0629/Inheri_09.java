package Day0629.Day0629;

class Work{

    public void process(){
        System.out.println("작업중!!!");
    }
}
//////////////////////////////////////
class Food extends Work{

    @Override
    public void process() {
        super.process();
        System.out.println("음식을 합니다.");
    }
}
/////////////////////////////////////////
class Study extends Work{
    @Override
    public void process() {
        super.process();
        System.out.println("공부를 합니다.");
    }
}
////////////////////////////////////////
class Clean extends Work{
    @Override
    public void process() {
        super.process();
        System.out.println("청소를 합니다.");
    }
}

//////////////////////////////////////
public class Inheri_09 {
    public static void main(String[] args) {

        // 일반적인 생성.. 메서드호출
        Food food=new Food();
        food.process();
        Study study=new Study();
        study.process();
        Clean clean=new Clean();
        clean.process();

        // 다형성 생성.. 메서드 호출

        System.out.println("-------------------");
        Work work;

        work=new Food();
        work.process();

        work=new Study();
        work.process();

        work=new Clean();
        work.process();

    }
}
