package Day0627;

public class StudentMain_03 {

    public static void main(String[] args){

        Student_03 stu1=new Student_03();
        Student_03 stu2=new Student_03();

        stu1.name="최성현";
        stu1.age=25;

        stu2.name="박영주";
        stu2.age=25;

        Student_03.schoolName="쌍용고등학교";

        System.out.println("***클래스 맴버값 출력***");
        System.out.println("학교명 :"+Student_03.schoolName);

        System.out.println("학생 1 정보 ");
        System.out.println("이름: "+stu1.name);
        System.out.println("이름: "+stu1.age);

        Student_03.schoolName="쌍용중학교";
        System.out.println("학교명 :"+Student_03.schoolName);

        System.out.println("학생 2 정보 ");
        System.out.println("이름: "+stu2.name);
        System.out.println("이름: "+stu2.age);



    }
}
