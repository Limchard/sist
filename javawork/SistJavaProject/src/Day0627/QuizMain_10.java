package Day0627;

import static Day0627.Quiz_09.SHOPNAME;

public class QuizMain_10 {

    public static void main(String[] args){

        /* ** 상품입고 **
---------------------------------
    입고된 상점: 롯데마트
---------------------------------
    상품명: 딸기
    가격: 10000원
    수량: 5팩
---------------------------------
    상품명: 쵸코파이
    가격: 5000원
    수량: 10 상자
---------------------------------
    상품명: 요거트
    가격: 2500원
    수량: 100팩
 */

        // 1번
        // set
        System.out.println("** 상품 입고 **");
        System.out.println("--------------------------------");
        Quiz_10.SHOPNAME="롯데마트";
        System.out.println("입고된 상점: "+Quiz_10.SHOPNAME);
        System.out.println("--------------------------------");
        Quiz_10 q1=new Quiz_10();
        q1.setSangpum("딸기");
        q1.dan=10000;
        q1.su=5;

        // get
        System.out.println("상품명 :"+q1.getSangpum()+"\n가격: "+q1.getDan()+"\n수량 :"+q1.getSu()+"팩");

        // 2번
        System.out.println("--------------------------------");
        Quiz_10 q2=new Quiz_10();
        q2.setSangpum("초코파이");
        q2.dan=5000;
        q2.su=10;
        System.out.println("상품명 :"+q2.getSangpum()+"\n가격: "+q2.getDan()+"\n수량 :"+q2.getSu()+"팩");

        // 3번
        System.out.println("--------------------------------");
        Quiz_10 q3=new Quiz_10();
        q3.setSangpum("요거트");
        q3.dan=2500;
        q3.su=100;
        System.out.println("상품명 :"+q3.getSangpum()+"\n가격: "+q3.getDan()+"\n수량 :"+q3.getSu()+"팩");


    }
}
