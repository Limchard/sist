package Day0628;

class Member{

    private String stuName; // 학생명
    private String gender; // 성별
    private String addr; // 주소
    static String ban; // 몇 반?
    static int cnt=0;


    // private 3개만 수정용 멤버 메서드 만들기.
    public void setMembers(String name, String gd, String addr){
        this.stuName=name;
        this.gender=gd;
        this.addr=addr;
    }

    // 출력용 메서드 만들기
    public void getMembers() {
        cnt++;

        System.out.println("***학생"+cnt+" 정보 ***");
        System.out.println("학생명: "+this.stuName);
        System.out.println("소속학급: "+ban); // 같은 클래스에서는 클래스명 생략 가능.
        System.out.println("성별: "+gender);
        System.out.println("주소: "+addr);
        System.out.println("-------------------------------------------------");

    }
}

////////////////////////////////////////////////////////////////////////////////////
public class ExObject_06 {
    public static void main(String[] args) {

        //생성, 출력,
        Member m1=new Member();
        Member.ban="쌍용 자바 7강의장";
        m1.setMembers("최성현","남자","서울시 강동구");
        m1.getMembers();

        Member m2=new Member();
        m2.setMembers("이성신","남자","경기도 시흥시");
        m2.getMembers();

        Member m3=new Member();
        m3.setMembers("이민규","남자","서울시 중랑구");
        m3.getMembers();

        Member m4=new Member();
        m4.setMembers("임형준","남자","서울시 관악구");
        m4.getMembers();

    }
}
