package Day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuizTokenFile_09 {

    /*
***과일목록***
상품  수량  단가  총금액
------------------------
바나나 10  5000 50000
 */

    public static void fruitList(){
        String fileName="/Users/imhyeongjun/Desktop/sist0615/file/fruit.txt";
        FileReader fr=null;
        BufferedReader br=null;

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            System.out.println("**과일목록**");
            System.out.println("상품\t수량\t단가\t총금액");
            System.out.println("==========================================");

            while (true){
                String s=br.readLine(); // multi-catch

                if(s==null){
                    break;
                }

/*              // 분리 1
                StringTokenizer st=new StringTokenizer(s,",");

                // 배열의개수만큼 반복출력
                String fName=st.nextToken();
                int su=Integer.parseInt(st.nextToken());
                int price=Integer.parseInt(st.nextToken());
                int total=su*price;

                System.out.println(fName+"\t"+su+"개\t"+price+"원\t"+total+"원");
*/
                // 분리 2
                String []data=s.split(",");
                String fName=data[0];
                int su=Integer.parseInt(data[1]);
                int price=Integer.parseInt(data[2]);
                int total=su*price;

                System.out.println(fName+"\t"+su+"개\t"+price+"원\t"+total+"원");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {

        fruitList();
    }
}
