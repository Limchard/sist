package Day0627;

class ConstA{

    int num=0;

    // 인자있는 생성자
    public ConstA(int num){
        this.num=num; // 이름이 같을경우 나 자신을 가르키는 this를 붙혀줘야 한다. 멤버값에만 this를 붙힐 수 있다.
        System.out.println("생성자 호출");
    }

    // 디폴트생성자 ... 명시적인 생성자를 만들면 디폴트 생성자는 자동생성되지 않는다.
    // 필요하면 만들어줘야 한다.
    public ConstA(){
        num=10;
        System.out.println("디폴트 생성자");
    }

    // 메서드
    public int getNumber(){
        num=50;
        return num;
    }
}

////////////////////////////////////////////////////////////////////////////////////////
public class ConstTest_05 {

    public static void main(String[] args){

        // 명시적생성자(인자값으로 num을 보낸 생성자) .. 생성과 동시에 값을 보냈다. 즉 30을 기입했다. 수정도 여기서 바로 수정 가능.
        ConstA ca1=new ConstA(30);
        System.out.println(ca1.num);

        // 디폴트 생성자.
        ConstA ca2=new ConstA();
        System.out.println(ca2.num);

        // 메서드 호출
        ConstA ca3=new ConstA();
        System.out.println(ca3.getNumber());
    }
}
