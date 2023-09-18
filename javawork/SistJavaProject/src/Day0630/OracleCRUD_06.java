package Day0630;

import java.util.Scanner;

abstract class Command{
    abstract public void write();


}
////////////////////////////////////////////////////
class Insert1 extends Command{

    @Override
    public void write() {
        System.out.println("추가합니다.");
    }
}
////////////////////////////////////////////////////
class List extends Command {

    @Override
    public void write() {
        System.out.println("조회합니다.");
    }
}
////////////////////////////////////////////////////
class Modify extends Command{

    @Override
    public void write() {
        System.out.println("수정합니다.");
    }
}
////////////////////////////////////////////////////
class Delete1 extends Command{

    @Override
    public void write() {
        System.out.println("삭제합니다.");
    }
}
////////////////////////////////////////////////////
public class OracleCRUD_06 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        Command command=null;
        int n;

        while(true){
            System.out.println("1.추가  2.조회  3.수정  4.삭제  0.종료");
            System.out.println("================================");
            n=sc.nextInt();

            switch (n){
                case 1:
                    command=new Insert1(); // 다른 class를 불러와야 하니까 new로 생성해서 가져온다.
                    break;
                case 2:
                    command=new List();
                    break;
                case 3:
                    command=new Modify();
                    break;
                case 4:
                    command=new Delete1();
                    break;
                case 0:
                    System.out.println("종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("다시 입력해주세요");
                    break;
            }
            if(n<=4){
                command.write();
            }
        }
    }
}
