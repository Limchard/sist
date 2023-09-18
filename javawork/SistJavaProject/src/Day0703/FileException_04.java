package Day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileException_04 {

    public static void read(){
        String fileName="/Users/imhyeongjun/Desktop/sist0615/file/monday.txt";
        BufferedReader br=null; // 파일 선언
        FileReader fr=null; // 문자 단위로만 읽을 수 있다.

        try {
            fr=new FileReader(fileName); // 파일 호출
            System.out.println("파일을 열었어요!!!");

            br=new BufferedReader(fr); // 호출한 파일을 BufferedReader로 가져옴
            // BufferedReader는 한줄만 읽을 수 있다.

            // 여러줄 읽어야 하므로 while문 진행
            while (true){
                // 메모장에서 내용을 한줄씩 읽어온다.
                String s=br.readLine(); // readLine은 한줄씩 읽을 수 있다.

                // 마지막 줄일경우 null값을 읽어서, null값일 경우 빠져나가기.
                if(s==null){
                    break;
                }
                System.out.println(s);
            }

        } catch (FileNotFoundException e) {
 //           throw new RuntimeException(e);
            System.out.println("파일이 없어요: "+e.getMessage());
        }
        catch (IOException e) { //try 안에서 또 try catch가 발생하면 catch만 한번 더 해주면 된다.

        }
        finally {
            try {
                fr.close();
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        read();
        System.out.println("메모 정상종료");



    }
}