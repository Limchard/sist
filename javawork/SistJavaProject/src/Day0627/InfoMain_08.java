package Day0627;

public class InfoMain_08 {

    public static void main(String[] args){ // class가 여러개 있어도 main이 있어야 한다.
        // 명시적 생성자 : 생성과 동시에 초기값 설정 가능
        Info_08 in1=new Info_08("임형준",31,"서울시 관악구"); // default로 설정하고 setter method로 기입한 것이랑 같은 느낌

        // getMethod 변수 지정
        String name=in1.getStuName();
        int age= in1.getAge();
        String addr= in1.getAddr();

        System.out.println("이름은 "+name+"이고, 나이는 "+age+"세 이며, 주소는 "+addr+"입니다.");

        // --
        Info_08 in2=new Info_08("김김김",23,"서울시 은평구");
        System.out.println("이름은 "+in2.getStuName()+"이고, 나이는 "+in2.age+"세 이며, 주소는 "+in2.addr+"입니다.");

        // 디폴트 생성자로 생성 (초기값 지정이 필요함)
        Info_08 in3=new Info_08();
        System.out.println("이름: "+in3.getStuName()+"\n나이: "+in3.getAge()+"\n주소 :"+in3.getAddr());

    }
}
