package Day0629.Day0629;

import Day0629_1.SuperObj;

// extends : 상속받겠다 라는 코드
// extends 뒤에는 하나밖에 못받는다.
public class SubObj_03 extends SuperObj {

    String addr;


    public SubObj_03(String name, int age, String name2, String addr) {
        super(name, age, name2); // 상속받은게 우선이 되어야 하기에 무조건 super는 첫줄에 와야한다.(반드시 첫줄, 부모생성자 호출)
        this.addr=addr;
    }

    public void write() {
        System.out.println("이름: "+this.name);
        System.out.println("나이: "+this.age);
        System.out.println("주소: "+this.addr);

    }
}
