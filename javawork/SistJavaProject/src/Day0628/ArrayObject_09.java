package Day0628;

class Student{
    private String sname;
    private String hp;
    private int grade;

    // 생성자에서 초기값 주기(명시적 생성자)
    public Student(String name,String hp, int grade) {
        this.sname=name;
        this.hp=hp;
        this.grade=grade;
    }

    // 멤버값 출력데이터
    public void getData(){
        System.out.println("이름: "+sname);
        System.out.println("연락처: "+this.hp);
        System.out.println("학년: "+grade+"학년");
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ArrayObject_09 {
    public static void main(String[] args) {

//        Student[] stu=new Student[3];
//
//        stu[0]=new Student("임형준","010-3333-4444",3);
//        stu[1]=new Student("이성신","010-2222-1111",4);
//        stu[2]=new Student("진현규","010-1234-1234",1);
//
        // 생성하면서 바로 초기화
        Student[] stu={new Student("임형준","010-3333-4444",3),
                new Student("이성신","010-2222-1111",4),
                new Student("진현규","010-1234-1234",1)
                };



        // 출력#1
        for(int i=0;i<stu.length;i++){
//            Student s=stu[i]; // class 명 통째로..?? 암튼 45번 라인 대신해서 42~44 라인으로 사용 가능.
//            s.getData();
            stu[i].getData();
            System.out.println("----------------------------------------");
        }
        // 출력#2 (for~each문)
        // for(클래스명 참조변수명:배열명)
        for(Student s1:stu){
            s1.getData();
            System.out.println("-----------------------------------------");

        }

    }
}
