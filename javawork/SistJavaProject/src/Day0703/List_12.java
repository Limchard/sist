package Day0703;

import java.util.List;
import java.util.Vector;

// 가장 많이사용하는 interface는 List이다.
// List인터페이스를 구현한 Vector, ArrayList
// 순차적으로 데이터 들어감, 중복데이터 허용
// 처음생성시 일정한 갯수로 생성이 된다. 그 이상의 데이터를 넣으면 공간이 자동증가한다.
public class List_12 {

    public static void main(String[] args) {

//        List<String> list=new Vector<>();
        Vector<String> list=new Vector<>();
//      List,Vector가 컬렉션이다.
//      <제네릭>
        System.out.println("초기할당크기: "+list.capacity());
        System.out.println("초기 데이타 크기: "+list.size());

        list.add("사과");
        list.add("포도");
        list.add("사과"); // 중복이 가능하다
        list.add("키위");
        list.add("수박");
        list.add("낑깡");

        System.out.println("초기할당크기: "+list.capacity());
        System.out.println("초기 데이타 크기: "+list.size());

        System.out.println("출력#1");
        for(int i=0;i< list.size();i++){
//          System.out.println(list.get(i));
          String s=list.get(i);
          System.out.println(s);
        }

        System.out.println("출력#2_for~each");
        for(String st:list){
          System.out.println(st);
        }

        System.out.println("출력#3_toArray");
        Object[] ob= list.toArray();
        for(int i=0;i<ob.length;i++){
          System.out.println(ob[i]);
        }
    }
}
