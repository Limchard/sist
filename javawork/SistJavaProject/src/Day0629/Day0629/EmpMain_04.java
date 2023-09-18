package Day0629.Day0629;

public class EmpMain_04 {

    public static void main(String[] args) {
        // 최지우, 2500000, 기획경영부

        // 부모를 받은 자식이 결과적으로 부모보다 크다.
        // 그래서 자식을 가져와야 한다.
        Manager_04 man=new Manager_04("최지우",2500000,"기획경영부");

        System.out.println(man.getEmp()); // 재정의된 메서드 호출

    }
}
