package Day0629.Day0629;

import Day0629_1.Employee_04;

public class Manager_04 extends Employee_04 {

    String buseo;


    public Manager_04(String name, int sal, String b) {
        super(name, sal); //부모생성자 호출
        buseo=b; // 내꺼 초기화

    }
    // 하위클래스에서 부모클래스의 메서드를 수정하새 사용하는 것: 오버라이딩
    // 1. 상속이 전제, 2. 메서드 이름은 부모나 나나 동일하다. 3. 리턴타입도 동일하다. 4.
    // override 상속받았을때 부모의 미완의 메서드를 받아서 추가해주는 것.
    @Override
    public String getEmp() {
        return super.getEmp()+","+buseo;
    }
}
