package Day0629_1;

public class Employee_04 {

    String sawonName;
    int salary;

    public Employee_04(String name,int sal) {
        this.sawonName=name;
        this.salary=sal;
    }

    // 리턴해주는 메서드
    public String getEmp() {
        return sawonName+","+salary;
    }

    // 추상메서드: 블락괄호가 없다==구현할것이 없다.

}
