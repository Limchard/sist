package Day0627;
// 멤버 클래스
class Student{

    private String name; // null
    private int age; // 0

    // setter_method
    // 인스턴스변수에 저장된 데이터를 수정할 목적이다.(개발자들 사이의 약속 : set변수명)_수정할 인자값이 있다.
    // 저장수정용도이므로 리턴값(결과값)이 없다.(리턴값 생략되기에 void 로 적어줘야한다.)
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }

    // getter_method
    // 인스턴스변수에 저장된 데이터를 조회(select)할 목적(출력 목적)이다. (개발자들 사이의 약속 : get변수명)
    // 데이터를 얻는 목적이므로 호출데이터를 넘겨줄 필요가 없기에 인자값(마라메터값)이 없다.
    // 실행결과를 돌려주므로 "return 결과값" 으로 지정해준다.
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }

}

///////////////////////////////////////////////////////////////
public class SetGetMethod_07 {

    public static void main(String[] args){

        // 1. 객체생성
        Student stu1=new Student();

        // 2. 참조변수명으로 set메서드 호출
        stu1.setName("임형준");
        stu1.setAge(31);

        // 3. get메서드를 통한 값을 얻자
        String name=stu1.getName();
        int age=stu1.getAge();

        // 출력
        System.out.println(name+"  "+age);


        // 실습
        Student stu2=new Student();

        stu2.setName("이성신");
        stu2.setAge(27);

        System.out.println((stu2.getName()+" "+stu2.getAge()));

        String name2=stu2.getName();
        int age2=stu2.getAge();
        System.out.println(name2+" "+age2);




    }
}
