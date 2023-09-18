package Day0704;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class VectorBoard_02 {

    // 값을 담자.
    //Vector list=new Vector();
    List<Board_02> list=new Vector(); // List는 interface이다. Vector는 클래스이다.
    // 클래스 타입으로 지정했으므로 데이터를 꺼내고 받을 때도 클래스이어야 한다.

    // 입력 메서드 호출
    public void inputBoard(){
        Scanner sc=new Scanner(System.in);
        String writer,subject,content;

        System.out.println("작성자명?");
        writer=sc.nextLine();
        System.out.println("제목?");
        subject=sc.nextLine();
        System.out.println("내용?");
        content=sc.nextLine();

        //Board_02 data=new Board_02(writer,subject,content);
        Board_02 data=new Board_02();
        data.setWriter(writer);
        data.setSubject(subject);
        data.setContent(content);

        list.add(data);

        System.out.println("현재데이터 갯수: "+list.size());
    }

    // 출력 메서드 호출
    public void writeBoard(){
        System.out.println("**게시판 출력**");
        System.out.println("================================");

        for(int i=0;i< list.size();i++){
            Board_02 b=list.get(i); // 리스트내에 지정된 위치에 있는 요소값을 돌려준다.

            System.out.println("번호: "+(i+1)+"\t작성자: "+b.getWriter());
            System.out.println("제목: "+b.getSubject());
            System.out.println("내용: "+b.getContent());
            System.out.println("------------------------------------");
        }
    }


    public static void main(String[] args) {
        //메서드가 static이 아니라서 생성하고 불러올 수 있다
        //static이라면 메서드명만으로 생성 가능
        VectorBoard_02 vb=new VectorBoard_02();
//        vb.inputBoard();
        Scanner sc=new Scanner(System.in);
        int n;

        while (true){
            System.out.println("1.추가    2.전체출력     9.종료 ");
            n=Integer.parseInt(sc.nextLine());

            if(n==1){
                vb.inputBoard();
            } else if (n==2) {
                vb.writeBoard();
            } else if (n==9) {
                System.out.println("프로그램 종료");
                break;
            } else {
                System.out.println("잘못입력했어요");
                continue;
            }
        }
    }
}
