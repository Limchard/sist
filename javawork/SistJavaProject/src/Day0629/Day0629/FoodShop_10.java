package Day0629.Day0629;

public interface FoodShop_10 {

    // 인터페이스는 상수와 추상메서드만 선언이 가능합니다.
    // abstract 생략 가능.

    String SHOPNAME="보슬보슬"; // 상수
    // 인터페이스에서 담는 상수는 앞에 final이 생략되어있다고 생각하면 편하다... final 생략

    public void order();
    public void delivery();
}
