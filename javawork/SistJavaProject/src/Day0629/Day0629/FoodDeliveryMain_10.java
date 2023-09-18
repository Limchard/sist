package Day0629.Day0629;

public class FoodDeliveryMain_10 {
    public static void main(String[] args) {

        // 일반적인 생성

        Food_10 fds=new Food_10();
        fds.order();
        fds.delivery();
        System.out.println("--------------");

        // 다형성

        FoodShop_10 fds1=new Food_10();
        fds1.order();
        fds1.delivery();


    }
}
