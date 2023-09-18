package Day0703;

/* Set : 데이터의 중복허용이 안됨. 순서를 유지하지 않아도 되는 집합
 * List : 데이터의 중복 허용. 순서를 유지해야 함.
 * Map : Key값을 알면 Value값을 구하기 가능하다.
 * 위 셋중에 List가 제일 중요하다.
 *
 * List : interface이므로 생성 불가
 * array list : class이므로 생성 가능
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ExHashSet_10 {

    public static void main(String[] args) {
        // 컬렉션:자료의 구조를 의미한다.(set,vector,arraylist)
        // 컬렉션이 복수의 자료형을 저장으나 안정성이 조금 떨어질 수 있다. 그래서 나온것이 제네릭이다.
        // (인터페이스 or 클래스)<데이터형> 참조변수명(객체이름)=new 클래스명<데이터형>;

        Set<String> set1=new HashSet<String>();
        // Set에 String데이터를 담겠다-Set은 인터페이스이므로 객체생성이 불가능하다.

        // 추가... 배열에 비해 가변적이다.
        set1.add("사과");
        set1.add("포도");
        set1.add("사과"); // 중복되었으므로 갯수포함 안됨.
        set1.add("키위");
        set1.add("오렌지");
        set1.add("바나나");

        System.out.println("데이터 갯수: "+set1.size());
        System.out.println();

        System.out.println("출력#1_for~each");
        for(String s:set1){
            System.out.println(s);
        }
        System.out.println();

        System.out.println("출력#2_Iterator");
        Iterator<String> iter= set1.iterator();
        while(iter.hasNext()){  // 돌려줄게 있으면 true,
            System.out.println(iter.next());
        }
        System.out.println();
        System.out.println("출력#3_for");
        Object[] ob=set1.toArray();
        for(int i=0;i< ob.length;i++){
            System.out.println(ob[i]);
        }

        // 모든데이터 삭제
        set1.clear();

        if(set1.isEmpty())
            System.out.println("Set타입안에 데이터가 없다."); //true
        else
            System.out.println("Set타입안에 데이터가 있다."); // false

    }
}
