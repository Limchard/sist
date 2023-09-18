package Day0703;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class ArrayUnit_13 {

    public static void write(String title,List<String> list){
        System.out.println("***"+title+"***");
        for (int i=0;i< list.size();i++){
            System.out.println(i+":"+list.get(i));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // List의 여러가지 메서드를 확인 및 연습

        String[] data={"영주","순영","연주","진평"};

        // 배열의 데이터를 list에 넣기
        List<String> list=new ArrayList<>();

        for(String d:data){
            list.add(d);
        }
        write("초기에 배열데이타 add 후 출력",list);

        //////////////////////////////////////////////////
        System.out.println("1번 인덱스 삭제하기");
        list.remove(1);
        write("1번 삭제후 결과",list);
        /////////////////////////////////////////////////
        System.out.println("현규 추가하기");
        list.add("현규");
        write("현규 추가 후 출력",list);
        ////////////////////////////////////////////////
        System.out.println("값 변경");
        list.set(0,"영환");
        write("0번 인덱스 변경 후 출력",list);
        ///////////////////////////////////////////////
        System.out.println("전체삭제");
        list.clear();
        System.out.println("크기: "+list.size());
    }
}
