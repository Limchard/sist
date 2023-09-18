package Day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// score.txt를 읽고 몇개인지 구하고 총점, 평균까지 구해서 출력
public class FileExcep_06 {

    public static void scoreRead(){
        String fileName="/Users/imhyeongjun/Desktop/sist0615/file/score.txt";
        FileReader fr=null;
        BufferedReader br=null;
        int cnt=0; // 총 갯수
        int total=0; // 총 합계
        double avg=0; // 평균
        // class에서는 초기값 안넣으면 null, 0으로 자동 설정
        // method 에서는 무조건 초기값을 기입해줘야 한다. 안해주면 오류남.

        // 파일 읽기
        try {
            fr=new FileReader(fileName);
            System.out.println("파일 정상적으로 읽음");

            br=new BufferedReader(fr);

            while (true){
                String s=br.readLine();

                if(s==null){ // 더이상 값이 없으면
                    break;
                }
                    cnt++; // 읽은 갯수
                    total+=Integer.parseInt(s); // 합계 '+='누적
                System.out.println(s);
            }
            // 평균구하기
            avg=(double) total/cnt;
            System.out.println("총 갯수: "+cnt);
            System.out.println("총점: "+total);
            System.out.printf("평균: %.2f",avg);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e){

        } finally {
            // 자원은 오픈한 반대 순서로 닫는다.
            // 문 열고 들어가서 다시 뒤돌아 나오는 것으로 생각하면 된다.
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        scoreRead();
        System.out.println("\n출력 끝");

    }
}
