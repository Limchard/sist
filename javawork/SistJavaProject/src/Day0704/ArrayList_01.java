package Day0704;

import java.util.ArrayList;

public class ArrayList_01 {

    public static void main(String[] args) {

        String[] flowers={"장미꽃","프리지아","벚꽃","수국"};
        // 임플리먼트 한 클래스? 임플리먼트?
        // 객체 삽입, 삭제할 수 있는 컨테이너 클래스를 생성해주자.
        ArrayList<String> list=new ArrayList<>();
        //리스트와 어레이 리스트의 차이 인터페이스와 그걸 반영한 클래스

        // 데이터 담기
        for(String f:flowers){
            list.add(f);  // 삽입
        }

        System.out.println("size: "+list.size());
/*
        // 이건 내가 한거. 일반 배열로 list가 아니다. 나중에 수정 불가.
        System.out.println("#출력1_for");
        for(int i=0;i<flowers.length;i++){
            System.out.println(flowers[i]);
        }
 */

        System.out.println("#출력1_for");
        for(int i=0;i<flowers.length;i++){
            String s=list.get(i);
            System.out.println(s);
        }

        System.out.println("#출력2_for-each");
        for(String e:list){
            System.out.println(e);
        }




    }
}
