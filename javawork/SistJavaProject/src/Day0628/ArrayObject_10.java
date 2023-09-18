package Day0628;

class MyPersoninfo{
    private String name;
    private String blood;
    private String age;

    // 명시적 생성자
    public MyPersoninfo(String name,String blood,String age) {
        this.name=name;
        this.blood=blood;
        this.age=age;
    }

    // 제목
    public static void title() {
        System.out.println("이름\t혈액형\t나이");
        System.out.println("----------------------------------");
    }
    // 출력문
    public void getInfo() {
        System.out.println(name+"\t"+blood+"형\t"+age+"세");
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////
public class ArrayObject_10 {

    public static void main(String[] args) {

        // 생성 초기화
        MyPersoninfo[] i1= {
                new MyPersoninfo("임형준","O","29"),
                new MyPersoninfo("홍길동","B","23"),
                new MyPersoninfo("가가가","A","14"),
        };
        System.out.println("총 "+i1.length+"명의 정보 출력");
        MyPersoninfo.title();

        for(int i=0;i<i1.length;i++){
            i1[i].getInfo();
        }

        System.out.println("\n총 "+i1.length+"명의 정보 출력");
        MyPersoninfo.title();

        for(MyPersoninfo kiki:i1){
            kiki.getInfo();
        }
    }
}
