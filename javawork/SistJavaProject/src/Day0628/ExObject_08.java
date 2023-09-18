package Day0628;

class Apple{

    private String writer;
    private String subject;
    private static String msg="HappyDay!!";

    // 각각의 set,get
    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        Apple.msg = msg;
    }

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////
public class ExObject_08 {

    public static void writeApple(Apple apl) {  // Apple이라는 Class 자체를 통째로 가지고 온다. apl은 그냥 내가 지정한 변수.
        System.out.println("***Apple 클래스 출력***");
        System.out.println("작성자: "+apl.getWriter());
        System.out.println("제목: "+apl.getSubject());

    }


    public static void main(String[] args) {

        System.out.println("Apple 클래스의 메세지 출력");
        System.out.println(Apple.getMsg());

        Apple a1=new Apple();
        a1.setWriter("김은희");
        a1.setSubject("악귀 재밌더라구요");

        Apple a2=new Apple();
        a2.setWriter("스티브잡스");
        a2.setSubject("애플 너무 비싸요");

        // writeApple 호출
        writeApple(a1);
        writeApple(a2);

    }
}
