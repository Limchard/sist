package Day0704;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileWriter_05 {

    // BufferReader 는 파일 불러올때 번역기 정도로 생각하자.
    public static void  fileWriter(){
        FileWriter fw=null; // 선언만 한거다. 생성한거 아니다.
        // 메서드는 무조건 초기값 지정 해줘야함, class는 안해줘도 됌.
        String fileName="/Users/imhyeongjun/Desktop/sist0615/file/filetest1.txt";

        try {
            fw=new FileWriter(fileName); // 파일을 새로 생성(같은 이름이 있으면 삭제하고 새로 생성해준다.)

            //파일에 내용 추가하기
            fw.write("Have a Nice Day!!\n"); // 메모장 줄 넘김(\n)
            fw.write(new Date().toString()); // 소스코드는 toString() 해줘야 한다.
            fw.write("\n이성신 조장님!!");
            System.out.println("** 파일 저장 성공 **");

        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void fileWrite2(){
        FileWriter fw=null;
        String fileName="/Users/imhyeongjun/Desktop/sist0615/file/filetest2.txt";

        try {
            fw=new FileWriter(fileName,true); // 추가 모드, 실행하면 내용이 계속 추가 된다.
            fw.write("내 이름은 홍길동\n");
            fw.write("=====================\n");
            fw.write("동해번쩍 서해번쩍 하지");


        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public static void main(String[] args) {
        fileWriter();
        fileWrite2();

    }
}
