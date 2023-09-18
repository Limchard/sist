package Day0629_1;
/*
부모 클래스가 다른 패키지에 있을 경우 protected,public 변수는 접근이 가능하다.
같은 패키지인 경우에는 private만 빼고 모두 접근이 가능하다.
 */
public class SuperObj {

    protected String name;
    protected int age;
    String name2;

    public SuperObj(String name,int age, String name2) {
        this.name=name;
        this.age=age;
        this.name2=name2;

    }

}
