package Day0628;

class MyInfo{
    // 멤버값
    private String name;
    private int age;
    private String hp;
    public static final String ADDR="Seoul";

    // 각각의 setter,getter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    // 3개의 멤버를 한번에 변경할 메서드 만들기
    public void setData(String name,int age, String hp){
        this.name=name;
        this.age=age;
        this.hp=hp;
    }

    // 3개의 멤버를 한번에 출력하게 만들자.
    public void getData(){
        System.out.println("이름: "+this.name+"나이: "+age+"핸드폰 번호: "+hp);
    }
    // 생성자를 만든적이 없다.. default 생성자가 있다.
}

////////////////////////////////////////////////////////////////////////////////////////////////
public class ExObject_04 {
    public static void main(String[] args) {
        MyInfo in1=new MyInfo();
        // setter
        in1.setName("임형준");
        in1.setAge(29);
        in1.setHp("010-1212-3434");
        // getter
        String name=in1.getName();
        int age=in1.getAge();
        String hp=in1.getHp();
        // 출력 (getter에 return만 있고 출력문이 없기에.. 출력문을 입력해줘야한다.)
        System.out.println("거주지: "+MyInfo.ADDR);
        System.out.println("이름 :"+name+"\n나이: "+age+"\n핸드폰 번호: "+hp);
        System.out.println("--------------------------------------------------------------------");

        // 생성2
        MyInfo in2=new MyInfo();
        // setDate(3개 한번에)
        in2.setData("이성신",28,"010-3333-2222");
        in2.getData();
    }
}
