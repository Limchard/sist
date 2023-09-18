package Day0630;

class Market{

    private String sangpum;
    private int su;


    // 디폴트 생성자 (생성자 : 생성과 동시에 초기화)(
    public Market(){  // 디폴트 생성자에도 값을 지정해줄 수 있다.
        sangpum="딸기";
        su=5;
    }

    // 명시적 생성자
    public Market(String sangpum,int su){
        this.sangpum=sangpum;
        this.su=su;
    }

    public void getMarket(){
        System.out.println("상품명: "+sangpum);
        System.out.println("수량: "+su);
    }
}

//////////////////////////////////////////////
class MyMarket extends Market{
    private int price;

    // 디폴트
    public MyMarket() {
        price=5000;
    }

    // 명시적
    public MyMarket(String sangpum, int su, int price) {
        super(sangpum,su);
        this.price=price;
    }

    @Override
    public void getMarket() {
        super.getMarket();
        System.out.println("단가: "+price);
    }
}

//////////////////////////////////////////////
public class ReivewInheri_01 {

    public static void main(String[] args) {

        // 디폴트 생성자 출력
        MyMarket m1=new MyMarket();
        m1.getMarket();



        // 명시적 생성자 출력
        MyMarket m2=new MyMarket("아이폰",23,20000);
        m2.getMarket();

    }
}
