package Day0629.Day0629;

class Person{

    String name;
    String buseo;

    public void getPerson(){  // 디폴트 생성자
        System.out.println("** 부모변수출력 **");
        System.out.println("이름: "+this.name);  // 자식이 부모꺼를 받으면 this. 사용 가능
        System.out.println("부서: "+this.buseo);

    }
}
//////////////////////////////////////////////////
class My extends Person {
    int age;
    public My(String name, String buseo, int age){
        this.name=name;
        this.buseo=buseo;
        this.age=age;
    }
    public void write(){
        System.out.println("**내가 만든 것**");
        System.out.println("사원명: "+this.name);
        System.out.println("부서: "+this.buseo);
        System.out.println("나이: "+this.age);

    }
    // 오버라이드 메서드

    @Override
    public void getPerson() {
        super.getPerson();
        System.out.println("나이 :"+this.age);
    }
}


//////////////////////////////////////////////////
public class Inheri_07 {

    public static void main(String[] args) {

        My my1=new My("임형준","승인도",29);
        my1.write();
        System.out.println();
        System.out.println("**오버라이드 통한 메서드 출력**");
        my1.getPerson();

    }
}
