package Day0629.Day0629;
/*
Shop 클래스

sangpum 상품명
su 개수

인자있는 생성자
출력메서드 writeShop()
-상품과 개수를 출력
=====================================
MyCart
price 가격
Shop을 생성받아 생성자 완셩
writeShop() 메서드 오버라이드해서 가격 추가.
====================================
메인에서 출력
상품,개수,가격 모두 있는 메서드 출력
 */

class Shop {
    String sangpum;
    int su;

    public Shop(String sangpum, int su) {
        this.sangpum = sangpum;
        this.su = su;
    }

    public void writeShop() {
        System.out.println("상품명: "+sangpum+"\n개수: "+su);
    }
}

class MyCart extends Shop {
    int price;
    public MyCart(String sangpum, int su, int price) {
        super(sangpum, su);
        this.price=price;
    }

    @Override
    public void writeShop() {
        super.writeShop();
        System.out.println("가격: "+price);
    }
}

public class Inheri_06 {

    public static void main(String[] args) {

        MyCart mc=new MyCart("아이폰",12,1200000);
        mc.writeShop();

    }
}
