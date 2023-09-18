package Day0703;

import java.util.Date;

public class NullPoint_02 {

    Date date;
// NullPointerException - 생성하지 않고 클래스의 메소드를 호출하는 경우
    public void writeday() {
        int y,m,d;
        try {
            y = date.getYear() - 1900;
            m = date.getMonth() + 1;
            d = date.getDate();


            System.out.println(y + "년 " + m + "월 " + d + "일 입니다.");
        }
        catch (NullPointerException e) {
            System.out.println("객체생성을 안했어요"+e.getMessage());
        }
    }

    public static void main(String[] args) {

//        Deprecated ??

        NullPoint_02 np=new NullPoint_02();
        np.writeday();
        System.out.println("***정상 종료***");


    }
}
