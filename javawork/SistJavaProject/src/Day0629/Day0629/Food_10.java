package Day0629.Day0629;

// class가 class를 받을 때 : extends
// clase가 interface를 받을 때 : implements
// interface가 interface를 받을 때 : extends
// implements는 다중구현 가능하다.


public class Food_10 implements FoodShop_10{


    @Override
    public void order() {
        System.out.println(SHOPNAME);
//        SHOPNAME="돈까스집"; // Interface에서 상수는 final 개념이기에 수정이 불가능하다.
        System.out.println("음식을 주문합니다.");
    }

    @Override
    public void delivery() {
        System.out.println(SHOPNAME);
        System.out.println("음식을 배달합니다.");

    }
}
