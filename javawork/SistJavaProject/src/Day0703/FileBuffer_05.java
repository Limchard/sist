package Day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileBuffer_05 {

    
    public static void read1(){
        String fileName="/Users/imhyeongjun/Desktop/sist0615/file/meeo.txt";
        BufferedReader br=null;
        FileReader fr=null;



        try{
            fr=new FileReader(fileName);
            System.out.println("파일을 열었어요!!");

            br=new BufferedReader(fr);

            while(true){
                String f= br.readLine();

                if(f==null) {
                    break;
                }
                System.out.println(f);
            }

        }
        catch (FileNotFoundException e) {
 //           throw new RuntimeException(e);
            System.out.println("kimoring"+e.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
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
        read1();
        System.out.println("메모 종료");

    }
}
