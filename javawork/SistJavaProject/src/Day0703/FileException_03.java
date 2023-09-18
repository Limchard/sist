package Day0703;

import java.io.IOException;
import java.io.InputStream;

public class FileException_03 {

    public static void main(String[] args) {
    // 뒤에 Stream이라고 붙은 것은 문자화 못함. 원시문자임.
    // writer 로 붙은건 한글, 영어화 가능
        InputStream is=System.in;

        int a=0;

        System.out.println("한글자 입력: ");
        try {
            a=is.read(); // 읽어오는거
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.out.println("오류: "+e.getMessage());
        }
        System.out.println("3초 뒤 출력");

        try {
            Thread.sleep(3000); // 1초에 값이 1000, 즉 3000은 3초다.
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("입력값: "+(char)a);
    }

}
