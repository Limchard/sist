package Day0627;

public class Info_08 {

    // 3개의 인스턴스 변수 (생성만을 목적으로 만들었다.)
    String stuName;
    int age;
    String addr;

    //생성자 (디폴트 생성자)
    public Info_08() {

    }

    //명시적인 생성자...생성과 동시에 멤버초기화 (setter method 와 동일한 느낌)
    public Info_08(String name,int age,String addr){

        stuName=name;
        this.age=age;
        this.addr=addr;

    }

    // getter method
    public String getStuName(){
        return stuName;
    }

    public int getAge() {
        return age;
    }

    public String getAddr() {
        return addr;
    }
}
